package com.dragon.web.controller.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dragon.cms.domain.CmsFile;
import com.dragon.cms.service.ICmsFileService;
import com.dragon.common.core.controller.BaseController;
import com.dragon.common.utils.file.FileTypeUtils;
import com.dragon.common.utils.oss.OSSClientUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.dragon.common.config.BlogConfig;
import com.dragon.common.config.ServerConfig;
import com.dragon.common.constant.Constants;
import com.dragon.common.core.domain.AjaxResult;
import com.dragon.common.utils.StringUtils;
import com.dragon.common.utils.file.FileUploadUtils;
import com.dragon.common.utils.file.FileUtils;

/**
 * 通用请求处理
 * 
 * @author dragon
 */
@Controller
public class CommonController extends BaseController
{
    private static final Logger log = LoggerFactory.getLogger(CommonController.class);

    @Autowired
    private ServerConfig serverConfig;

    @Autowired
    private OSSClientUtil ossClientUtil;

    @Autowired
    private ICmsFileService cmsFileService;

    private static final String FILE_DELIMETER = ",";

    /**
     * 本地通用下载请求
     * 
     * @param fileName 文件名称
     * @param delete 是否删除
     */
    @GetMapping("common/download")
    public void fileDownload(String fileName, Boolean delete, HttpServletResponse response, HttpServletRequest request)
    {
        try
        {
            if (!FileUtils.checkAllowDownload(fileName))
            {
                throw new Exception(StringUtils.format("文件名称({})非法，不允许下载。 ", fileName));
            }
            String realFileName = System.currentTimeMillis() + fileName.substring(fileName.indexOf("_") + 1);
            String filePath = BlogConfig.getDownloadPath() + fileName;

            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            FileUtils.setAttachmentResponseHeader(response, realFileName);
            FileUtils.writeBytes(filePath, response.getOutputStream());
            if (delete)
            {
                FileUtils.deleteFile(filePath);
            }
        }
        catch (Exception e)
        {
            log.error("下载文件失败", e);
        }
    }

    /**
     * 本地通用上传请求（单个）
     */
    @PostMapping("/common/upload")
    @ResponseBody
    public AjaxResult uploadFile(MultipartFile file) throws Exception
    {
        try
        {
            // 上传文件路径
            String filePath = BlogConfig.getUploadPath();
            // 上传并返回新文件名称
            String fileName = FileUploadUtils.upload(filePath, file);
            String url = serverConfig.getUrl() + fileName;
            AjaxResult ajax = AjaxResult.success();
            ajax.put("fileName", fileName);
            ajax.put("url", url);
            return ajax;
        }
        catch (Exception e)
        {
            return AjaxResult.error(e.getMessage());
        }
    }

    /**
     * 本地通用上传请求（多个）
     */
    @PostMapping("/common/uploads")
    @ResponseBody
    public AjaxResult uploadFiles(List<MultipartFile> files) throws Exception
    {
        try
        {
            // 上传文件路径
            String filePath = BlogConfig.getUploadPath();
            List<String> fileNames = new ArrayList<String>();
            List<String> urls = new ArrayList<String>();
            for (MultipartFile file : files)
            {
                // 上传并返回新文件名称
                String fileName = FileUploadUtils.upload(filePath, file);
                String url = serverConfig.getUrl() + fileName;
                fileNames.add(fileName);
                urls.add(url);
            }
            AjaxResult ajax = AjaxResult.success();
            ajax.put("fileNames", StringUtils.join(fileNames, FILE_DELIMETER));
            ajax.put("urls", StringUtils.join(urls, FILE_DELIMETER));
            return ajax;
        }
        catch (Exception e)
        {
            return AjaxResult.error(e.getMessage());
        }
    }

    /**
     * 本地资源通用下载
     */
    @GetMapping("/common/download/resource")
    public void resourceDownload(String resource, HttpServletRequest request, HttpServletResponse response)
            throws Exception
    {
        try
        {
            if (!FileUtils.checkAllowDownload(resource))
            {
                throw new Exception(StringUtils.format("资源文件({})非法，不允许下载。 ", resource));
            }
            // 本地资源路径
            String localPath = BlogConfig.getProfile();
            // 数据库资源地址
            String downloadPath = localPath + StringUtils.substringAfter(resource, Constants.RESOURCE_PREFIX);
            // 下载名称
            String downloadName = StringUtils.substringAfterLast(downloadPath, "/");
            response.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            FileUtils.setAttachmentResponseHeader(response, downloadName);
            FileUtils.writeBytes(downloadPath, response.getOutputStream());
        }
        catch (Exception e)
        {
            log.error("下载文件失败", e);
        }
    }

    /**
     * OSS通用上传请求（单个）
     */
    @PostMapping("/common/uploadToOss")
    @ResponseBody
    public AjaxResult uploadFileToOss(MultipartFile file) throws Exception {
        try {
            Map<String, Object> resultMap = new HashMap<>(2);
            Map<String, String> result = ossClientUtil.uploadMultipartFileToOss(file);
            CmsFile cmsFile = new CmsFile();
            String originalFilename = file.getOriginalFilename();
            if(result != null && result.size() > 0){
                String substring = originalFilename.substring(originalFilename.lastIndexOf(".") + 1).toLowerCase();
                String ossFileName = result.get("ossFileName") == null ? "" : result.get("ossFileName") + "";
                String fileUrl = result.get("url") == null ? "" : result.get("url") + "";
                cmsFile.setFileName(originalFilename);
                cmsFile.setFileSize(String.valueOf(file.getSize()));
                cmsFile.setFileUrl(fileUrl);
                cmsFile.setType(FileTypeUtils.getContentType(substring));
                cmsFile.setOssKey(ossFileName);
                cmsFile.setSuffix(substring);
                cmsFile.setCreateBy(getLoginName());
                cmsFileService.insertCmsFile(cmsFile);
                resultMap.put("success", cmsFile);
            }else {
                resultMap.put("error", cmsFile);
            }
            AjaxResult ajax = AjaxResult.success();
            ajax.put("result", resultMap);
            return ajax;
        } catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }
    }

    /**
     * OSS通用上传请求（多个）
     */
    @PostMapping("/common/uploadsToOss")
    @ResponseBody
    public AjaxResult uploadFilesToOss(List<MultipartFile> files) throws Exception {
        try {
            // 上传文件路径
            Map<String, Object> resultMap = new HashMap<>(2);
            List<CmsFile> successList = new ArrayList<>();
            List<CmsFile> errorList = new ArrayList<>();
            for (MultipartFile file : files) {
                // 上传并返回OSS文件名称和url
                Map<String, String> result = ossClientUtil.uploadMultipartFileToOss(file);
                CmsFile cmsFile = new CmsFile();
                String originalFilename = file.getOriginalFilename();
//                int i = 1/0;
                if(result != null && result.size() > 0){
                    String substring = originalFilename.substring(originalFilename.lastIndexOf(".") + 1).toLowerCase();
                    String ossFileName = result.get("ossFileName") == null ? "" : result.get("ossFileName") + "";
                    String fileUrl = result.get("url") == null ? "" : result.get("url") + "";
                    cmsFile.setFileName(originalFilename);
                    cmsFile.setFileSize(String.valueOf(file.getSize()));
                    cmsFile.setFileUrl(fileUrl);
                    cmsFile.setType(FileTypeUtils.getContentType(substring));
                    cmsFile.setOssKey(ossFileName);
                    cmsFile.setSuffix(substring);
                    cmsFile.setCreateBy(getLoginName());
                    cmsFileService.insertCmsFile(cmsFile);
                    successList.add(cmsFile);
                }else {
                    cmsFile.setFileName(originalFilename);
                    errorList.add(cmsFile);
                }
                resultMap.put("success",successList);
                resultMap.put("error",errorList);
            }
            AjaxResult ajax = AjaxResult.success();
            ajax.put("result", resultMap);
            return ajax;
        } catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }
    }
}

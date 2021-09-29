package com.dragon.common.utils.oss;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author：Dragon Wen
 * @email：18475536452@163.com
 * @date：Created in 2021/9/25 14:38
 * @description：阿里云 OSS工具类
 * @modified By：
 * @version: $
 */
@Component
public class OSSClientUtil {
    private static final Logger log = LoggerFactory.getLogger(OSSClientUtil.class);
    /**
     * 参数在yaml配置
     */
    @Value("${oss.aliyun.endpoint}")
    private String endpoint;

    @Value("${oss.aliyun.accessKeyId}")
    private String accessKeyId;

    @Value("${oss.aliyun.accessKeySecret}")
    private String accessKeySecret;

    @Value("${oss.aliyun.bucketName}")
    private String bucketName;

    /**
     * 文件存储目录
     */
    private String fileDir = "";

    /**
     * MultipartFile文件上传
     * @param file
     * @return
     * @throws Exception
     */
    public Map<String, String> uploadMultipartFileToOss(MultipartFile file) throws Exception {
        if (file.getSize() > 10 * 1024 * 1024) {
            throw new Exception("上传文件大小不能超过10M！");
        }
        Map<String, String> result = new HashMap<>(16);
        String originalFilename = file.getOriginalFilename();
        String substring = originalFilename.substring(originalFilename.lastIndexOf(".")).toLowerCase();
        Random random = new Random();
        String name = random.nextInt(10000) + System.currentTimeMillis() + substring;
        try {
            InputStream inputStream = file.getInputStream();
            result = this.uploadFileToOSS(inputStream, name, file.getContentType());
            return result;
        } catch (Exception e) {
            log.info("文件上传失败:{}",e.getMessage());
            throw new Exception("文件上传失败");
        }
    }

    /**
     * 上传到OSS服务器 如果同名文件会覆盖服务器上的
     * @param inStream
     *            文件流
     * @param fileName
     *            文件名称 包括后缀名
     * @param contentType
     *            文件类型
     * @return
     */
    public Map<String, String> uploadFileToOSS(InputStream inStream, String fileName, String contentType) {
        String url = "";
        Map<String, String> result = new HashMap<>(16);
        String host = endpoint.replaceAll("//","//" + bucketName + ".");
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        try {
            // 创建上传Object的Metadata
            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentLength(inStream.available());
            objectMetadata.setCacheControl("no-cache");
            objectMetadata.setHeader("Pragma", "no-cache");
            objectMetadata.setContentType(contentType);
            objectMetadata.setContentDisposition("inline;filename=" + fileName);
            // 文件上传日期
            String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            // 用户上传文件时指定的前缀。
            fileDir = format + "/";
            PutObjectResult putResult = ossClient.putObject(bucketName, fileDir + fileName, inStream, objectMetadata);
            if (putResult != null) {
                url = host + "/" + fileDir + fileName;
                result.put("ossFileName",fileDir + fileName);
                result.put("url",url);
            }
        } catch (IOException e) {
            log.info("文件上传失败:{}",e.getMessage());
        } finally {
            try {
                if (inStream != null) {
                    inStream.close();
                }
            } catch (IOException e) {
                log.info(e.getMessage());
            }
            ossClient.shutdown();
        }
        return result;
    }

    /**
     * 删除OSS文件
     * @param fileName
     */
    public void delFileOSS(String fileName){
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        if(fileName != null && fileName.length() > 0) {
            ossClient.deleteObject(bucketName, fileName);
        }
    }

    /**
     * 判断OSS文件是否存在
     * @param key
     * @return
     */
    public boolean doesExist(String key){
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        boolean exist = ossClient.doesObjectExist(bucketName, key);
        return exist;
    }

    /**
     * 从OSS获取文件
     * @param key
     * @return
     * @throws IOException
     */
    public byte[] getFile(String key) throws IOException {
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        OSSObject object = null;
        try {
            object = ossClient.getObject(bucketName, key);
            InputStream inputStream = object.getObjectContent();
            ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
            byte[] buff = new byte[100];
            int rc = 0;
            while ((rc = inputStream.read(buff, 0, 100)) > 0) {
                swapStream.write(buff, 0, rc);
            }
            byte[] in2b = swapStream.toByteArray();
            return in2b;
        } catch (OSSException e) {
            // OSS在查找不到某对象时，会抛出ErrorCode为“NoSuchKey”的OSSException，而不是返回null
            if (e.getErrorCode().contains("NoSuchKey")) {
                log.info("找不到OSS文件:{}", key);
            }else {
                log.info("获取文件失败:{}",e.getMessage());
            }
        } catch (IOException e) {
            log.info("文件上传失败:{}",e.getMessage());
        } finally {
            if (object != null) {
                object.close();
            }
        }
        return null;
    }

}


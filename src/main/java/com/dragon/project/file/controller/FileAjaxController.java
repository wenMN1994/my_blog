package com.dragon.project.file.controller;

import com.dragon.framework.web.controller.BaseController;
import com.dragon.project.file.domain.FileList;
import com.dragon.project.file.domain.FilePath;
import com.dragon.project.file.service.FileService;
import com.dragon.project.system.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author：Dragon Wen
 * @email：18475536452@163.com
 * @date：Created in 2019/7/8 22:57
 * @description： 文件管理Ajax请求
 * @modified By：
 * @version: 1.0.0
 */
@Controller
@RequestMapping("/")
public class FileAjaxController extends BaseController {

    @Autowired
    private FileService fileService;

    @RequestMapping("filetypeload")
    public String fileTypeLoad(@RequestParam("type") String type, Model model){
        User user = getSysUser();

        String contentType;

        List<FileList> fileLists = null;
        List<FilePath> filePaths = null;

        switch (type) {
            case "document":
                fileLists = fileService.selectDocumentByUserId(user.getUserId(), 0L);
                model.addAttribute("files", fileLists);
                model.addAttribute("isload",1);
                break;
            case "picture":
                contentType = "image";
                fileLists = fileService.selectByUserIdAndContentTypeLikeAndFileIsTrash(user.getUserId(), contentType, 0L);
                model.addAttribute("files", fileLists);
                model.addAttribute("isload",1);
                break;
            case "music":
                contentType = "audio";
                fileLists = fileService.selectByUserIdAndContentTypeLikeAndFileIsTrash(user.getUserId(), contentType, 0L);
                model.addAttribute("files", fileLists);
                model.addAttribute("isload",1);
                break;
            case "video":
                contentType = "video";
                fileLists = fileService.selectByUserIdAndContentTypeLikeAndFileIsTrash(user.getUserId(), contentType, 0L);
                model.addAttribute("files", fileLists);
                model.addAttribute("isload",1);
                break;
            case "yasuo":
                contentType = "application";
                fileLists = fileService.selectByUserIdAndContentTypeLikeAndFileIsTrash(user.getUserId(), contentType, 0L);
                model.addAttribute("files", fileLists);
                model.addAttribute("isload",1);
                break;
            case "trash":
                fileLists = fileService.selectFileListByUserIdAndIsTrash(user.getUserId(),1L);
                filePaths = fileService.selectPathListByUserIdAndIsTrash(user.getUserId(), 1L);
                model.addAttribute("paths", filePaths);
                model.addAttribute("files", fileLists);
                model.addAttribute("istrash", 1);
                model.addAttribute("isload",1);
                break;
            case "share":
                fileLists = fileService.selectFileListByIsShareAndIsTrash(1L,1L);
                model.addAttribute("files", fileLists);
                model.addAttribute("isshare", 1);
                model.addAttribute("isload",1);
                model.addAttribute("userid",user.getUserId());
                break;

            default:
                break;
        }

        model.addAttribute("type", type);
        return "file/filetypeload";
    }
}

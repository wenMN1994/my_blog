package com.dragon.project.file.img;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author：Dragon Wen
 * @email：18475536452@163.com
 * @date：Created in 2019/7/7 19:35
 * @description： 图片管理
 * @modified By：
 * @version: 1.0.0
 */
@Controller
public class ImgController {


    @GetMapping("/file/img")
    public String img(Model model) {
        return "file/img/img";
    }
}

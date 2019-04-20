package com.dragon.blog.controller.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author：Dragon Wen
 * @email：18475536452@163.com
 * @date：Created in 2019/4/20 21:06
 * @description： 页面错误异常控制器
 * @modified By：
 * @version: $version$
 */
@Controller
@RequestMapping("/error")
public class ErrorController {

    @RequestMapping("403")
    public String error_403(){
        return "error/403";
    }

}

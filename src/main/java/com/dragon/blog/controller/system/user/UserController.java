package com.dragon.blog.controller.system.user;

import com.dragon.base.BaseController;
import com.dragon.blog.model.BlogSysUser;
import com.dragon.blog.model.BlogSysUserExample;
import com.dragon.blog.service.BlogSysUserService;
import com.dragon.utils.page.TableDataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author：Dragon Wen
 * @email：18475536452@163.com
 * @date：Created in 2019/6/11 15:44
 * @description：
 * @modified By：
 * @version: 1.0.0
 */
@Controller
@RequestMapping("/system/user")
public class UserController extends BaseController {
    private String prefix = "system/user";

    @Autowired
    private BlogSysUserService blogSysUserService;

    /**
     * 用户管理界面跳转
     * @return
     */
    @GetMapping()
    public String user() {
        return prefix + "/user";
    }

    /**
     * 获取用户列表
     * @return
     */
    @GetMapping("/list")
    @ResponseBody
    public TableDataInfo list() {
        startPage();
        BlogSysUserExample blogSysUserExample = new BlogSysUserExample();
        List<BlogSysUser> list = blogSysUserService.selectByExample(blogSysUserExample);
        return getDataTable(list);
    }

    /**
     * 新增用户
     */
    @GetMapping("/add")
    public String add(ModelMap mmap) {
//        mmap.put("roles", roleService.selectRoleAll());
        return prefix + "/add";
    }

}

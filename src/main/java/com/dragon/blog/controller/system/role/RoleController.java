package com.dragon.blog.controller.system.role;

import com.dragon.base.BaseController;
import com.dragon.blog.model.BlogSysRole;
import com.dragon.blog.model.BlogSysRoleExample;
import com.dragon.blog.service.BlogSysRoleService;
import com.dragon.utils.page.TableDataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author：Dragon Wen
 * @email：18475536452@163.com
 * @date：Created in 2019/6/13 14:24
 * @description：角色管理控制器
 * @modified By：
 * @version: 1.0.0
 */
@Controller
@RequestMapping("system/role")
public class RoleController extends BaseController {
    private String prefix = "system/role";

    @Autowired
    private BlogSysRoleService blogSysRoleService;

    @GetMapping()
    public String role() {
        return prefix + "/role";
    }

    @GetMapping("/list")
    @ResponseBody
    public TableDataInfo list() {
        startPage();
        BlogSysRoleExample blogSysRoleExample = new BlogSysRoleExample();
        List<BlogSysRole> list = blogSysRoleService.selectByExample(blogSysRoleExample);
        return getDataTable(list);
    }
}

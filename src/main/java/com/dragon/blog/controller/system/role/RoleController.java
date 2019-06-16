package com.dragon.blog.controller.system.role;

import com.dragon.base.BaseController;
import com.dragon.blog.model.BlogSysRole;
import com.dragon.blog.model.BlogSysRoleExample;
import com.dragon.blog.service.BlogSysRoleService;
import com.dragon.utils.AjaxResult;
import com.dragon.utils.page.TableDataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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

    BlogSysRoleExample blogSysRoleExample = new BlogSysRoleExample();

    @Autowired
    private BlogSysRoleService blogSysRoleService;

    /**
     * 角色管理界面跳转
     * @return
     */
    @GetMapping()
    public String role() {
        return prefix + "/role";
    }

    /**
     * 获取角色信息列表
     * @return
     */
    @GetMapping("/list")
    @ResponseBody
    public TableDataInfo list() {
        startPage();
        List<BlogSysRole> list = blogSysRoleService.selectByExample(blogSysRoleExample);
        return getDataTable(list);
    }

    /**
     * 新增角色
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存角色
     */
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(BlogSysRole blogSysRole) {
        return toAjax(blogSysRoleService.insertRole(blogSysRole));
    }

    /**
     * 修改角色
     */
    @GetMapping("/edit/{roleId}")
    public String edit(@PathVariable("roleId") Integer roleId, ModelMap modelMap) {
        modelMap.put("role", blogSysRoleService.selectByPrimaryKey(roleId));
        return prefix + "/edit";
    }

    /**
     * 修改保存角色
     */
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(BlogSysRole blogSysRole) {
        return toAjax(blogSysRoleService.updateRole(blogSysRole));
    }

    /**
     * 校验角色名称
     */
    @PostMapping("/checkRoleNameUnique")
    @ResponseBody
    public String checkRoleNameUnique(BlogSysRole blogSysRole) {
        return blogSysRoleService.checkRoleNameUnique(blogSysRole);
    }

    /**
     * 校验角色权限
     */
    @PostMapping("/checkRoleKeyUnique")
    @ResponseBody
    public String checkRoleKeyUnique(BlogSysRole blogSysRole) {
        return blogSysRoleService.checkRoleKeyUnique(blogSysRole);
    }
}

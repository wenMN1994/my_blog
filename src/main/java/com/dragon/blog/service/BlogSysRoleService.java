package com.dragon.blog.service;

import com.dragon.base.BaseService;
import com.dragon.blog.model.BlogSysRole;
import com.dragon.blog.model.BlogSysRoleExample;

/**
* BlogSysRoleService接口
* Created by Dragon.Wen on 2019/6/10.
*/
public interface BlogSysRoleService extends BaseService<BlogSysRole, BlogSysRoleExample> {

    /**
     * 修改保存角色信息
     * @param blogSysRole
     * @return
     */
    int updateRole(BlogSysRole blogSysRole);

    /**
     * 校验角色名称是否唯一
     *
     * @param blogSysRole 角色信息
     * @return 结果
     */
    String checkRoleNameUnique(BlogSysRole blogSysRole);

    /**
     * 校验角色权限是否唯一
     *
     * @param blogSysRole 角色信息
     * @return 结果
     */
    String checkRoleKeyUnique(BlogSysRole blogSysRole);

    /**
     * 新增保存角色信息
     *
     * @param blogSysRole 角色信息
     * @return 结果
     */
    int insertRole(BlogSysRole blogSysRole);
}
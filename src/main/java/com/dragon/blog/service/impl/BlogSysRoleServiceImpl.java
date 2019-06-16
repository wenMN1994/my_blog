package com.dragon.blog.service.impl;

import com.dragon.annotation.BaseService;
import com.dragon.base.BaseServiceImpl;
import com.dragon.blog.mapper.BlogSysRoleMapper;
import com.dragon.blog.mapper.BlogSysRoleMenuMapper;
import com.dragon.blog.model.*;
import com.dragon.blog.service.BlogSysRoleService;
import com.dragon.common.constant.UserConstants;
import com.dragon.utils.StringUtils;
import com.dragon.utils.security.ShiroUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
* BlogSysRoleService实现
* Created by Dragon.Wen on 2019/6/10.
*/
@Service
@Transactional
@BaseService
public class BlogSysRoleServiceImpl extends BaseServiceImpl<BlogSysRoleMapper, BlogSysRole, BlogSysRoleExample> implements BlogSysRoleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlogSysRoleServiceImpl.class);

    BlogSysRoleExample blogSysRoleExample = new BlogSysRoleExample();

    BlogSysRoleMenuExample blogSysRoleMenuExample = new BlogSysRoleMenuExample();

    @Autowired
    BlogSysRoleMapper blogSysRoleMapper;

    @Autowired
    BlogSysRoleMenuMapper blogSysRoleMenuMapper;

    /**
     * 修改保存角色信息
     * @param blogSysRole
     * @return
     */
    @Override
    public int updateRole(BlogSysRole blogSysRole) {
        blogSysRole.setUpdateBy(ShiroUtils.getLoginName());
        // 修改角色信息
        blogSysRoleMapper.updateByPrimaryKey(blogSysRole);
        ShiroUtils.clearCachedAuthorizationInfo();
        // 删除角色与菜单关联
        blogSysRoleMenuExample.createCriteria().andRoleIdEqualTo(blogSysRole.getRoleId());
        blogSysRoleMenuMapper.deleteByExample(blogSysRoleMenuExample);
        return insertRoleMenu(blogSysRole);
    }

    /**
     * 校验角色名称是否唯一
     *
     * @param blogSysRole 角色信息
     * @return 结果
     */
    @Override
    public String checkRoleNameUnique(BlogSysRole blogSysRole) {
        Integer roleId = StringUtils.isNull(blogSysRole.getRoleId()) ? -1 : blogSysRole.getRoleId();
        blogSysRoleExample.createCriteria().andRoleNameEqualTo(blogSysRole.getRoleName());
        BlogSysRole info = (BlogSysRole) blogSysRoleMapper.selectByExample(blogSysRoleExample);
        if (StringUtils.isNotNull(info) && info.getRoleId().intValue() != roleId.intValue()) {
            return UserConstants.ROLE_NAME_NOT_UNIQUE;
        }
        return UserConstants.ROLE_NAME_UNIQUE;
    }

    /**
     * 校验角色权限是否唯一
     *
     * @param blogSysRole 角色信息
     * @return 结果
     */
    @Override
    public String checkRoleKeyUnique(BlogSysRole blogSysRole) {
        Integer roleId = StringUtils.isNull(blogSysRole.getRoleId()) ? -1 : blogSysRole.getRoleId();
        blogSysRoleExample.createCriteria().andRoleKeyEqualTo(blogSysRole.getRoleKey());
        BlogSysRole info = (BlogSysRole) blogSysRoleMapper.selectByExample(blogSysRoleExample);
        if (StringUtils.isNotNull(info) && info.getRoleId().intValue() != roleId.intValue()) {
            return UserConstants.ROLE_KEY_NOT_UNIQUE;
        }
        return UserConstants.ROLE_KEY_UNIQUE;
    }

    /**
     * 新增保存角色信息
     *
     * @param blogSysRole 角色信息
     * @return 结果
     */
    @Override
    public int insertRole(BlogSysRole blogSysRole) {
        blogSysRole.setCreateBy(ShiroUtils.getLoginName());
        // 新增角色信息
        blogSysRoleMapper.insert(blogSysRole);
        ShiroUtils.clearCachedAuthorizationInfo();
        return insertRoleMenu(blogSysRole);
    }

    private int insertRoleMenu(BlogSysRole blogSysRole) {
        int rows = 1;
        // 新增用户与角色管理
        List<BlogSysRoleMenu> list = new ArrayList<BlogSysRoleMenu>();
        for (Integer menuId : blogSysRole.getMenuIds()) {
            BlogSysRoleMenu rm = new BlogSysRoleMenu();
            rm.setRoleId(blogSysRole.getRoleId());
            rm.setMenuId(menuId);
            list.add(rm);
        }
        if (list.size() > 0) {
            rows = blogSysRoleMenuMapper.batchRoleMenu(list);
        }
        return rows;
    }
}
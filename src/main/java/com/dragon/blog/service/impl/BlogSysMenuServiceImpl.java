package com.dragon.blog.service.impl;

import com.dragon.annotation.BaseService;
import com.dragon.base.BaseServiceImpl;
import com.dragon.blog.mapper.BlogSysMenuMapper;
import com.dragon.blog.model.BlogSysMenu;
import com.dragon.blog.model.BlogSysMenuExample;
import com.dragon.blog.model.BlogSysRole;
import com.dragon.blog.service.BlogSysMenuService;
import com.dragon.utils.StringUtils;
import com.dragon.web.domain.Ztree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
* BlogSysMenuService实现
* Created by Dragon.Wen on 2019/6/10.
*/
@Service
@Transactional
@BaseService
public class BlogSysMenuServiceImpl extends BaseServiceImpl<BlogSysMenuMapper, BlogSysMenu, BlogSysMenuExample> implements BlogSysMenuService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlogSysMenuServiceImpl.class);

    BlogSysMenuExample blogSysMenuExample = new BlogSysMenuExample();

    @Autowired
    BlogSysMenuMapper blogSysMenuMapper;

    @Override
    public List<Ztree> roleMenuTreeData(BlogSysRole blogSysRole) {
        Integer roleId = blogSysRole.getRoleId();
        List<Ztree> ztrees = new ArrayList<Ztree>();
        List<BlogSysMenu> menuList = blogSysMenuMapper.selectByExample(blogSysMenuExample);
        if (StringUtils.isNotNull(roleId)) {
            List<String> roleMenuList = (List<String>) blogSysMenuMapper.selectByPrimaryKey(roleId);
            ztrees = initZtree(menuList, roleMenuList, true);
        } else {
            ztrees = initZtree(menuList, null, true);
        }
        return ztrees;
    }

    /**
     * 对象转菜单树
     *
     * @param menuList 菜单列表
     * @return 树结构列表
     */
    public List<Ztree> initZtree(List<BlogSysMenu> menuList) {
        return initZtree(menuList, null, false);
    }

    /**
     * 对象转菜单树
     *
     * @param menuList     菜单列表
     * @param roleMenuList 角色已存在菜单列表
     * @param permsFlag    是否需要显示权限标识
     * @return 树结构列表
     */
    public List<Ztree> initZtree(List<BlogSysMenu> menuList, List<String> roleMenuList, boolean permsFlag) {
        List<Ztree> ztrees = new ArrayList<Ztree>();
        boolean isCheck = StringUtils.isNotNull(roleMenuList);
        for (BlogSysMenu menu : menuList) {
            Ztree ztree = new Ztree();
            ztree.setId(menu.getMenuId());
            ztree.setpId(menu.getParentId());
            ztree.setName(transMenuName(menu, roleMenuList, permsFlag));
            ztree.setTitle(menu.getMenuName());
            if (isCheck) {
                ztree.setChecked(roleMenuList.contains(menu.getMenuId() + menu.getPerms()));
            }
            ztrees.add(ztree);
        }
        return ztrees;
    }

    public String transMenuName(BlogSysMenu menu, List<String> roleMenuList, boolean permsFlag) {
        StringBuffer sb = new StringBuffer();
        sb.append(menu.getMenuName());
        if (permsFlag) {
            sb.append("<font color=\"#888\">&nbsp;&nbsp;&nbsp;" + menu.getPerms() + "</font>");
        }
        return sb.toString();
    }
}
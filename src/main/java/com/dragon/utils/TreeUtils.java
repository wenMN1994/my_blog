package com.dragon.utils;

import com.dragon.blog.model.BlogSysMenu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author：Dragon Wen
 * @email：18475536452@163.com
 * @date：Created in 2019/6/5 22:34
 * @description： 权限数据处理
 * @modified By：
 * @version: 1.0.0
 */
public class TreeUtils {
    /**
     * 根据父节点的ID获取所有子节点
     *
     * @param list     分类表
     * @param parentId 传入的父节点ID
     * @return String
     */
    public static List<BlogSysMenu> getChildPerms(List<BlogSysMenu> list, int parentId) {
        List<BlogSysMenu> returnList = new ArrayList<BlogSysMenu>();
        for (Iterator<BlogSysMenu> iterator = list.iterator(); iterator.hasNext(); ) {
            BlogSysMenu t = (BlogSysMenu) iterator.next();
            // 一、根据传入的某个父节点ID,遍历该父节点的所有子节点
            if (t.getParentId() == parentId) {
                recursionFn(list, t);
                returnList.add(t);
            }
        }
        return returnList;
    }

    /**
     * 递归列表
     *
     * @param list
     * @param t
     */
    private static void recursionFn(List<BlogSysMenu> list, BlogSysMenu t) {
        // 得到子节点列表
        List<BlogSysMenu> childList = getChildList(list, t);
        t.setChildren(childList);
        for (BlogSysMenu tChild : childList) {
            if (hasChild(list, tChild)) {
                // 判断是否有子节点
                Iterator<BlogSysMenu> it = childList.iterator();
                while (it.hasNext()) {
                    BlogSysMenu n = (BlogSysMenu) it.next();
                    recursionFn(list, n);
                }
            }
        }
    }

    /**
     * 得到子节点列表
     */
    private static List<BlogSysMenu> getChildList(List<BlogSysMenu> list, BlogSysMenu t) {

        List<BlogSysMenu> tlist = new ArrayList<BlogSysMenu>();
        Iterator<BlogSysMenu> it = list.iterator();
        while (it.hasNext()) {
            BlogSysMenu n = (BlogSysMenu) it.next();
            if (n.getParentId().longValue() == t.getMenuId().longValue()) {
                tlist.add(n);
            }
        }
        return tlist;
    }

    List<BlogSysMenu> returnList = new ArrayList<BlogSysMenu>();

    /**
     * 根据父节点的ID获取所有子节点
     *
     * @param list   分类表
     * @param typeId 传入的父节点ID
     * @param prefix 子节点前缀
     */
    public List<BlogSysMenu> getChildPerms(List<BlogSysMenu> list, int typeId, String prefix) {
        if (list == null) {
            return null;
        }
        for (Iterator<BlogSysMenu> iterator = list.iterator(); iterator.hasNext(); ) {
            BlogSysMenu node = (BlogSysMenu) iterator.next();
            // 一、根据传入的某个父节点ID,遍历该父节点的所有子节点
            if (node.getParentId() == typeId) {
                recursionFn(list, node, prefix);
            }
            // 二、遍历所有的父节点下的所有子节点
            /*
             * if (node.getParentId()==0) { recursionFn(list, node); }
             */
        }
        return returnList;
    }

    private void recursionFn(List<BlogSysMenu> list, BlogSysMenu node, String p) {
        // 得到子节点列表
        List<BlogSysMenu> childList = getChildList(list, node);
        if (hasChild(list, node)) {
            // 判断是否有子节点
            returnList.add(node);
            Iterator<BlogSysMenu> it = childList.iterator();
            while (it.hasNext()) {
                BlogSysMenu n = (BlogSysMenu) it.next();
                n.setMenuName(p + n.getMenuName());
                recursionFn(list, n, p + p);
            }
        } else {
            returnList.add(node);
        }
    }

    /**
     * 判断是否有子节点
     */
    private static boolean hasChild(List<BlogSysMenu> list, BlogSysMenu t) {
        return getChildList(list, t).size() > 0 ? true : false;
    }
}

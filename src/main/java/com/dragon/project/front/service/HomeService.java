package com.dragon.project.front.service;

import com.dragon.project.blog.blog.domain.Blog;

import java.util.List;

/**
 * @author：Dragon Wen
 * @email：18475536452@163.com
 * @date：Created in 2019/7/26 14:54
 * @description：前端首页服务层接口
 * @modified By：
 * @version: 1.0.0
 */
public interface HomeService {
    /**
     * 获取最新的blog
     * @param blog
     * @return 获取最新的blog集合
     */
    List<Blog> selectFrontBlogList(Blog blog);
}

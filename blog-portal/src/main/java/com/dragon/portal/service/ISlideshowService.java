package com.dragon.portal.service;

import java.util.List;

import com.dragon.common.core.domain.model.LoginUser;
import com.dragon.portal.domain.Slideshow;

/**
 * 轮播图管理Service接口
 *
 * @author dragon
 * @date 2022-08-20
 */
public interface ISlideshowService {
    /**
     * 查询轮播图管理
     *
     * @param slideshowId 轮播图管理主键
     * @return 轮播图管理
     */
    public Slideshow selectSlideshowBySlideshowId(Long slideshowId);

    /**
     * 查询轮播图管理列表
     *
     * @param slideshow 轮播图管理
     * @return 轮播图管理集合
     */
    public List<Slideshow> selectSlideshowList(Slideshow slideshow);

    /**
     * 新增轮播图管理
     *
     * @param slideshow 轮播图管理
     * @param loginUser 登录用户信息
     * @return 结果
     */
    public int insertSlideshow(Slideshow slideshow, LoginUser loginUser);

    /**
     * 修改轮播图管理
     *
     * @param slideshow 轮播图管理
     * @param loginUser 登录用户信息
     * @return 结果
     */
    public int updateSlideshow(Slideshow slideshow, LoginUser loginUser);

    /**
     * 批量删除轮播图管理
     *
     * @param slideshowIds 需要删除的轮播图管理主键集合
     * @param loginUser 登录用户信息
     * @return 结果
     */
    public int deleteSlideshowBySlideshowIds(Long[] slideshowIds, LoginUser loginUser);

    /**
     * 删除轮播图管理信息
     *
     * @param slideshowId 轮播图管理主键
     * @param loginUser 登录用户信息
     * @return 结果
     */
    public int deleteSlideshowBySlideshowId(Long slideshowId, LoginUser loginUser);
}

package com.dragon.portal.mapper;

import java.util.Date;
import java.util.List;

import com.dragon.common.core.domain.model.LoginUser;
import com.dragon.portal.domain.Slideshow;
import org.apache.ibatis.annotations.Param;

/**
 * 轮播图管理Mapper接口
 *
 * @author dragon
 * @date 2022-08-20
 */
public interface SlideshowMapper {
    /**
     * 查询轮播图
     *
     * @param slideshowId 轮播图管理主键
     * @return 轮播图
     */
    public Slideshow selectSlideshowBySlideshowId(Long slideshowId);

    /**
     * 查询轮播图列表
     *
     * @param slideshow 轮播图
     * @return 轮播图管理集合
     */
    public List<Slideshow> selectSlideshowList(Slideshow slideshow);

    /**
     * 新增轮播图
     *
     * @param slideshow 轮播图
     * @return 结果
     */
    public int insertSlideshow(Slideshow slideshow);

    /**
     * 修改轮播图
     *
     * @param slideshow 轮播图
     * @return 结果
     */
    public int updateSlideshow(Slideshow slideshow);

    /**
     * 删除轮播图
     *
     * @param slideshowId 轮播图主键
     * @param loginUser 登录用户信息
     * @param nowDate 当前系统时间
     * @return 结果
     */
    public int deleteSlideshowBySlideshowId(@Param("slideshowId") Long slideshowId, @Param("loginUser") LoginUser loginUser, @Param("nowDate") Date nowDate);

    /**
     * 批量删除轮播图
     *
     * @param slideshowIds 需要删除的数据主键集合
     * @param loginUser 登录用户信息
     * @param nowDate 当前系统时间
     * @return 结果
     */
    public int deleteSlideshowBySlideshowIds(@Param("slideshowIds") Long[] slideshowIds, @Param("loginUser") LoginUser loginUser, @Param("nowDate") Date nowDate);
}

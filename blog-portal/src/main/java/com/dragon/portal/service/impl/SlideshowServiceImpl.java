package com.dragon.portal.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.dragon.common.constant.CacheConstants;
import com.dragon.common.core.domain.model.LoginUser;
import com.dragon.common.core.redis.RedisCache;
import com.dragon.common.utils.DateUtils;
import com.dragon.system.domain.SysFile;
import com.dragon.system.service.ISysFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dragon.portal.mapper.SlideshowMapper;
import com.dragon.portal.domain.Slideshow;
import com.dragon.portal.service.ISlideshowService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 轮播图管理Service业务层处理
 *
 * @author dragon
 * @date 2022-08-20
 */
@Service
public class SlideshowServiceImpl implements ISlideshowService {

    @Autowired
    private ISysFileService iSysFileService;

    @Autowired
    private SlideshowMapper slideshowMapper;

    @Autowired
    private RedisCache redisCache;

    /**
     * 查询轮播图
     *
     * @param slideshowId 轮播图主键
     * @return 轮播图
     */
    @Override
    public Slideshow selectSlideshowBySlideshowId(Long slideshowId) {
        Slideshow slideshow = slideshowMapper.selectSlideshowBySlideshowId(slideshowId);
        if(slideshow != null && slideshow.getSlideshow() != null){
            SysFile sysFile = iSysFileService.selectSysFileByFileId(slideshow.getSlideshow());
            if(sysFile != null){
                slideshow.setSlideshowImageUrl(sysFile.getFileUrl());
            }
        }
        return slideshow;
    }

    /**
     * 查询轮播图列表
     *
     * @param slideshow 轮播图
     * @return 轮播图
     */
    @Override
    public List<Slideshow> selectSlideshowList(Slideshow slideshow) {
        List<Slideshow> slideshowList = slideshowMapper.selectSlideshowList(slideshow);
        for (Slideshow item : slideshowList) {
            if(item.getSlideshow() != null){
                SysFile sysFile = iSysFileService.selectSysFileByFileId(item.getSlideshow());
                if(sysFile != null){
                    item.setSlideshowImageUrl(sysFile.getFileUrl());
                }
            }
        }
        return slideshowList;
    }

    /**
     * 新增轮播图
     *
     * @param slideshow 轮播图
     * @param loginUser 登录用户信息
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertSlideshow(Slideshow slideshow, LoginUser loginUser) {
        try {
            SysFile sysFile = new SysFile();
            sysFile.setFileUrl(slideshow.getSlideshowImageUrl());
            sysFile.setIsEnable("0");
            sysFile.setCreateBy(loginUser.getUsername());
            iSysFileService.insertSysFile(sysFile);
            slideshow.setSlideshow(sysFile.getFileId());
            slideshow.setCreateBy(loginUser.getUsername());
            slideshow.setCreateTime(DateUtils.getNowDate());
            int count = slideshowMapper.insertSlideshow(slideshow);
            if(count > 0){
                redisCache.deleteObject(CacheConstants.INDEX_FRONT_SLIDESHOW_KEY);
            }
            return count;
        } catch (Exception e) {
            throw new RuntimeException("新增失败！");
        }
    }

    /**
     * 修改轮播图
     *
     * @param slideshow 轮播图
     * @param loginUser 登录用户信息
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateSlideshow(Slideshow slideshow, LoginUser loginUser) {
        if(slideshow.getSlideshow() == null || Objects.equals(0, slideshow.getSlideshow())){
            SysFile sysFile = new SysFile();
            sysFile.setFileUrl(slideshow.getSlideshowImageUrl());
            sysFile.setIsEnable("0");
            sysFile.setCreateBy(loginUser.getUsername());
            iSysFileService.insertSysFile(sysFile);
            slideshow.setSlideshow(sysFile.getFileId());
        }
        slideshow.setUpdateBy(loginUser.getUsername());
        slideshow.setUpdateTime(DateUtils.getNowDate());
        int count = slideshowMapper.updateSlideshow(slideshow);
        if(count > 0){
            redisCache.deleteObject(CacheConstants.INDEX_FRONT_SLIDESHOW_KEY);
        }
        return count;
    }

    /**
     * 批量删除轮播图
     *
     * @param slideshowIds 需要删除的轮播图主键
     * @param loginUser 登录用户信息
     * @return 结果
     */
    @Override
    public int deleteSlideshowBySlideshowIds(Long[] slideshowIds, LoginUser loginUser) {
        Date nowDate = DateUtils.getNowDate();
        int count = slideshowMapper.deleteSlideshowBySlideshowIds(slideshowIds, loginUser, nowDate);
        if(count > 0){
            redisCache.deleteObject(CacheConstants.INDEX_FRONT_SLIDESHOW_KEY);
        }
        return count;
    }

    /**
     * 删除轮播图信息
     *
     * @param slideshowId 轮播图主键
     * @param loginUser 登录用户信息
     * @return 结果
     */
    @Override
    public int deleteSlideshowBySlideshowId(Long slideshowId, LoginUser loginUser) {
        Date nowDate = DateUtils.getNowDate();
        int count = slideshowMapper.deleteSlideshowBySlideshowId(slideshowId, loginUser, nowDate);
        if(count > 0){
            redisCache.deleteObject(CacheConstants.INDEX_FRONT_SLIDESHOW_KEY);
        }
        return count;
    }
}

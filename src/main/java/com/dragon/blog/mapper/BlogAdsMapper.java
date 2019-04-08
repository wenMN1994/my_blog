package com.dragon.blog.mapper;

import com.dragon.blog.model.BlogAds;
import com.dragon.blog.model.BlogAdsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BlogAdsMapper {
    long countByExample(BlogAdsExample example);

    int deleteByExample(BlogAdsExample example);

    int deleteByPrimaryKey(Integer adId);

    int insert(BlogAds record);

    int insertSelective(BlogAds record);

    List<BlogAds> selectByExample(BlogAdsExample example);

    BlogAds selectByPrimaryKey(Integer adId);

    int updateByExampleSelective(@Param("record") BlogAds record, @Param("example") BlogAdsExample example);

    int updateByExample(@Param("record") BlogAds record, @Param("example") BlogAdsExample example);

    int updateByPrimaryKeySelective(BlogAds record);

    int updateByPrimaryKey(BlogAds record);
}
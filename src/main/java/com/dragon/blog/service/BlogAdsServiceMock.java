package com.dragon.blog.service;

import com.dragon.base.BaseServiceMock;
import com.dragon.blog.mapper.BlogAdsMapper;
import com.dragon.blog.model.BlogAds;
import com.dragon.blog.model.BlogAdsExample;

/**
* 降级实现BlogAdsService接口
* Created by Dragon.Wen on 2019/4/4.
*/
public class BlogAdsServiceMock extends BaseServiceMock<BlogAdsMapper, BlogAds, BlogAdsExample> implements BlogAdsService {

}

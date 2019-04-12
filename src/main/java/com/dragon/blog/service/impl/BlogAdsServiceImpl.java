package com.dragon.blog.service.impl;

import com.dragon.annotation.BaseService;
import com.dragon.base.BaseServiceImpl;
import com.dragon.blog.mapper.BlogAdsMapper;
import com.dragon.blog.model.BlogAds;
import com.dragon.blog.model.BlogAdsExample;
import com.dragon.blog.service.BlogAdsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* BlogAdsService实现
* Created by Dragon.Wen on 2019/4/4.
*/
@Service
@Transactional
@BaseService
public class BlogAdsServiceImpl extends BaseServiceImpl<BlogAdsMapper, BlogAds, BlogAdsExample> implements BlogAdsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BlogAdsServiceImpl.class);

    @Autowired
    BlogAdsMapper blogAdsMapper;

}
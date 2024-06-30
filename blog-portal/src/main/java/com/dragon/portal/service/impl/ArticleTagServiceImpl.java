package com.dragon.portal.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import cn.hutool.core.collection.CollectionUtil;
import com.dragon.common.core.domain.model.LoginUser;
import com.dragon.common.utils.DateUtils;
import com.dragon.portal.domain.Article;
import com.dragon.portal.domain.ArticleTagRel;
import com.dragon.portal.mapper.ArticleTagRelMapper;
import com.dragon.system.domain.vo.SelectRspVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dragon.portal.mapper.ArticleTagMapper;
import com.dragon.portal.domain.ArticleTag;
import com.dragon.portal.service.IArticleTagService;

/**
 * 文章标签管理Service业务层处理
 * 
 * @author dragon
 * @date 2024-06-10
 */
@Service
@Slf4j
public class ArticleTagServiceImpl implements IArticleTagService {
    @Autowired
    private ArticleTagMapper articleTagMapper;

    @Autowired
    private ArticleServiceImpl articleService;

    @Autowired
    private ArticleTagRelMapper articleTagRelMapper;

    /**
     * 查询文章标签管理
     * 
     * @param tagId 文章标签管理主键
     * @return 文章标签管理
     */
    @Override
    public ArticleTag selectArticleTagById(Long tagId) {
        return articleTagMapper.selectArticleTagById(tagId);
    }

    /**
     * 查询文章标签管理列表
     * 
     * @param articleTag 文章标签管理
     * @return 文章标签管理
     */
    @Override
    public List<ArticleTag> selectArticleTagList(ArticleTag articleTag) {
        return articleTagMapper.selectArticleTagList(articleTag);
    }

    /**
     * 新增文章标签管理
     *
     * @param articleTag 文章标签管理
     * @param loginUser 操作用户
     * @return 结果
     */
    @Override
    public int insertArticleTag(ArticleTag articleTag, LoginUser loginUser) {
        articleTag.setCreateBy(loginUser.getUsername());
        articleTag.setCreateTime(DateUtils.getNowDate());
        return articleTagMapper.insertArticleTag(articleTag);
    }

    /**
     * 修改文章标签管理
     *
     * @param articleTag 文章标签管理
     * @param loginUser
     * @return 结果
     */
    @Override
    public int updateArticleTag(ArticleTag articleTag, LoginUser loginUser) {
        articleTag.setUpdateBy(loginUser.getUsername());
        articleTag.setUpdateTime(DateUtils.getNowDate());
        return articleTagMapper.updateArticleTag(articleTag);
    }

    /**
     * 批量删除文章标签管理
     * 
     * @param ids 需要删除的文章标签管理主键
     * @return 结果
     */
    @Override
    public int deleteArticleTagByIds(Long[] ids) {
        return articleTagMapper.deleteArticleTagByIds(ids);
    }

    /**
     * 删除文章标签管理信息
     * 
     * @param tagId 文章标签管理主键
     * @return 结果
     */
    @Override
    public int deleteArticleTagById(Long tagId) {
        return articleTagMapper.deleteArticleTagById(tagId);
    }

    /**
     * 标签下拉列表数据获取
     * @return
     */
    @Override
    public List<SelectRspVo> findTagSelectList() {
        List<ArticleTag> articleTags = articleTagMapper.selectArticleTagList(new ArticleTag());
        // DO 转 VO
        List<SelectRspVo> selectRspVos = new ArrayList<>();
        // 如果分类数据不为空
        if (CollectionUtil.isNotEmpty(articleTags)) {
            // 将分类 ID 作为 Value 值，将分类名称作为 label 展示
            selectRspVos = articleTags.stream()
                    .map(articleTagDo -> SelectRspVo.builder()
                            .label(articleTagDo.getName())
                            .value(String.valueOf(articleTagDo.getTagId()))
                            .build())
                    .collect(Collectors.toList());
        }
        return selectRspVos;
    }

    /**
     * 前台获取标签下文章列表
     * @param articleTag
     * @return
     */
    @Override
    public List<Article> getTagArticlePageList(ArticleTag articleTag) {
        List<Article> resultList = new ArrayList<>();
        // 标签 ID
        Long tagId = articleTag.getTagId();
        if (Objects.isNull(tagId)) {
            log.warn("==> 该标签不存在, tagId: {}", tagId);
            throw new RuntimeException("该标签不存在！");
        }
        // 先查询该标签下所有关联的文章 ID
        List<ArticleTagRel> articleTagRelList = articleTagRelMapper.selectByTagId(tagId);
        if (CollectionUtil.isEmpty(articleTagRelList)) {
            log.info("==> 该标签下还未发布任何文章, tagId: {}", tagId);
            return resultList;
        }
        // 提取所有文章 ID
        List<Long> articleIds = articleTagRelList.stream()
                .map(ArticleTagRel::getArticleId)
                .collect(Collectors.toList());
        Article article = new Article();
        article.setArticleIds(articleIds);
        List<Article> articlePageList = articleService.getArticlePageList(article);
        return articlePageList;
    }
}

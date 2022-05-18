package com.dragon.portal.service.impl;

import java.util.List;

import com.dragon.common.core.domain.model.LoginUser;
import com.dragon.common.utils.DateUtils;
import com.dragon.system.domain.SysFile;
import com.dragon.system.service.ISysFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dragon.portal.mapper.ArticleMapper;
import com.dragon.portal.domain.Article;
import com.dragon.portal.service.IArticleService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 文章信息Service业务层处理
 *
 * @author dragon
 * @date 2022-05-08
 */
@Service
public class ArticleServiceImpl implements IArticleService {
    @Autowired
    private ISysFileService iSysFileService;

    @Autowired
    private ArticleMapper articleMapper;

    /**
     * 查询文章信息
     *
     * @param articleId 文章信息主键
     * @return 文章信息
     */
    @Override
    public Article selectArticleByArticleId(Long articleId) {
        return articleMapper.selectArticleByArticleId(articleId);
    }

    /**
     * 查询文章信息列表
     *
     * @param article 文章信息
     * @return 文章信息
     */
    @Override
    public List<Article> selectArticleList(Article article) {
        return articleMapper.selectArticleList(article);
    }

    /**
     * 新增文章信息
     *
     * @param article 文章信息
     * @param loginUser 登录用户信息
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertArticle(Article article, LoginUser loginUser) {
        SysFile sysFile = new SysFile();
        sysFile.setFileUrl(article.getCoverUrl());
        sysFile.setIsEnable("0");
        sysFile.setCreateBy(loginUser.getUsername());
        iSysFileService.insertSysFile(sysFile);
        article.setStatus("0");
        article.setCover(sysFile.getFileId());
        article.setCreateBy(loginUser.getUsername());
        article.setCreateTime(DateUtils.getNowDate());
        return articleMapper.insertArticle(article);
    }

    /**
     * 修改文章信息
     *
     * @param article 文章信息
     * @return 结果
     */
    @Override
    public int updateArticle(Article article) {
        article.setUpdateTime(DateUtils.getNowDate());
        return articleMapper.updateArticle(article);
    }

    /**
     * 批量删除文章信息
     *
     * @param articleIds 需要删除的文章信息主键
     * @return 结果
     */
    @Override
    public int deleteArticleByArticleIds(Long[] articleIds) {
        return articleMapper.deleteArticleByArticleIds(articleIds);
    }

    /**
     * 删除文章信息信息
     *
     * @param articleId 文章信息主键
     * @return 结果
     */
    @Override
    public int deleteArticleByArticleId(Long articleId) {
        return articleMapper.deleteArticleByArticleId(articleId);
    }
}

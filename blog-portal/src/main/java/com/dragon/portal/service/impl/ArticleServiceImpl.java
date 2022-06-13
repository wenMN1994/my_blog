package com.dragon.portal.service.impl;

import java.util.List;

import com.dragon.common.core.domain.model.LoginUser;
import com.dragon.common.utils.DateUtils;
import com.dragon.common.utils.DictUtils;
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
        Article article = articleMapper.selectArticleByArticleId(articleId);
        if(article != null && article.getCover() != null){
            SysFile sysFile = iSysFileService.selectSysFileByFileId(article.getCover());
            if(sysFile != null){
                article.setCoverUrl(sysFile.getFileUrl());
            }
        }
        return article;
    }

    /**
     * 查询文章信息列表
     *
     * @param article 文章信息
     * @return 文章信息
     */
    @Override
    public List<Article> selectArticleList(Article article) {
        List<Article> articleList = articleMapper.selectArticleList(article);
        for (Article articleVo : articleList) {
            String articleTypeStr = DictUtils.getDictLabel("portal_article_type", articleVo.getArticleType());
            articleVo.setArticleTypeStr(articleTypeStr);
            String publishTypeStr = DictUtils.getDictLabel("portal_article_publish_type", articleVo.getPublishType());
            articleVo.setPublishTypeStr(publishTypeStr);
            String contentLevelStr = DictUtils.getDictLabel("portal_article_content_level", articleVo.getContentLevel());
            articleVo.setContentLevelStr(contentLevelStr);
            String statusStr = DictUtils.getDictLabel("portal_article_status", articleVo.getStatus());
            articleVo.setStatusStr(statusStr);
        }
        return articleList;
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
        try {
            SysFile sysFile = new SysFile();
            sysFile.setFileUrl(article.getCoverUrl());
            sysFile.setIsEnable("0");
            sysFile.setCreateBy(loginUser.getUsername());
            iSysFileService.insertSysFile(sysFile);
            article.setCover(sysFile.getFileId());
            article.setCreateBy(loginUser.getUsername());
            article.setCreateTime(DateUtils.getNowDate());
            return articleMapper.insertArticle(article);
        } catch (Exception e) {
            throw new RuntimeException("新增失败！");
        }
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
     * @param loginUser 登录用户信息
     * @return 结果
     */
    @Override
    public int deleteArticleByArticleIds(Long[] articleIds, LoginUser loginUser) {
        return articleMapper.deleteArticleByArticleIds(articleIds, loginUser.getUsername());
    }

    /**
     * 删除文章信息信息
     *
     * @param articleId 文章信息主键
     * @param loginUser 登录用户信息
     * @return 结果
     */
    @Override
    public int deleteArticleByArticleId(Long articleId, LoginUser loginUser) {
        return articleMapper.deleteArticleByArticleId(articleId, loginUser.getUsername());
    }
}

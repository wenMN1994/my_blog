package com.dragon.portal.service;

import java.util.List;

import com.dragon.common.core.domain.model.LoginUser;
import com.dragon.portal.domain.ArticleTag;
import com.dragon.system.domain.vo.SelectRspVo;

/**
 * 文章标签管理Service接口
 * 
 * @author dragon
 * @date 2024-06-10
 */
public interface IArticleTagService {
    /**
     * 查询文章标签管理
     * 
     * @param tagId 文章标签管理主键
     * @return 文章标签管理
     */
    public ArticleTag selectArticleTagById(Long tagId);

    /**
     * 查询文章标签管理列表
     * 
     * @param articleTag 文章标签管理
     * @return 文章标签管理集合
     */
    public List<ArticleTag> selectArticleTagList(ArticleTag articleTag);

    /**
     * 新增文章标签管理
     *
     * @param articleTag 文章标签管理
     * @param loginUser 操作用户
     * @return 结果
     */
    public int insertArticleTag(ArticleTag articleTag, LoginUser loginUser);

    /**
     * 修改文章标签管理
     *
     * @param articleTag 文章标签管理
     * @param loginUser 操作用户
     * @return 结果
     */
    public int updateArticleTag(ArticleTag articleTag, LoginUser loginUser);

    /**
     * 批量删除文章标签管理
     * 
     * @param ids 需要删除的文章标签管理主键集合
     * @return 结果
     */
    public int deleteArticleTagByIds(Long[] ids);

    /**
     * 删除文章标签管理信息
     * 
     * @param tagId 文章标签管理主键
     * @return 结果
     */
    public int deleteArticleTagById(Long tagId);

    /**
     * 标签下拉列表数据获取
     * @return
     */
    public List<SelectRspVo> findTagSelectList();
}

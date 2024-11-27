package com.dragon.portal.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dragon.portal.mapper.ArticleTagRelMapper;
import com.dragon.portal.domain.ArticleTagRel;
import com.dragon.portal.service.IArticleTagRelService;

/**
 * 文章对应标签关联Service业务层处理
 * 
 * @author dragon
 * @date 2024-06-23
 */
@Service
public class ArticleTagRelServiceImpl implements IArticleTagRelService {
    @Autowired
    private ArticleTagRelMapper articleTagRelMapper;

    /**
     * 查询文章对应标签关联
     * 
     * @param id 文章对应标签关联主键
     * @return 文章对应标签关联
     */
    @Override
    public ArticleTagRel selectArticleTagRelById(Long id) {
        return articleTagRelMapper.selectArticleTagRelById(id);
    }

    /**
     * 查询文章对应标签关联列表
     * 
     * @param articleTagRel 文章对应标签关联
     * @return 文章对应标签关联
     */
    @Override
    public List<ArticleTagRel> selectArticleTagRelList(ArticleTagRel articleTagRel) {
        return articleTagRelMapper.selectArticleTagRelList(articleTagRel);
    }

    /**
     * 新增文章对应标签关联
     * 
     * @param articleTagRel 文章对应标签关联
     * @return 结果
     */
    @Override
    public int insertArticleTagRel(ArticleTagRel articleTagRel) {
        return articleTagRelMapper.insertArticleTagRel(articleTagRel);
    }

    /**
     * 修改文章对应标签关联
     * 
     * @param articleTagRel 文章对应标签关联
     * @return 结果
     */
    @Override
    public int updateArticleTagRel(ArticleTagRel articleTagRel) {
        return articleTagRelMapper.updateArticleTagRel(articleTagRel);
    }

    /**
     * 批量删除文章对应标签关联
     * 
     * @param ids 需要删除的文章对应标签关联主键
     * @return 结果
     */
    @Override
    public int deleteArticleTagRelByIds(Long[] ids) {
        return articleTagRelMapper.deleteArticleTagRelByIds(ids);
    }

    /**
     * 删除文章对应标签关联信息
     * 
     * @param id 文章对应标签关联主键
     * @return 结果
     */
    @Override
    public int deleteArticleTagRelById(Long id) {
        return articleTagRelMapper.deleteArticleTagRelById(id);
    }
}

package com.dragon.common.index;

/**
 * 文章索引
 *
 * @author dragon
 * @date 2024-06-29
 */
public interface ArticleIndex {

    /**
     * 索引名称
     */
    String NAME = "article";

    /** 文章ID */
    String COLUMN_ID = "articleId";

    /** 文章标题 */
    String COLUMN_TITLE = "articleTitle";

    /** 封面Url */
    String COLUMN_COVER = "coverUrl";

    /** 摘要信息 */
    String COLUMN_SUMMARY = "summary";

    /** 文章内容 */
    String COLUMN_CONTENT = "content";

    /** 创建时间 */
    String COLUMN_CREATE_TIME = "createTime";
}

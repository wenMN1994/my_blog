package com.dragon.portal.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.dragon.common.annotation.Excel;
import com.dragon.common.core.domain.BaseEntity;

/**
 * 文章信息对象 portal_article
 *
 * @author dragon
 * @date 2022-05-08
 */
public class Article extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 文章ID */
    private Long articleId;

    /** 文章标题 */
    @Excel(name = "文章标题")
    private String articleTitle;

    /** 文章类型（1：原创，2：转载，3：翻译） */
    @Excel(name = "文章类型", readConverterExp = "1=：原创，2：转载，3：翻译")
    private String articleType;

    /** 封面 */
    @Excel(name = "封面")
    private Long cover;

    /** 摘要信息 */
    @Excel(name = "摘要信息")
    private String summary;

    /** 发布形式（1：公开，2：私密，3：VIP可见） */
    @Excel(name = "发布形式", readConverterExp = "1=：公开，2：私密，3：VIP可见")
    private String publishType;

    /** 内容等级（1：初级，2：中级，3：高级） */
    @Excel(name = "内容等级", readConverterExp = "1=：初级，2：中级，3：高级")
    private String contentLevel;

    /** 文章状态（0：已发布，1：已删除，2：草稿） */
    @Excel(name = "文章状态", readConverterExp = "0=：已发布，1：已删除，2：草稿")
    private String status;

    /** 文章内容（文本格式） */
    @Excel(name = "文章内容（文本格式）")
    private String content;

    /** 文章内容（html格式） */
    @Excel(name = "文章内容（html格式）")
    private String contentHtml;

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Long getArticleId() {
        return articleId;
    }
    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleTitle() {
        return articleTitle;
    }
    public void setArticleType(String articleType) {
        this.articleType = articleType;
    }

    public String getArticleType() {
        return articleType;
    }
    public void setCover(Long cover) {
        this.cover = cover;
    }

    public Long getCover() {
        return cover;
    }
    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSummary() {
        return summary;
    }
    public void setPublishType(String publishType) {
        this.publishType = publishType;
    }

    public String getPublishType() {
        return publishType;
    }
    public void setContentLevel(String contentLevel) {
        this.contentLevel = contentLevel;
    }

    public String getContentLevel() {
        return contentLevel;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public String getContentHtml() {
        return contentHtml;
    }

    public void setContentHtml(String contentHtml) {
        this.contentHtml = contentHtml;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("articleId", getArticleId())
                .append("articleTitle", getArticleTitle())
                .append("articleType", getArticleType())
                .append("cover", getCover())
                .append("summary", getSummary())
                .append("publishType", getPublishType())
                .append("contentLevel", getContentLevel())
                .append("status", getStatus())
                .append("content", getContent())
                .append("contentHtml", getContentHtml())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
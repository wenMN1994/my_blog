package com.dragon.portal.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel(value = "Article", description = "文章实体")
public class Article extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 文章ID */
    @ApiModelProperty("文章ID")
    private Long articleId;

    /** 文章标题 */
    @ApiModelProperty("文章标题")
    @Excel(name = "文章标题")
    private String articleTitle;

    /** 文章类型（1：原创，2：转载，3：翻译） */
    @ApiModelProperty("文章类型（1：原创，2：转载，3：翻译）")
    @Excel(name = "文章类型", readConverterExp = "1=：原创，2：转载，3：翻译")
    private String articleType;

    /** 文章类型中文描述 */
    @ApiModelProperty("文章类型中文描述")
    private String articleTypeStr;

    /** 封面ID */
    @ApiModelProperty("封面ID")
    @Excel(name = "封面ID")
    private Long cover;

    /** 封面Url */
    @ApiModelProperty("封面Url")
    @Excel(name = "封面Url")
    private String coverUrl;

    /** 摘要信息 */
    @ApiModelProperty("摘要信息")
    @Excel(name = "摘要信息")
    private String summary;

    /** 发布形式（1：公开，2：私密，3：VIP可见） */
    @ApiModelProperty("发布形式（1：公开，2：私密，3：VIP可见）")
    @Excel(name = "发布形式", readConverterExp = "1=：公开，2：私密，3：VIP可见")
    private String publishType;

    /** 发布形式中文描述 */
    @ApiModelProperty("发布形式中文描述")
    private String publishTypeStr;

    /** 内容等级（1：初级，2：中级，3：高级） */
    @ApiModelProperty("内容等级（1：初级，2：中级，3：高级）")
    @Excel(name = "内容等级", readConverterExp = "1=：初级，2：中级，3：高级")
    private String contentLevel;

    /** 内容等级中文描述 */
    @ApiModelProperty("内容等级中文描述")
    private String contentLevelStr;

    /** 文章状态（0：已发布，1：已删除，2：草稿） */
    @ApiModelProperty("文章状态（0：已发布，1：已删除，2：草稿）")
    @Excel(name = "文章状态", readConverterExp = "0=：已发布，1：已删除，2：草稿")
    private String status;

    /** 文章状态中文描述 */
    @ApiModelProperty("文章状态中文描述")
    private String statusStr;

    /** 文章内容（文本格式） */
    @ApiModelProperty("文章内容（文本格式）")
    @Excel(name = "文章内容（文本格式）")
    private String content;

    /** 文章内容（html格式） */
    @ApiModelProperty("文章内容（html格式）")
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

    public String getArticleTypeStr() {
        return articleTypeStr;
    }

    public void setArticleTypeStr(String articleTypeStr) {
        this.articleTypeStr = articleTypeStr;
    }

    public void setCover(Long cover) {
        this.cover = cover;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
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

    public String getPublishTypeStr() {
        return publishTypeStr;
    }

    public void setPublishTypeStr(String publishTypeStr) {
        this.publishTypeStr = publishTypeStr;
    }

    public void setContentLevel(String contentLevel) {
        this.contentLevel = contentLevel;
    }

    public String getContentLevel() {
        return contentLevel;
    }

    public String getContentLevelStr() {
        return contentLevelStr;
    }

    public void setContentLevelStr(String contentLevelStr) {
        this.contentLevelStr = contentLevelStr;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public String getStatusStr() {
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
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
                .append("articleTypeStr", getArticleTypeStr())
                .append("cover", getCover())
                .append("coverUrl", getCoverUrl())
                .append("summary", getSummary())
                .append("publishType", getPublishType())
                .append("publishTypeStr", getPublishTypeStr())
                .append("contentLevel", getContentLevel())
                .append("contentLevelStr", getContentLevelStr())
                .append("status", getStatus())
                .append("statusStr", getStatusStr())
                .append("content", getContent())
                .append("contentHtml", getContentHtml())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}
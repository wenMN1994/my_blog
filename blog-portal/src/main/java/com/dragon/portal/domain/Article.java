package com.dragon.portal.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.dragon.common.annotation.Excel;
import com.dragon.common.core.domain.BaseEntity;

import java.time.YearMonth;
import java.util.List;

/**
 * 文章信息对象 portal_article
 *
 * @author dragon
 * @date 2022-05-08
 */
@Data
@ApiModel(value = "Article", description = "文章实体")
public class Article extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 文章ID集合 */
    @ApiModelProperty("文章ID集合")
    private List<Long> articleIds;

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

    /** 阅读数量 */
    private Long readNum;

    /** 权重 */
    private Integer weight;

    /** 文章类型（1：普通文章，2：收录于知识库'） */
    private Integer type;

    /** 文章类型描述（1：普通文章，2：收录于知识库'） */
    private String typeStr;


    /** 文章置顶状态 */
    private Boolean isTop;

    /** 文章分类ID */
    private Long articleCategoryId;

    /** 文章标签ID */
    private List<String> articleTags;

    @ApiModelProperty("文章分类")
    private ArticleCategory category;

    @ApiModelProperty("文章标签")
    private List<ArticleTag> tags;

    /** 发布的月份（此字段不需要展示在前端，主要用于按月份分组使用） */
    private YearMonth createMonth;

    /**总字数*/
    @ApiModelProperty("总字数")
    private Integer totalWords;

    /**阅读时长*/
    @ApiModelProperty("阅读时长")
    private String readTime;

    /**上一篇文章*/
    @ApiModelProperty("上一篇文章")
    private FindPreNextArticle preArticle;

    /**下一篇文章*/
    @ApiModelProperty("下一篇文章")
    private FindPreNextArticle nextArticle;
}
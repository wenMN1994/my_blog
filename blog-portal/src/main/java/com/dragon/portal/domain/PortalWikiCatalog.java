package com.dragon.portal.domain;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.dragon.common.annotation.Excel;
import com.dragon.common.core.domain.TreeEntity;

import java.util.List;

/**
 * 知识库目录对象 portal_wiki_catalog
 *
 * @author dragon
 * @date 2024-07-21
 */
@Data
public class PortalWikiCatalog extends TreeEntity{
    private static final long serialVersionUID = 1L;

    /** 知识库目录id */
    private Long wikiCatalogId;

    /** 目录名称 */
    @Excel(name = "目录名称")
    private String catalogName;

    /** 菜单图标 */
    @Excel(name = "菜单图标")
    private String icon;

    /** 目录类型（M目录 C内容） */
    private String catalogType;

    /** 知识库id */
    @Excel(name = "知识库id")
    private Long wikiId;

    /** 文章id */
    @Excel(name = "文章id")
    private Long articleId;

    /** 文章id集合 */
    private List<Long> articleIds;

    /** 删除标志位：0：未删除 1：已删除 */
    private Integer isDeleted;
}

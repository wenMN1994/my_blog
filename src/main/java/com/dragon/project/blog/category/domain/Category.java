package com.dragon.project.blog.category.domain;

import com.dragon.framework.aspectj.lang.annotation.Excel;
import com.dragon.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author：Dragon Wen
 * @email：18475536452@163.com
 * @date：Created in 2019/7/12 21:24
 * @description： 分类实体类
 * @modified By：
 * @version: 1.0.0
 */
public class Category extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 分类Id
     */
    @Excel(name = "序号")
    private Integer categoryId;

    /**
     * 分类的名称
     */
    @Excel(name = "分类的名称")
    private String categoryTitle;

    /**
     * 权重
     */
    @Excel(name = "权重")
    private Integer weight;

    /**
     * 描述
     */
    @Excel(name = "描述")
    private String description;

    /**
     * 是否推荐，0表示不推荐，1表示推荐
     */
    @Excel(name = "是否推荐")
    private String support;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSupport() {
        return support;
    }

    public void setSupport(String support) {
        this.support = support;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("categoryId", categoryId)
                .append("categoryTitle", categoryTitle)
                .append("weight", weight)
                .append("description", description)
                .append("support", support)
                .toString();
    }
}
package com.dragon.project.blog.blog.domain;

import com.dragon.framework.aspectj.lang.annotation.Excel;
import com.dragon.framework.web.domain.BaseEntity;
import com.dragon.project.blog.category.domain.Category;
import com.dragon.project.blog.tag.domain.Tag;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * @author：Dragon Wen
 * @email：18475536452@163.com
 * @date：Created in 2019/7/16 21:49
 * @description： 博客信息
 * @modified By：
 * @version: 1.0.0
 */
public class Blog extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 博客id
     */
    @Excel(name = "序号")
    private Integer blogId;

    /**
     * 归类id
     */
    @Excel(name = "归类id")
    private Integer categoryId;

    /**
     * 博文标题
     */
    @Excel(name = "博文标题")
    private String title;

    /**
     * 博文摘要
     */
    @Excel(name = "博文摘要")
    private String summary;

    /**
     * 博文状态，1表示已经发表，2表示在草稿箱，3表示在垃圾箱
     */
    @Excel(name = "博文状态，1表示已经发表，2表示在草稿箱，3表示在垃圾箱")
    private String status;

    /**
     * 权重
     */
    @Excel(name = "权重")
    private Integer weight;

    /**
     * 是否推荐，1表示推荐，0表示不推荐
     */
    @Excel(name = "是否推荐：1表示推荐，0表示不推荐")
    private String support;

    /**
     * 点击次数
     */
    @Excel(name = "点击次数")
    private Integer click;

    /**
     * 标图展示地址
     */
    @Excel(name = "标图展示地址")
    private String headerImg;

    /**
     * 博文类型，1表示markdown，2表示富文本
     */
    private String type;

    /**
     * 所属模块，1表示文章，2表示视频课程，3表示项目源码
     */
    @Excel(name = "所属模块：1表示文章，2表示视频课程，3表示项目源码")
    private String module;

    /**
     * 博文正文内容
     */
    private String content;

    /**
     * tag集合
     */
    private List<Tag> tagList;

    /**
     * 从页面获取或者传到页面的tags
     */
    private String[] tags;
    /**
     * 分类的名称
     */
    private String categoryTitle;

    /**
     * 分类对象
     */
    private Category category;

    /**
     * 评论总数
     */
    private Integer commentCount;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getSupport() {
        return support;
    }

    public void setSupport(String support) {
        this.support = support;
    }

    public Integer getClick() {
        return click;
    }

    public void setClick(Integer click) {
        this.click = click;
    }

    public String getHeaderImg() {
        return headerImg;
    }

    public void setHeaderImg(String headerImg) {
        this.headerImg = headerImg;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("blogId", blogId)
                .append("categoryId", categoryId)
                .append("title", title)
                .append("summary", summary)
                .append("status", status)
                .append("weight", weight)
                .append("support", support)
                .append("click", click)
                .append("headerImg", headerImg)
                .append("type", type)
                .append("module", module)
                .append("content", content)
                .append("tagList", tagList)
                .append("tags", tags)
                .append("categoryTitle", categoryTitle)
                .append("category", category)
                .append("commentCount", commentCount)
                .toString();
    }
}
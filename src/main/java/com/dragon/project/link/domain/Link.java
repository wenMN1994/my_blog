package com.dragon.project.link.domain;

import com.dragon.framework.aspectj.lang.annotation.Excel;
import com.dragon.framework.web.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * @author：Dragon Wen
 * @email：18475536452@163.com
 * @date：Created in 2019/7/20 09:31
 * @description： 友链实体类
 * @modified By：
 * @version: 1.0.0
 */
public class Link extends BaseEntity {

    /**
     * 友链id
     */
    @Excel(name = "序号")
    private Integer linkId;
    /**
     * 友链的名称
     */
    @Excel(name = "友链名称")
    private String title;
    /**
     * 友链描述
     */
    @Excel(name = "友链描述")
    private String description;
    /**
     * 友链图标地址
     */
    @Excel(name = "友链图标地址")
    private String headerImg;
    /**
     * 友链点击数
     */
    @Excel(name = "友链点击数")
    private Integer click;
    /**
     * 友链权重
     */
    @Excel(name = "友链权重")
    private Integer weight;
    /**
     * 友链是否能访问，1表示能，0表示不能
     */
    @Excel(name = "友链是否能访问，1表示能，0表示不能")
    private Integer available;
    /**
     * 友链是否已经处理，1表示已经处理，0表示没有处理
     */
    @Excel(name = "友链是否已经处理，1表示已经处理，0表示没有处理")
    private Integer processed;
    /**
     * 友链是否显示，1表示显示，0表示不显示
     */
    @Excel(name = "友链是否显示，1表示显示，0表示不显示")
    private Integer display;
    /**
     * 友链的地址
     */
    @Excel(name = "友链的地址")
    private String email;
    /**
     * 联系邮箱
     */
    @Excel(name = "联系邮箱")
    private String url;

    public Integer getLinkId() {
        return linkId;
    }

    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHeaderImg() {
        return headerImg;
    }

    public void setHeaderImg(String headerImg) {
        this.headerImg = headerImg;
    }

    public Integer getClick() {
        return click;
    }

    public void setClick(Integer click) {
        this.click = click;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getAvailable() {
        return available;
    }

    public void setAvailable(Integer available) {
        this.available = available;
    }

    public Integer getProcessed() {
        return processed;
    }

    public void setProcessed(Integer processed) {
        this.processed = processed;
    }

    public Integer getDisplay() {
        return display;
    }

    public void setDisplay(Integer display) {
        this.display = display;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("linkId", linkId)
                .append("title", title)
                .append("description", description)
                .append("headerImg", headerImg)
                .append("click", click)
                .append("weight", weight)
                .append("available", available)
                .append("processed", processed)
                .append("display", display)
                .append("email", email)
                .append("url", url)
                .toString();
    }
}

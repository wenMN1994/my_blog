package com.dragon.portal.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.dragon.common.annotation.Excel;
import com.dragon.common.core.domain.BaseEntity;

/**
 * 轮播图管理对象 portal_slideshow
 *
 * @author dragon
 * @date 2022-08-20
 */
public class Slideshow extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    private Long slideshowId;

    /** 轮播图 */
    @Excel(name = "轮播图")
    private Long slideshow;

    /** 轮播图图片URL */
    @Excel(name = "轮播图")
    private String slideshowImageUrl;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 副标题 */
    @Excel(name = "副标题")
    private String subTitle;

    /** 网址 */
    @Excel(name = "网址")
    private String linkUrl;

    /** 打开方式 */
    @Excel(name = "打开方式")
    private String target;

    /** 点击量 */
    @Excel(name = "点击量")
    private Long clicks;

    /** 是否有效（0：有效，1：无效） */
    @Excel(name = "是否有效", readConverterExp = "0=：有效，1：无效")
    private String isEnable;

    public void setSlideshowId(Long slideshowId) {
        this.slideshowId = slideshowId;
    }

    public Long getSlideshowId() {
        return slideshowId;
    }
    public void setSlideshow(Long slideshow) {
        this.slideshow = slideshow;
    }

    public Long getSlideshow() {
        return slideshow;
    }

    public String getSlideshowImageUrl() {
        return slideshowImageUrl;
    }

    public void setSlideshowImageUrl(String slideshowImageUrl) {
        this.slideshowImageUrl = slideshowImageUrl;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getSubTitle() {
        return subTitle;
    }
    public void setLinkUrl(String linkUrl)
    {
        this.linkUrl = linkUrl;
    }

    public String getLinkUrl() {
        return linkUrl;
    }
    public void setTarget(String target) {
        this.target = target;
    }

    public String getTarget() {
        return target;
    }
    public void setClicks(Long clicks) {
        this.clicks = clicks;
    }

    public Long getClicks() {
        return clicks;
    }
    public void setIsEnable(String isEnable) {
        this.isEnable = isEnable;
    }

    public String getIsEnable() {
        return isEnable;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("slideshowId", getSlideshowId())
                .append("slideshow", getSlideshow())
                .append("slideshowImageUrl", getSlideshowImageUrl())
                .append("title", getTitle())
                .append("subTitle", getSubTitle())
                .append("linkUrl", getLinkUrl())
                .append("target", getTarget())
                .append("clicks", getClicks())
                .append("isEnable", getIsEnable())
                .append("createBy", getCreateBy())
                .append("createTime", getCreateTime())
                .append("updateBy", getUpdateBy())
                .append("updateTime", getUpdateTime())
                .toString();
    }
}

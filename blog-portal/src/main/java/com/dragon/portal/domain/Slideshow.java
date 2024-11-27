package com.dragon.portal.domain;

import io.swagger.annotations.ApiModel;
import lombok.Data;
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
@Data
@ApiModel(value = "Article", description = "轮播图实体")
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
}

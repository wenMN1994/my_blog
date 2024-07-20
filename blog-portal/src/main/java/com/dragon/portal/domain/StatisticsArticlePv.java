package com.dragon.portal.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.dragon.common.annotation.Excel;
import com.dragon.common.core.domain.BaseEntity;

/**
 * 统计 - 文章 PV (浏览量)对象 portal_statistics_article_pv
 * 
 * @author dragon
 * @date 2024-07-20
 */
@Data
public class StatisticsArticlePv extends BaseEntity{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 被统计的日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "被统计的日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date pvDate;

    /** pv浏览量 */
    @Excel(name = "pv浏览量")
    private Integer pvCount;
}

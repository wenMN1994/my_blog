package com.dragon.portal.domain;

import com.dragon.common.core.domain.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.YearMonth;
import java.util.List;

/**
 * @author: DragonWen
 * @date: 2024/6/30
 * @Version: 1.0
 * @description: 文章归档
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArchiveArticle extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 归档的月份 */
    @ApiModelProperty("归档的月份")
    private YearMonth month;

    private List<Article> articles;
}

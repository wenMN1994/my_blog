package com.dragon.system.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 下拉列表实体
 *
 * @author dragon
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SelectRspVo {
    /**
     * Select 下拉列表的展示文字
     */
    private String label;

    /**
     * Select 下拉列表的 value 值，如 ID 等
     */
    private Object value;
}

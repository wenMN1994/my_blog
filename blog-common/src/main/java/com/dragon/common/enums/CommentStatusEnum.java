package com.dragon.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author: DragonWen
 * @date: 2024/8/22
 * @Version: 1.0
 * @description:评论状态
 */
@Getter
@AllArgsConstructor
public enum CommentStatusEnum {

    // ----------- 通用异常状态码 -----------
    WAIT_EXAMINE(1, "等待审核"),
    NORMAL(2, "正常"),
    EXAMINE_FAILED(3, "审核不通过"),
    ;

    private Integer code;
    private String description;
}

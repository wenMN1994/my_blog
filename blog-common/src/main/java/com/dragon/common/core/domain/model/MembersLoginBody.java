package com.dragon.common.core.domain.model;

import lombok.Data;

/**
 * @author: DragonWen
 * @date: 2024/8/13
 * @Version: 1.0
 * @description:
 */
@Data
public class MembersLoginBody {
    /**
     * 用户名
     */
    private String username;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 验证码
     */
    private String verificationCode;
}

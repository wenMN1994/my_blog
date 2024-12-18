package com.dragon.common.core.domain.entity;

import lombok.Data;

/**
 * @author: DragonWen
 * @date: 2024/8/12
 * @Version: 1.0
 * @description:验证码接收实体
 */
@Data
public class Verification {
    /**
     * 账号：手机号码或邮箱
     */
    private String username;

    /**
     * 类型：Login：登录 Register：注册 ResetPwd：重置密码
     */
    private String type;
}

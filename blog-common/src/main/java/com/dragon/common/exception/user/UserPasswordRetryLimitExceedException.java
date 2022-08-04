package com.dragon.common.exception.user;

/**
 * @author：DragonWen
 * @email：18475536452@163.com
 * @date：Created 2022-08-04
 * @description：用户错误最大次数异常类
 */
public class UserPasswordRetryLimitExceedException extends UserException {
    private static final long serialVersionUID = 1L;

    public UserPasswordRetryLimitExceedException(int retryLimitCount, int lockTime) {
        super("user.password.retry.limit.exceed", new Object[] { retryLimitCount, lockTime });
    }
}
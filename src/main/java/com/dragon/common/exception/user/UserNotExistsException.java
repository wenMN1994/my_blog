package com.dragon.common.exception.user;

/**
 * @author：Dragon Wen
 * @email：18475536452@163.com
 * @date：Created in 2019/5/30 10:56
 * @description： 用户不存在异常类
 * @modified By：
 * @version: 1.0.0
 */
public class UserNotExistsException extends UserException {
    private static final long serialVersionUID = 1L;

    public UserNotExistsException() {
        super("user.not.exists", null);
    }
}

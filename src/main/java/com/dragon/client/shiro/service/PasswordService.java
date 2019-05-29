package com.dragon.client.shiro.service;

import com.dragon.blog.model.BlogSysUser;
import com.dragon.common.constant.Constants;
import com.dragon.common.exception.user.UserPasswordNotMatchException;
import com.dragon.common.exception.user.UserPasswordRetryLimitExceedException;
import com.dragon.manager.AsyncManager;
import com.dragon.manager.factory.AsyncFactory;
import com.dragon.utils.MessageUtils;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author：Dragon Wen
 * @email：18475536452@163.com
 * @date：Created in 2019/5/29 15:02
 * @description： 登录密码方法
 * @modified By：
 * @version: 1.0.0
 */
@Component
public class PasswordService {
    @Autowired
    private CacheManager cacheManager;

    private Cache<String, AtomicInteger> loginRecordCache;

    @Value(value = "${user.password.maxRetryCount}")
    private String maxRetryCount;

    @PostConstruct
    public void init() {
        loginRecordCache = cacheManager.getCache("loginRecordCache");
    }

    public void validate(BlogSysUser blogSysUser, String password) {
        String loginName = blogSysUser.getLoginName();

        AtomicInteger retryCount = loginRecordCache.get(loginName);

        if (retryCount == null) {
            retryCount = new AtomicInteger(0);
            loginRecordCache.put(loginName, retryCount);
        }
        if (retryCount.incrementAndGet() > Integer.valueOf(maxRetryCount).intValue()) {
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(loginName, Constants.LOGIN_FAIL, MessageUtils.message("user.password.retry.limit.exceed", maxRetryCount)));
            throw new UserPasswordRetryLimitExceedException(Integer.valueOf(maxRetryCount).intValue());
        }

        if (!matches(blogSysUser, password)) {
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(loginName, Constants.LOGIN_FAIL, MessageUtils.message("user.password.retry.limit.count", retryCount)));
            loginRecordCache.put(loginName, retryCount);
            throw new UserPasswordNotMatchException();
        } else {
            clearLoginRecordCache(loginName);
        }
    }

    public boolean matches(BlogSysUser blogSysUser, String newPassword) {
        return blogSysUser.getPassword().equals(encryptPassword(blogSysUser.getLoginName(), newPassword, blogSysUser.getSalt()));
    }

    public void clearLoginRecordCache(String username) {
        loginRecordCache.remove(username);
    }

    public String encryptPassword(String username, String password, String salt) {
        return new Md5Hash(username + password + salt).toHex().toString();
    }

    public static void main(String[] args) {
        System.out.println(new PasswordService().encryptPassword("admin", "123456", "admin"));
    }
}

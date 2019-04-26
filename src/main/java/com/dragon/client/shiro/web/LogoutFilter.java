package com.dragon.client.shiro.web;

import com.dragon.utils.StringUtils;
import org.apache.shiro.session.SessionException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author：Dragon Wen
 * @email：18475536452@163.com
 * @date：Created in 2019/4/26 21:43
 * @description： 退出过滤器
 * @modified By：
 * @version: $version$
 */
public class LogoutFilter extends org.apache.shiro.web.filter.authc.LogoutFilter {

    private final Logger LOGGER = LoggerFactory.getLogger(LogoutFilter.class);

    /**
     * 退出后重定向的地址
     */
    private String loginUrl;

    public String getLoginUrl() {
        return loginUrl;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }

    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        try {
            Subject subject = getSubject(request, response);
            String redirectUrl = getRedirectUrl(request, response, subject);
            try {
                // 退出登录
                subject.logout();
            } catch (SessionException ise) {
                LOGGER.error("logout fail.", ise);
            }
            issueRedirect(request, response, redirectUrl);
        } catch (Exception e) {
            LOGGER.error("Encountered session exception during logout.  This can generally safely be ignored.", e);
        }
        return false;
    }

    /**
     * 退出跳转URL
     */
    @Override
    protected String getRedirectUrl(ServletRequest request, ServletResponse response, Subject subject) {
        String url = getLoginUrl();
        if (StringUtils.isNotEmpty(url)) {
            return url;
        }
        return super.getRedirectUrl(request, response, subject);
    }
}

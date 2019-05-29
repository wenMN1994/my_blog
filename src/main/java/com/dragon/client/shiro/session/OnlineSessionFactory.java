package com.dragon.client.shiro.session;

import com.dragon.blog.model.BlogSysUserOnline;
import com.dragon.blog.model.OnlineSession;
import com.dragon.utils.IpUtils;
import com.dragon.utils.ServletUtils;
import com.dragon.utils.StringUtils;
import eu.bitwalker.useragentutils.UserAgent;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionContext;
import org.apache.shiro.session.mgt.SessionFactory;
import org.apache.shiro.web.session.mgt.WebSessionContext;

import javax.servlet.http.HttpServletRequest;

/**
 * @author：Dragon Wen
 * @email：18475536452@163.com
 * @date：Created in 2019/5/27 10:34
 * @description： 自定义sessionFactory会话
 * @modified By：
 * @version: 1.0.0
 */
public class OnlineSessionFactory implements SessionFactory {

    public Session createSession(BlogSysUserOnline blogSysUserOnline) {
        OnlineSession onlineSession = blogSysUserOnline.getSession();
        if (StringUtils.isNotNull(onlineSession) && onlineSession.getId() == null) {
            onlineSession.setId(blogSysUserOnline.getSessionid());
        }
        return blogSysUserOnline.getSession();
    }

    @Override
    public Session createSession(SessionContext initData) {
        OnlineSession session = new OnlineSession();
        if (initData != null && initData instanceof WebSessionContext) {
            WebSessionContext sessionContext = (WebSessionContext) initData;
            HttpServletRequest request = (HttpServletRequest) sessionContext.getServletRequest();
            if (request != null) {
                UserAgent userAgent = UserAgent.parseUserAgentString(ServletUtils.getRequest().getHeader("User-Agent"));
                // 获取客户端操作系统
                String os = userAgent.getOperatingSystem().getName();
                // 获取客户端浏览器
                String browser = userAgent.getBrowser().getName();
                session.setHost(IpUtils.getIpAddr(request));
                session.setBrowser(browser);
                session.setOs(os);
            }
        }
        return session;
    }
}

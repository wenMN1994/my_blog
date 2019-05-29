package com.dragon.client.shiro.web.session;

import com.dragon.blog.model.BlogSysUserOnline;
import com.dragon.blog.model.BlogSysUserOnlineExample;
import com.dragon.blog.model.OnlineSession;
import com.dragon.blog.service.BlogSysUserOnlineService;
import com.dragon.blog.service.BlogSysUserOnlineServiceMock;
import com.dragon.common.constant.ShiroConstants;
import com.dragon.utils.DateUtils;
import com.dragon.utils.SpringContextUtil;
import org.apache.shiro.session.ExpiredSessionException;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.session.mgt.DefaultSessionKey;
import org.apache.shiro.session.mgt.SessionKey;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @author：Dragon Wen
 * @email：18475536452@163.com
 * @date：Created in 2019/5/27 16:22
 * @description： 主要是在此如果会话的属性修改了 就标识下其修改了 然后方便 OnlineSessionDao同步
 * @modified By：
 * @version: 1.0.0
 */
public class OnlineWebSessionManager extends DefaultWebSessionManager {
    private static final Logger LOGGER = LoggerFactory.getLogger(BlogSysUserOnlineServiceMock.class);
    
    @Override
    public void setSessionListeners(Collection<SessionListener> listeners) {
        super.setSessionListeners(listeners);
    }

    @Override
    public void setAttribute(SessionKey sessionKey, Object attributeKey, Object value) throws InvalidSessionException {
        super.setAttribute(sessionKey, attributeKey, value);
        if (value != null && needMarkAttributeChanged(attributeKey)) {
            OnlineSession s = (OnlineSession) doGetSession(sessionKey);
            s.markAttributeChanged();
        }
    }

    private boolean needMarkAttributeChanged(Object attributeKey) {
        if (attributeKey == null) {
            return false;
        }
        String attributeKeyStr = attributeKey.toString();
        // 优化 flash属性没必要持久化
        if (attributeKeyStr.startsWith("org.springframework")) {
            return false;
        }
        if (attributeKeyStr.startsWith("javax.servlet")) {
            return false;
        }
        if (attributeKeyStr.equals(ShiroConstants.CURRENT_USERNAME)) {
            return false;
        }
        return true;
    }

    @Override
    public Object removeAttribute(SessionKey sessionKey, Object attributeKey) throws InvalidSessionException {
        Object removed = super.removeAttribute(sessionKey, attributeKey);
        if (removed != null) {
            OnlineSession s = (OnlineSession) doGetSession(sessionKey);
            s.markAttributeChanged();
        }

        return removed;
    }

    /**
     * 验证session是否有效 用于删除过期session
     */
    @Override
    public void validateSessions() {
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("invalidation sessions...");
        }

        int invalidCount = 0;

        int timeout = (int) this.getGlobalSessionTimeout();
        Date expiredDate = DateUtils.addMilliseconds(new Date(), 0 - timeout);
        BlogSysUserOnlineService blogSysUserOnlineService = SpringContextUtil.getBean(BlogSysUserOnlineService.class);
//        String lastAccessTime = DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, expiredDate);
        BlogSysUserOnlineExample blogSysUserOnlineExample = new BlogSysUserOnlineExample();
        BlogSysUserOnlineExample.Criteria criteria = blogSysUserOnlineExample.createCriteria();
        criteria.andLastAccessTimeEqualTo(expiredDate);
        List<BlogSysUserOnline> blogSysUserOnlineList = blogSysUserOnlineService.selectByExample(blogSysUserOnlineExample);
        // 批量过期删除
        List<String> needOfflineIdList = new ArrayList<String>();
        for (BlogSysUserOnline blogSysUserOnline : blogSysUserOnlineList) {
            try {
                SessionKey key = new DefaultSessionKey(blogSysUserOnline.getSessionid());
                Session session = retrieveSession(key);
                if (session != null) {
                    throw new InvalidSessionException();
                }
            } catch (InvalidSessionException e) {
                if (LOGGER.isDebugEnabled()) {
                    boolean expired = (e instanceof ExpiredSessionException);
                    String msg = "Invalidated session with id [" + blogSysUserOnline.getSessionid() + "]"
                            + (expired ? " (expired)" : " (stopped)");
                    LOGGER.debug(msg);
                }
                invalidCount++;
                needOfflineIdList.add(blogSysUserOnline.getSessionid());
            }

        }
        if (needOfflineIdList.size() > 0) {
            try {
                blogSysUserOnlineService.batchDeleteOnline(needOfflineIdList);
            } catch (Exception e) {
                LOGGER.error("batch delete db session error.", e);
            }
        }

        if (LOGGER.isInfoEnabled()) {
            String msg = "Finished invalidation session.";
            if (invalidCount > 0) {
                msg += " [" + invalidCount + "] sessions were stopped.";
            } else {
                msg += " No sessions were stopped.";
            }
            LOGGER.info(msg);
        }

    }

    /**
     * 获取在线用户信息，包括访客信息和后台登录用户的信息
     */
    @Override
    protected Collection<Session> getActiveSessions() {
        return sessionDAO.getActiveSessions();
    }
}

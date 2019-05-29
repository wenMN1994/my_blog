package com.dragon.utils.security;

import com.dragon.blog.model.BlogSysUser;
import com.dragon.client.shiro.realm.BlogShiroRealm;
import com.dragon.utils.StringUtils;
import com.dragon.utils.bean.BeanUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;

/**
 * @author：Dragon Wen
 * @email：18475536452@163.com
 * @date：Created in 2019/5/27 15:27
 * @description： shiro 工具类
 * @modified By：
 * @version: 1.0.0
 */
public class ShiroUtils {
    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    public static Session getSession() {
        return SecurityUtils.getSubject().getSession();
    }

    public static void logout() {
        getSubject().logout();
    }

    public static BlogSysUser getSysUser() {
        BlogSysUser blogSysUser = null;
        Object obj = getSubject().getPrincipal();
        if (StringUtils.isNotNull(obj)) {
            blogSysUser = new BlogSysUser();
            BeanUtils.copyBeanProp(blogSysUser, obj);
        }
        return blogSysUser;
    }

    public static void setSysUser(BlogSysUser blogSysUser) {
        Subject subject = getSubject();
        PrincipalCollection principalCollection = subject.getPrincipals();
        String realmName = principalCollection.getRealmNames().iterator().next();
        PrincipalCollection newPrincipalCollection = new SimplePrincipalCollection(blogSysUser, realmName);
        // 重新加载Principal
        subject.runAs(newPrincipalCollection);
    }

    public static void clearCachedAuthorizationInfo() {
        RealmSecurityManager rsm = (RealmSecurityManager) SecurityUtils.getSecurityManager();
        BlogShiroRealm realm = (BlogShiroRealm) rsm.getRealms().iterator().next();
        realm.clearCachedAuthorizationInfo();
    }

    public static Long getUserId() {
        return getSysUser().getUserId().longValue();
    }

    public static String getLoginName() {
        return getSysUser().getLoginName();
    }

    public static String getIp() {
        return getSubject().getSession().getHost();
    }

    public static String getSessionId() {
        return String.valueOf(getSubject().getSession().getId());
    }
}
package com.dragon.client.shiro.realm;

import com.dragon.blog.model.BlogSysUser;
import com.dragon.client.shiro.service.LoginService;
import com.dragon.common.exception.user.UserNotExistsException;
import com.dragon.common.exception.user.UserPasswordNotMatchException;
import com.dragon.common.exception.user.UserPasswordRetryLimitExceedException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author：Dragon Wen
 * @email：18475536452@163.com
 * @date：Created in 2019/4/20 17:35
 * @description： 自定义Realm 处理登录 权限
 * @modified By：
 * @version: 1.0.0
 */
public class BlogShiroRealm extends AuthorizingRealm {

    private final Logger LOGGER = LoggerFactory.getLogger(BlogShiroRealm.class);

    @Autowired
    private LoginService loginService;

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        LOGGER.info("---------------- 执行 Shiro 授权 ---------------------");
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        return authorizationInfo;
    }

    /**
     * 登录认证
     * 主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确。
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
            throws AuthenticationException {
        LOGGER.info("---------------- 执行 Shiro 登录认证 ----------------------");
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        String username = token.getUsername();
        LOGGER.info("token带来的数据：  "+username);
        String password = "";
        if (token.getPassword() != null) {
            password = new String(token.getPassword());
        }
        BlogSysUser blogSysUser = null;
        try {
            blogSysUser = loginService.login(username,password);
        } catch (UserNotExistsException e) {
            throw new UnknownAccountException(e.getMessage(), e);
        } catch (UserPasswordNotMatchException e) {
            throw new IncorrectCredentialsException(e.getMessage(), e);
        } catch (UserPasswordRetryLimitExceedException e) {
            throw new ExcessiveAttemptsException(e.getMessage(), e);
        } catch (Exception e) {
            LOGGER.info("对用户[" + username + "]进行登录验证.验证未通过{}", e.getMessage());
            throw new AuthenticationException(e.getMessage(), e);
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(blogSysUser, password, getName());
        return authenticationInfo;
    }

    /**
     * 清理缓存权限
     */
    public void clearCachedAuthorizationInfo() {
        this.clearCachedAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
    }

}

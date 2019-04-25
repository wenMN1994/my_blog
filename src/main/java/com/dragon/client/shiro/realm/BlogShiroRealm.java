package com.dragon.client.shiro.realm;

import com.dragon.blog.model.BlogSysUser;
import com.dragon.blog.service.BlogSysApiService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * @author：Dragon Wen
 * @email：18475536452@163.com
 * @date：Created in 2019/4/20 17:35
 * @description： 自定义Realm 处理登录 权限
 * @modified By：
 * @version: $version$
 */
public class BlogShiroRealm extends AuthorizingRealm {

    private final Logger LOGGER = LoggerFactory.getLogger(BlogShiroRealm.class);

    @Resource
    private BlogSysApiService blogSysApiService;

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
        //获取用户的输入的账号.
//        String username = (String)token.getPrincipal();
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        String username = token.getUsername();
        LOGGER.info("token带来的数据：  "+username);
        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        BlogSysUser blogSysUser = blogSysApiService.selectBlogSysUserByUsername(username);
        LOGGER.info("----->>blogSysUser="+blogSysUser);
        if(blogSysUser == null){
            return null;
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                blogSysUser.getUserName(), //用户名
                blogSysUser.getPassword(), //密码
                ByteSource.Util.bytes(blogSysUser.getUserName()),// 盐值加密的盐，可以用用户名
        this.getName()  //realm name
        );
        return authenticationInfo;
    }

}

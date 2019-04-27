package com.dragon.config;

import com.dragon.client.shiro.realm.BlogShiroRealm;
import com.dragon.client.shiro.web.LogoutFilter;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author：Dragon Wen
 * @email：18475536452@163.com
 * @date：Created in 2019/4/20 17:26
 * @description： Shiro配置Bean
 * @version: $version$
 */
@Configuration
public class ShiroConfig {

    private final Logger LOGGER = LoggerFactory.getLogger(ShiroConfig.class);

    /**
     * 登录地址
     */
    @Value("${shiro.paths.loginUrl}")
    private String loginUrl;

    /**
     * 权限认证失败地址
     */
    @Value("${shiro.paths.unauthorizedUrl}")
    private String unauthorizedUrl;

    /**
     * redis 地址
     */
    @Value("${redis.ip}")
    private String redisIP;

    /**
     * redis 端口号
     */
    @Value("${redis.port}")
    private int redisPort;

    /**
     * redis 密码
     */
    @Value("${redis.password}")
    private String redisPassword;

    /**
     * redis 超时时间
     */
    @Value("${redis.timeout}")
    private int redisTimeout;

    /**
     * redis 缓存过期时间
     */
    @Value("${redis.expiretime}")
    private int redisExpiretime;

    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
        LOGGER.info("ShiroConfiguration.shirFilter()");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // Shiro的核心安全接口,这个属性是必须的
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 身份认证失败，则跳转到登录页面的配置
        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl(loginUrl);
        // 登录成功后要跳转的链接
//        shiroFilterFactoryBean.setSuccessUrl("/system/index");
        // 权限认证失败，则跳转到指定页面
        shiroFilterFactoryBean.setUnauthorizedUrl(unauthorizedUrl);

        //<!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
        // Shiro连接约束配置，即过滤链的定义
        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        // 对静态资源设置匿名访问
        filterChainDefinitionMap.put("/static/**", "anon");
        filterChainDefinitionMap.put("/admin/**", "anon");
        filterChainDefinitionMap.put("/common/**", "anon");
        filterChainDefinitionMap.put("/Front-End/**", "anon");
        //前台界面设置允许访问
        filterChainDefinitionMap.put("/", "anon");
        filterChainDefinitionMap.put("/my_blog/**", "anon");
        //配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
        filterChainDefinitionMap.put("/logout", "logout");
        // 不需要拦截的访问
        filterChainDefinitionMap.put("/sso/login", "anon");

        Map<String, Filter> filters = new LinkedHashMap<>();
        // 注销成功，则跳转到指定页面
        filters.put("logout", logoutFilter());
        shiroFilterFactoryBean.setFilters(filters);

        //<!-- 过滤链定义，从上向下顺序执行，一般将/**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
        filterChainDefinitionMap.put("/**", "authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    /**
     * 退出过滤器
     */
    public LogoutFilter logoutFilter() {
        LogoutFilter logoutFilter = new LogoutFilter();
        logoutFilter.setLoginUrl(loginUrl);
        return logoutFilter;
    }

    /**
     * 一、认证：
     *    1.1，将加密算法定义好后扔到 BlogShiroRealm中 也就是自己定义的realm中
     *    1.2，将BlogShiroRealm定义后扔到SecurityManager中。
     *    1.3，后期用到session什么的，都被SecurityManager管理
     *
     * @return
     */


    /**
     * 二、配置session（用Redis存储）
     * 	  2.1 需要配置session，就需要将sessionManager配置在SecurityManager中。
     *    2.2 sessionManager需要交给Redis来管理，所以定义了RedisSessionDAO
     *    2.3 RedisSessionDAO中需要配置Redis的信息，所以定义RedisManager
     *
     * @return
     */

    /*-------------------------认证---------------------------*/
    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        // 设置realm.
        securityManager.setRealm(blogShiroRealm());
        // 自定义缓存实现，使用redis
        securityManager.setCacheManager(cacheManager());
        //自定义session管理，使用redis
        securityManager.setSessionManager(sessionManager());
        return securityManager;
    }

    /**
     * cacheManager 缓存 redis实现
     * 使用的是shiro-redis开源插件
     *
     * @return
     */
    public RedisCacheManager cacheManager() {
        RedisCacheManager redisCacheManager = new RedisCacheManager();
        redisCacheManager.setRedisManager(redisManager());
        return redisCacheManager;
    }

    @Bean
    public BlogShiroRealm blogShiroRealm(){
        BlogShiroRealm blogShiroRealm = new BlogShiroRealm();
        blogShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return blogShiroRealm;
    }

    /**
     * 凭证匹配器
     * （由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了
     * ）
     * @return
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");//散列算法:这里使用MD5算法;
        hashedCredentialsMatcher.setHashIterations(1024);//散列的次数，比如散列两次，相当于 md5(md5(""));
        return hashedCredentialsMatcher;
    }

    //-------------------------redis-session----------------------

    /**
     * Session Manager
     * 使用的是shiro-redis开源插件
     */
    @Bean
    public DefaultWebSessionManager sessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setSessionDAO(redisSessionDAO());
        return sessionManager;
    }

    /**
     * RedisSessionDAO shiro sessionDao层的实现 通过redis
     * 使用的是shiro-redis开源插件
     */
    @Bean
    public RedisSessionDAO redisSessionDAO() {
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
        redisSessionDAO.setRedisManager(redisManager());
        return redisSessionDAO;
    }

    /**
     * 配置shiro redisManager
     * <p>
     * 使用的是shiro-redis开源插件
     *
     * @return
     */
    public RedisManager redisManager() {
        RedisManager redisManager = new RedisManager();
        redisManager.setHost(redisIP);
        redisManager.setPort(redisPort);
        redisManager.setExpire(redisExpiretime);// 配置缓存过期时间
        redisManager.setTimeout(redisTimeout);
//        redisManager.setPassword(redisPassword);
        return redisManager;
    }

    /***
     * 授权所用配置
     *
     * @return
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator getDefaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        defaultAdvisorAutoProxyCreator.setProxyTargetClass(true);
        return defaultAdvisorAutoProxyCreator;
    }

    /***
     * 使授权注解起作用不如不想配置可以在pom文件中加入
     * <dependency>
     *<groupId>org.springframework.boot</groupId>
     *<artifactId>spring-boot-starter-aop</artifactId>
     *</dependency>
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    /**
     * Shiro生命周期处理器
     *
     */
    @Bean
    public static LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }
}

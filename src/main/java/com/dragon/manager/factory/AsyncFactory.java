package com.dragon.manager.factory;

import com.dragon.blog.model.*;
import com.dragon.blog.service.BlogFrontVisitLogService;
import com.dragon.blog.service.BlogSysLoginInforService;
import com.dragon.blog.service.BlogSysOperLogService;
import com.dragon.blog.service.BlogSysUserOnlineService;
import com.dragon.common.constant.Constants;
import com.dragon.utils.*;
import com.dragon.utils.security.ShiroUtils;
import eu.bitwalker.useragentutils.UserAgent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.TimerTask;

/**
 * @author：Dragon Wen
 * @email：18475536452@163.com
 * @date：Created in 2019/5/27 13:30
 * @description： 异步工厂（产生任务用）
 * @modified By：
 * @version: 1.0.0
 */
public class AsyncFactory {

    private static final Logger LOGGER = LoggerFactory.getLogger(AsyncFactory.class);
    
    /**
     * 同步session到数据库
     *
     * @param session 在线用户会话
     * @return 任务task
     */
    public static TimerTask syncSessionToDb(final OnlineSession session) {
        return new TimerTask() {
            @Override
            public void run() {
                BlogSysUserOnline online = new BlogSysUserOnline();
                online.setSessionid(String.valueOf(session.getId()));
                online.setLoginName(session.getLoginName());
                online.setStartTimestamp(session.getStartTimestamp());
                online.setLastAccessTime(session.getLastAccessTime());
                online.setExpireTime((int) session.getTimeout());
                online.setIpaddr(session.getHost());
                online.setLoginLocation(AddressUtils.getRealAddressByIP(session.getHost()));
                online.setBrowser(session.getBrowser());
                online.setOs(session.getOs());
                online.setStatus(session.getStatus());
                online.setSession(session);
                SpringContextUtil.getBean(BlogSysUserOnlineService.class).saveOnline(online);

            }
        };
    }

    /**
     * 操作日志记录
     *
     * @param blogSysOperLog 操作日志信息
     * @return 任务task
     */
    public static TimerTask recordOper(final BlogSysOperLog blogSysOperLog) {
        return new TimerTask() {
            @Override
            public void run() {
                // 远程查询操作地点
                blogSysOperLog.setOperLocation(AddressUtils.getRealAddressByIP(blogSysOperLog.getOperIp()));
                SpringContextUtil.getBean(BlogSysOperLogService.class).insert(blogSysOperLog);
            }
        };
    }

    /**
     * 记录登陆信息
     *
     * @param username 用户名
     * @param status   状态
     * @param message  消息
     * @param args     列表
     * @return 任务task
     */
    public static TimerTask recordLogininfor(final String username, final String status, final String message, final Object... args) {
        final UserAgent userAgent = UserAgent.parseUserAgentString(ServletUtils.getRequest().getHeader("User-Agent"));
        final String ip = ShiroUtils.getIp();
        return new TimerTask() {
            @Override
            public void run() {
                StringBuilder s = new StringBuilder();
                s.append(LogUtils.getBlock(ip));
                s.append(AddressUtils.getRealAddressByIP(ip));
                s.append(LogUtils.getBlock(username));
                s.append(LogUtils.getBlock(status));
                s.append(LogUtils.getBlock(message));
                // 打印信息到日志
                LOGGER.info(s.toString(), args);
                // 获取客户端操作系统
                String os = userAgent.getOperatingSystem().getName();
                // 获取客户端浏览器
                String browser = userAgent.getBrowser().getName();
                // 封装对象
                BlogSysLoginInfor blogSysLoginInfor = new BlogSysLoginInfor();
                blogSysLoginInfor.setLoginName(username);
                blogSysLoginInfor.setIpaddr(ip);
                blogSysLoginInfor.setLoginLocation(AddressUtils.getRealAddressByIP(ip));
                blogSysLoginInfor.setBrowser(browser);
                blogSysLoginInfor.setOs(os);
                blogSysLoginInfor.setMsg(message);
                // 日志状态
                if (Constants.LOGIN_SUCCESS.equals(status) || Constants.LOGOUT.equals(status)) {
                    blogSysLoginInfor.setStatus(Constants.SUCCESS);
                } else if (Constants.LOGIN_FAIL.equals(status)) {
                    blogSysLoginInfor.setStatus(Constants.FAIL);
                }
                // 插入数据
                SpringContextUtil.getBean(BlogSysLoginInforService.class).insert(blogSysLoginInfor);
            }
        };
    }

    public static TimerTask recordVisitLog(BlogFrontVisitLog visitLog) {
        final UserAgent userAgent = UserAgent.parseUserAgentString(ServletUtils.getRequest().getHeader("User-Agent"));
        //获取爬虫类型
        final String spider = SpiderUtil.parseUserAgent(ServletUtils.getUserAgent());
        return new TimerTask() {
            @Override
            public void run() {
                visitLog.setOs(userAgent.getOperatingSystem().getName());
                visitLog.setSpider(spider);
                visitLog.setBrowser(userAgent.getBrowser().getName());
                visitLog.setLocation(AddressUtils.getRealAddressByIP(visitLog.getIpAddr()));
                visitLog.setCreateBy(ShiroUtils.getSessionId());
                SpringContextUtil.getBean(BlogFrontVisitLogService.class).insert(visitLog);
            }
        };
    }
}
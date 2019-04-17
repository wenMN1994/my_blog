package com.dragon.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author：Dragon Wen
 * @email：18475536452@163.com
 * @date：Created in 2019/4/16 17:40
 * @description： 自定义拦截器
 * @modified By：
 * @version: $version$
 */
@Component
public class BlogInterceptor implements HandlerInterceptor {

    Logger logger = LoggerFactory.getLogger(BlogInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // TODO Auto-generated method stub

        logger.info("进入LoginInterceptor拦截器==============");
        //获取session
        HttpSession session = request.getSession(true);
        String basePath = request.getContextPath();
        String path = request.getRequestURI();
        logger.info("basePath:" + basePath);
        logger.info("path:" + path);
        logger.info("userkey:"+request.getSession().getAttribute("userkey"));
        if(session.getAttribute("userkey") == null){

            logger.info("尚未登录，跳转到登录界面");
            response.setHeader("Content-Type", "text/html;charset=UTF-8");
            response.sendRedirect(request.getContextPath() + "/admin/login");
            return false;
        }else{
            logger.info("已登录，放行！");
            session.setAttribute("userkey", session.getAttribute("userkey"));
            return true;
        }

    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // TODO Auto-generated method stub
    }
}

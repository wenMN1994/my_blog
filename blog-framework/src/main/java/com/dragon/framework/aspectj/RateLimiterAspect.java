package com.dragon.framework.aspectj;

import com.dragon.common.annotation.RateLimiter;
import com.dragon.common.enums.LimitType;
import com.dragon.common.exception.ServiceException;
import com.dragon.common.utils.StringUtils;
import com.dragon.common.utils.ip.IpUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

/**
 * 限流处理
 *
 * @author dragon
 */
@Aspect
@Component
public class RateLimiterAspect {
    private static final Logger log = LoggerFactory.getLogger(RateLimiterAspect.class);

    private RedisTemplate<Object, Object> redisTemplate;

    private RedisScript<Long> limitScript;

    @Autowired
    public void setRedisTemplate1(RedisTemplate<Object, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Autowired
    public void setLimitScript(RedisScript<Long> limitScript) {
        this.limitScript = limitScript;
    }

    /**
     * 实现限流
     *
     * @param point
     * @param rateLimiter
     * @throws Throwable
     */
    @Before("@annotation(rateLimiter)")
    public void doBefore(JoinPoint point, RateLimiter rateLimiter) throws Throwable {
        try {
            // 在 {time} 秒内仅允许访问 {count} 次。
            int time = rateLimiter.time();
            int count = rateLimiter.count();
            // 根据用户IP（可选）和接口方法，构造key
            String combineKey = getCombineKey(rateLimiter, point);
            // 限流逻辑实现
            ZSetOperations zSetOperations = redisTemplate.opsForZSet();
            // 记录本次访问的时间结点
            long currentMs = System.currentTimeMillis();
            zSetOperations.add(combineKey, currentMs, currentMs);
            // 这一步是为了防止member一直存在于内存中
            redisTemplate.expire(combineKey, time, TimeUnit.SECONDS);
            // 移除{time}秒之前的访问记录（滑动窗口思想）
            zSetOperations.removeRangeByScore(combineKey, 0, currentMs - time * 1000);
            // 获得当前窗口内的访问记录数
            Long currCount = zSetOperations.zCard(combineKey);
            // 限流判断
            if (currCount > count) {
                log.info("限制请求数'{}',当前请求数'{}',缓存key'{}'", count, currCount, combineKey);
                throw new ServiceException("访问过于频繁，请稍候再试");
            }
        } catch (ServiceException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("服务器限流异常，请稍候再试");
        }
    }

    /**
     * @param rateLimiter
     * @param point
     * @return
     */
    public String getCombineKey(RateLimiter rateLimiter, JoinPoint point) {
        StringBuffer stringBuffer = new StringBuffer(rateLimiter.key());
        if (rateLimiter.limitType() == LimitType.IP) {
            stringBuffer.append(IpUtils.getIpAddr()).append("-");
        }
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        Class<?> targetClass = method.getDeclaringClass();
        stringBuffer.append(targetClass.getName()).append("-").append(method.getName());
        return stringBuffer.toString();
    }
}

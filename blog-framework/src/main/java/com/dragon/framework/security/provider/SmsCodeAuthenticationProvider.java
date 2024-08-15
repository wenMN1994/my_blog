package com.dragon.framework.security.provider;

import com.dragon.common.constant.CacheConstants;
import com.dragon.common.core.redis.RedisCache;
import com.dragon.common.utils.spring.SpringUtils;
import com.dragon.framework.security.token.SmsCodeAuthenticationToken;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author: DragonWen
 * @date: 2024/8/15
 * @Version: 1.0
 * @description:手机号短信验证
 */
public class SmsCodeAuthenticationProvider implements AuthenticationProvider {
    private UserDetailsService userDetailsService;

    public SmsCodeAuthenticationProvider() {}

    public SmsCodeAuthenticationProvider(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        SmsCodeAuthenticationToken authenticationToken = (SmsCodeAuthenticationToken) authentication;
        String mobile = (String) authenticationToken.getPrincipal();
        String code = (String) authenticationToken.getCode();
        checkSmsCode(mobile, code);
        UserDetails userDetails = userDetailsService.loadUserByUsername(mobile);
        // 此时鉴权成功后，应当重新 new 一个拥有鉴权的 authenticationResult 返回
        SmsCodeAuthenticationToken authenticationResult = new SmsCodeAuthenticationToken(userDetails, userDetails.getAuthorities(), code);
        authenticationResult.setDetails(authenticationToken.getDetails());
        return authenticationResult;
    }

    private void checkSmsCode(String mobile, String code) {
        RedisCache redisCache = SpringUtils.getBean(RedisCache.class);
        String verifyKey = CacheConstants.SMS_CAPTCHA_CODE_KEY + mobile;
        String smsCode = redisCache.getCacheObject(verifyKey);
        if (smsCode == null) {
            throw new BadCredentialsException("验证码失效");
        }
        if (!code.equals(smsCode)) {
            throw new BadCredentialsException("验证码错误");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return SmsCodeAuthenticationToken.class.isAssignableFrom(authentication);
    }
}

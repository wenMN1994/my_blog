package com.dragon.framework.config;

import com.dragon.common.utils.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Locale;

/**
 * 国际化语言设置
 *
 * @author dragon
 */
public class BlogLocaleResolver implements LocaleResolver {
    private static final String LANG = "lang";
    private static final String LANG_SESSION = "lang_session";

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String lang = request.getHeader(LANG);
        Locale locale = Locale.getDefault();
        HttpSession session = request.getSession();
        if (StringUtils.isNotEmpty(lang)) {
            String[] language = lang.split("_");
            locale = new Locale(language[0], language[1]);
            session.setAttribute(LANG_SESSION, locale);
        } else {
            Locale localeInSession = (Locale) session.getAttribute(LANG_SESSION);
            if (localeInSession != null) {
                locale = localeInSession;
            }
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}

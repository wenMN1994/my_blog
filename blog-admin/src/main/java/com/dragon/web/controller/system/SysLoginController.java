package com.dragon.web.controller.system;

import com.dragon.common.constant.Constants;
import com.dragon.common.core.domain.AjaxResult;
import com.dragon.common.core.domain.entity.SysMenu;
import com.dragon.common.core.domain.entity.SysUser;
import com.dragon.common.core.domain.model.LoginBody;
import com.dragon.common.utils.SecurityUtils;
import com.dragon.framework.web.service.SysLoginService;
import com.dragon.framework.web.service.SysPermissionService;
import com.dragon.system.service.ISysConfigService;
import com.dragon.system.service.ISysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

/**
 * 登录验证
 * 
 * @author dragon
 */
@RestController
public class SysLoginController {
    @Autowired
    private SysLoginService loginService;

    @Autowired
    private ISysMenuService menuService;

    @Autowired
    private SysPermissionService permissionService;

    @Autowired
    private ISysConfigService configService;

    /**
     * 登录方法
     * 
     * @param loginBody 登录信息
     * @return 结果
     */
    @PostMapping("/login")
    public AjaxResult login(@RequestBody LoginBody loginBody) {
        AjaxResult ajax = AjaxResult.success();
        // 生成令牌
        String token = loginService.login(loginBody.getUsername(), loginBody.getPassword(), loginBody.getCode(),
                loginBody.getUuid());
        ajax.put(Constants.TOKEN, token);
        return ajax;
    }

    /**
     * 获取用户信息
     * 
     * @return 用户信息
     */
    @GetMapping("getInfo")
    public AjaxResult getInfo() {
        SysUser user = SecurityUtils.getLoginUser().getUser();
        // 角色集合
        Set<String> roles = permissionService.getRolePermission(user);
        // 权限集合
        Set<String> permissions = permissionService.getMenuPermission(user);
        AjaxResult ajax = AjaxResult.success();
        ajax.put("user", user);
        ajax.put("roles", roles);
        ajax.put("permissions", permissions);
        return ajax;
    }

    /**
     * 获取路由信息
     * 
     * @return 路由信息
     */
    @GetMapping("getRouters")
    public AjaxResult getRouters() {
        Long userId = SecurityUtils.getUserId();
        List<SysMenu> menus = menuService.selectMenuTreeByUserId(userId);
        return AjaxResult.success(menuService.buildMenus(menus));
    }

    /**
     * 获取网站配置信息
     *
     * @return 网站配置信息
     */
    @GetMapping("/getWebsiteConfigInfo")
    public AjaxResult getWebsiteConfigInfo() {
        boolean captchaEnabled = configService.selectCaptchaEnabled();
        boolean registerUser = configService.selectRegisterUser();
        AjaxResult ajax = AjaxResult.success();
        ajax.put("captchaEnabled", captchaEnabled);
        ajax.put("registerUser", registerUser);
        return ajax;
    }
}

package com.dragon.web.controller.system;

import com.dragon.common.annotation.Log;
import com.dragon.common.config.BlogConfig;
import com.dragon.common.constant.UserConstants;
import com.dragon.common.core.controller.BaseController;
import com.dragon.common.core.domain.AjaxResult;
import com.dragon.common.core.domain.entity.SysUser;
import com.dragon.common.core.domain.model.LoginUser;
import com.dragon.common.enums.BusinessType;
import com.dragon.common.utils.SecurityUtils;
import com.dragon.common.utils.StringUtils;
import com.dragon.common.utils.file.FileUploadUtils;
import com.dragon.common.utils.oss.OssClientUtil;
import com.dragon.framework.web.service.TokenService;
import com.dragon.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

/**
 * 个人信息 业务处理
 * 
 * @author dragon
 */
@RestController
@RequestMapping("/system/user/profile")
public class SysProfileController extends BaseController {
    @Autowired
    private ISysUserService userService;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private OssClientUtil ossClientUtil;

    /**
     * 个人信息
     */
    @GetMapping
    public AjaxResult profile() {
        LoginUser loginUser = getLoginUser();
        SysUser user = loginUser.getUser();
        AjaxResult ajax = AjaxResult.success(user);
        ajax.put("roleGroup", userService.selectUserRoleGroup(loginUser.getUsername()));
        return ajax;
    }

    /**
     * 修改用户
     */
    @Log(title = "个人信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult updateProfile(@RequestBody SysUser user) {
        LoginUser loginUser = getLoginUser();
        SysUser currentUser = loginUser.getUser();
        currentUser.setNickName(user.getNickName());
        currentUser.setEmail(user.getEmail());
        currentUser.setPhonenumber(user.getPhonenumber());
        currentUser.setSex(user.getSex());
        if (StringUtils.isNotEmpty(user.getPhonenumber()) && !userService.checkPhoneUnique(currentUser)) {
            return error("修改用户'" + user.getUserName() + "'失败，手机号码已存在");
        }
        if (StringUtils.isNotEmpty(user.getEmail()) && !userService.checkEmailUnique(currentUser)) {
            return error("修改用户'" + user.getUserName() + "'失败，邮箱账号已存在");
        }
        if (userService.updateUserProfile(currentUser) > 0) {
            // 更新缓存用户信息
            tokenService.setLoginUser(loginUser);
            return success();
        }
        return error("修改个人信息异常，请联系管理员");
    }

    /**
     * 重置密码
     */
    @Log(title = "个人信息", businessType = BusinessType.UPDATE)
    @PutMapping("/updatePwd")
    public AjaxResult updatePwd(String oldPassword, String newPassword) {
        LoginUser loginUser = getLoginUser();
        String userName = loginUser.getUsername();
        String password = loginUser.getPassword();
        if (!SecurityUtils.matchesPassword(oldPassword, password)) {
            return error("修改密码失败，旧密码错误");
        }
        if (SecurityUtils.matchesPassword(newPassword, password)) {
            return error("新密码不能与旧密码相同");
        }
        newPassword = SecurityUtils.encryptPassword(newPassword);
        if (userService.resetUserPwd(userName, newPassword) > 0) {
            // 更新缓存用户密码
            loginUser.getUser().setPassword(newPassword);
            tokenService.setLoginUser(loginUser);
            return success();
        }
        return error("修改密码异常，请联系管理员");
    }

    /**
     * 头像上传
     */
    @Log(title = "用户头像", businessType = BusinessType.UPDATE)
    @PostMapping("/avatar")
    public AjaxResult avatar(@RequestParam("avatarfile") MultipartFile file) throws Exception {
        if (!file.isEmpty()) {
            LoginUser loginUser = getLoginUser();
            Map<String, String> fileInfo = ossClientUtil.uploadMultipartFileToOss(file);
            String url = "";
            if(!CollectionUtils.isEmpty(fileInfo) && userService.updateUserAvatar(loginUser.getUsername(), fileInfo, file)){
                url = fileInfo.get("url");
                AjaxResult ajax = AjaxResult.success();
                ajax.put("imgUrl", url);
                // 更新缓存用户头像
                loginUser.getUser().setAvatar(url);
                tokenService.setLoginUser(loginUser);
                return ajax;
            }
        }
        return error("上传图片异常，请联系管理员");
    }
}

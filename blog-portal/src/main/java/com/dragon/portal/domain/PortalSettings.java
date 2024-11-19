package com.dragon.portal.domain;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author: DragonWen
 * @date: 2024/6/29
 * @Version: 1.0
 * @description: 网站设置对象
 */
@Data
@ApiModel(value = "PortalSettings", description = "网站设置对象")
public class PortalSettings {

    /************基础设置***************/
    @NotBlank(message = "网站 LOGO 不能为空")
    private String logo;

    @NotBlank(message = "网站名称不能为空")
    private String name;

    @NotBlank(message = "网站作者不能为空")
    private String author;

    @NotBlank(message = "网站介绍语不能为空")
    private String introduction;

    @NotBlank(message = "网站头像不能为空")
    private String avatar;

    /************第三方平台设置***************/
    /**github*/
    private String githubHomepage;

    /**CSDN*/
    private String csdnHomepage;

    /**码云*/
    private String giteeHomepage;

    /**知乎*/
    private String zhihuHomepage;

    /************评论设置***************/
    @Email(message = "站长邮箱格式不正确")
    private String mail;

    @NotNull(message = "请设置评论管理敏感词过滤是否开启")
    private Boolean isCommentSensitiveWordsOpen;

    @NotNull(message = "请设置评论管理审核是否开启")
    private Boolean isCommentExamineOpen;

    /************会员设置***************/
    @NotBlank(message = "会员头像不能为空")
    private String memberAvatar;

    /************域名备案信息***************/
    @NotBlank(message = "备案号不能为空")
    private String icp;

    @NotBlank(message = "域名不能为空")
    private String domainName;

    @NotBlank(message = "工信部网址不能为空")
    private String miit;

    @NotBlank(message = "版权声明不能为空")
    private String copyrightNotice;

}

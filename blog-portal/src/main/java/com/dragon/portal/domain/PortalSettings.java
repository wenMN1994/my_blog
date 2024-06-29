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

    /**github*/
    private String githubHomepage;

    /**CSDN*/
    private String csdnHomepage;

    /**码云*/
    private String giteeHomepage;

    /**知乎*/
    private String zhihuHomepage;

    @Email(message = "邮箱格式不正确")
    private String mail;

    @NotNull(message = "请设置评论敏感词过滤是否开启")
    private Boolean isCommentSensitiveWordsOpen;

    @NotNull(message = "请设置评论审核是否开启")
    private Boolean isCommentExamineOpen;
}

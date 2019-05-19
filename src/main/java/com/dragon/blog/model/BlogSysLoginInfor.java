package com.dragon.blog.model;

import java.io.Serializable;
import java.util.Date;

public class BlogSysLoginInfor implements Serializable {
    /**
     * 访问ID
     *
     * @mbg.generated
     */
    private Integer infoId;

    /**
     * 登录账号
     *
     * @mbg.generated
     */
    private String loginName;

    /**
     * 登录IP地址
     *
     * @mbg.generated
     */
    private String ipaddr;

    /**
     * 登录地点
     *
     * @mbg.generated
     */
    private String loginLocation;

    /**
     * 浏览器类型
     *
     * @mbg.generated
     */
    private String browser;

    /**
     * 操作系统
     *
     * @mbg.generated
     */
    private String os;

    /**
     * 登录状态（0成功 1失败）
     *
     * @mbg.generated
     */
    private String status;

    /**
     * 提示消息
     *
     * @mbg.generated
     */
    private String msg;

    /**
     * 访问时间
     *
     * @mbg.generated
     */
    private Date loginTime;

    private static final long serialVersionUID = 1L;

    public Integer getInfoId() {
        return infoId;
    }

    public void setInfoId(Integer infoId) {
        this.infoId = infoId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getIpaddr() {
        return ipaddr;
    }

    public void setIpaddr(String ipaddr) {
        this.ipaddr = ipaddr;
    }

    public String getLoginLocation() {
        return loginLocation;
    }

    public void setLoginLocation(String loginLocation) {
        this.loginLocation = loginLocation;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", infoId=").append(infoId);
        sb.append(", loginName=").append(loginName);
        sb.append(", ipaddr=").append(ipaddr);
        sb.append(", loginLocation=").append(loginLocation);
        sb.append(", browser=").append(browser);
        sb.append(", os=").append(os);
        sb.append(", status=").append(status);
        sb.append(", msg=").append(msg);
        sb.append(", loginTime=").append(loginTime);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        BlogSysLoginInfor other = (BlogSysLoginInfor) that;
        return (this.getInfoId() == null ? other.getInfoId() == null : this.getInfoId().equals(other.getInfoId()))
            && (this.getLoginName() == null ? other.getLoginName() == null : this.getLoginName().equals(other.getLoginName()))
            && (this.getIpaddr() == null ? other.getIpaddr() == null : this.getIpaddr().equals(other.getIpaddr()))
            && (this.getLoginLocation() == null ? other.getLoginLocation() == null : this.getLoginLocation().equals(other.getLoginLocation()))
            && (this.getBrowser() == null ? other.getBrowser() == null : this.getBrowser().equals(other.getBrowser()))
            && (this.getOs() == null ? other.getOs() == null : this.getOs().equals(other.getOs()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getMsg() == null ? other.getMsg() == null : this.getMsg().equals(other.getMsg()))
            && (this.getLoginTime() == null ? other.getLoginTime() == null : this.getLoginTime().equals(other.getLoginTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getInfoId() == null) ? 0 : getInfoId().hashCode());
        result = prime * result + ((getLoginName() == null) ? 0 : getLoginName().hashCode());
        result = prime * result + ((getIpaddr() == null) ? 0 : getIpaddr().hashCode());
        result = prime * result + ((getLoginLocation() == null) ? 0 : getLoginLocation().hashCode());
        result = prime * result + ((getBrowser() == null) ? 0 : getBrowser().hashCode());
        result = prime * result + ((getOs() == null) ? 0 : getOs().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getMsg() == null) ? 0 : getMsg().hashCode());
        result = prime * result + ((getLoginTime() == null) ? 0 : getLoginTime().hashCode());
        return result;
    }
}
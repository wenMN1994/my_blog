package com.dragon.blog.model;

import com.dragon.blog.model.OnlineSession.OnlineStatus;
import java.io.Serializable;
import java.util.Date;

public class BlogSysUserOnline implements Serializable {
    /**
     * 用户会话id
     *
     * @mbg.generated
     */
    private String sessionid;

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
     * 在线状态on_line在线off_line离线
     *
     * @mbg.generated
     * @modified By：Dragon Wen
     * @description
     */
//    private String status;
    private OnlineStatus status = OnlineStatus.on_line;

    /**
     * session创建时间
     *
     * @mbg.generated
     */
    private Date startTimestamp;

    /**
     * session最后访问时间
     *
     * @mbg.generated
     */
    private Date lastAccessTime;

    /**
     * 超时时间，单位为分钟
     *
     * @mbg.generated
     */
    private Integer expireTime;

    /**
     * 备份的当前用户会话
     */
    private OnlineSession session;

    public OnlineSession getSession() {
        return session;
    }

    public void setSession(OnlineSession session) {
        this.session = session;
    }

    private static final long serialVersionUID = 1L;

    public String getSessionid() {
        return sessionid;
    }

    public void setSessionid(String sessionid) {
        this.sessionid = sessionid;
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

//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
    public OnlineStatus getStatus() {
        return status;
    }

    public void setStatus(OnlineStatus status) {
        this.status = status;
    }

    public Date getStartTimestamp() {
        return startTimestamp;
    }

    public void setStartTimestamp(Date startTimestamp) {
        this.startTimestamp = startTimestamp;
    }

    public Date getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(Date lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    public Integer getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(Integer expireTime) {
        this.expireTime = expireTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", sessionid=").append(sessionid);
        sb.append(", loginName=").append(loginName);
        sb.append(", ipaddr=").append(ipaddr);
        sb.append(", loginLocation=").append(loginLocation);
        sb.append(", browser=").append(browser);
        sb.append(", os=").append(os);
        sb.append(", status=").append(status);
        sb.append(", startTimestamp=").append(startTimestamp);
        sb.append(", lastAccessTime=").append(lastAccessTime);
        sb.append(", expireTime=").append(expireTime);
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
        BlogSysUserOnline other = (BlogSysUserOnline) that;
        return (this.getSessionid() == null ? other.getSessionid() == null : this.getSessionid().equals(other.getSessionid()))
            && (this.getLoginName() == null ? other.getLoginName() == null : this.getLoginName().equals(other.getLoginName()))
            && (this.getIpaddr() == null ? other.getIpaddr() == null : this.getIpaddr().equals(other.getIpaddr()))
            && (this.getLoginLocation() == null ? other.getLoginLocation() == null : this.getLoginLocation().equals(other.getLoginLocation()))
            && (this.getBrowser() == null ? other.getBrowser() == null : this.getBrowser().equals(other.getBrowser()))
            && (this.getOs() == null ? other.getOs() == null : this.getOs().equals(other.getOs()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getStartTimestamp() == null ? other.getStartTimestamp() == null : this.getStartTimestamp().equals(other.getStartTimestamp()))
            && (this.getLastAccessTime() == null ? other.getLastAccessTime() == null : this.getLastAccessTime().equals(other.getLastAccessTime()))
            && (this.getExpireTime() == null ? other.getExpireTime() == null : this.getExpireTime().equals(other.getExpireTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSessionid() == null) ? 0 : getSessionid().hashCode());
        result = prime * result + ((getLoginName() == null) ? 0 : getLoginName().hashCode());
        result = prime * result + ((getIpaddr() == null) ? 0 : getIpaddr().hashCode());
        result = prime * result + ((getLoginLocation() == null) ? 0 : getLoginLocation().hashCode());
        result = prime * result + ((getBrowser() == null) ? 0 : getBrowser().hashCode());
        result = prime * result + ((getOs() == null) ? 0 : getOs().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getStartTimestamp() == null) ? 0 : getStartTimestamp().hashCode());
        result = prime * result + ((getLastAccessTime() == null) ? 0 : getLastAccessTime().hashCode());
        result = prime * result + ((getExpireTime() == null) ? 0 : getExpireTime().hashCode());
        return result;
    }
}
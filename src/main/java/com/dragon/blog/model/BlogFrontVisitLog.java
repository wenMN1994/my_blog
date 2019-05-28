package com.dragon.blog.model;

import java.io.Serializable;
import java.util.Date;

public class BlogFrontVisitLog implements Serializable {
    private Integer visitId;

    /**
     * ip地址
     *
     * @mbg.generated
     */
    private String ipAddr;

    /**
     * 访问地址
     *
     * @mbg.generated
     */
    private String location;

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
     * 爬虫
     *
     * @mbg.generated
     */
    private String spider;

    /**
     * 请求地址
     *
     * @mbg.generated
     */
    private String requestUrl;

    /**
     * 访问错误的提示信息
     *
     * @mbg.generated
     */
    private String errorMsg;

    /**
     * 请求的模块
     *
     * @mbg.generated
     */
    private String title;

    private String createBy;

    private Date createTime;

    /**
     * 访问状态,1表示正常，0表示不正常
     *
     * @mbg.generated
     */
    private String status;

    private static final long serialVersionUID = 1L;

    public Integer getVisitId() {
        return visitId;
    }

    public void setVisitId(Integer visitId) {
        this.visitId = visitId;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public String getSpider() {
        return spider;
    }

    public void setSpider(String spider) {
        this.spider = spider;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", visitId=").append(visitId);
        sb.append(", ipAddr=").append(ipAddr);
        sb.append(", location=").append(location);
        sb.append(", browser=").append(browser);
        sb.append(", os=").append(os);
        sb.append(", spider=").append(spider);
        sb.append(", requestUrl=").append(requestUrl);
        sb.append(", errorMsg=").append(errorMsg);
        sb.append(", title=").append(title);
        sb.append(", createBy=").append(createBy);
        sb.append(", createTime=").append(createTime);
        sb.append(", status=").append(status);
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
        BlogFrontVisitLog other = (BlogFrontVisitLog) that;
        return (this.getVisitId() == null ? other.getVisitId() == null : this.getVisitId().equals(other.getVisitId()))
            && (this.getIpAddr() == null ? other.getIpAddr() == null : this.getIpAddr().equals(other.getIpAddr()))
            && (this.getLocation() == null ? other.getLocation() == null : this.getLocation().equals(other.getLocation()))
            && (this.getBrowser() == null ? other.getBrowser() == null : this.getBrowser().equals(other.getBrowser()))
            && (this.getOs() == null ? other.getOs() == null : this.getOs().equals(other.getOs()))
            && (this.getSpider() == null ? other.getSpider() == null : this.getSpider().equals(other.getSpider()))
            && (this.getRequestUrl() == null ? other.getRequestUrl() == null : this.getRequestUrl().equals(other.getRequestUrl()))
            && (this.getErrorMsg() == null ? other.getErrorMsg() == null : this.getErrorMsg().equals(other.getErrorMsg()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getVisitId() == null) ? 0 : getVisitId().hashCode());
        result = prime * result + ((getIpAddr() == null) ? 0 : getIpAddr().hashCode());
        result = prime * result + ((getLocation() == null) ? 0 : getLocation().hashCode());
        result = prime * result + ((getBrowser() == null) ? 0 : getBrowser().hashCode());
        result = prime * result + ((getOs() == null) ? 0 : getOs().hashCode());
        result = prime * result + ((getSpider() == null) ? 0 : getSpider().hashCode());
        result = prime * result + ((getRequestUrl() == null) ? 0 : getRequestUrl().hashCode());
        result = prime * result + ((getErrorMsg() == null) ? 0 : getErrorMsg().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }
}
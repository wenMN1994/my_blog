package com.dragon.blog.model;

import java.io.Serializable;
import java.util.Date;

public class BlogSysBlickList implements Serializable {
    private Integer blacklistId;

    /**
     * 黑名单的IP地址
     *
     * @mbg.generated
     */
    private String ipAddr;

    /**
     * 封禁原因
     *
     * @mbg.generated
     */
    private String description;

    /**
     * 拦截次数
     *
     * @mbg.generated
     */
    private Integer count;

    /**
     * 最近一次访问的时间
     *
     * @mbg.generated
     */
    private Date lastAccessTime;

    /**
     * 上一次请求的地址
     *
     * @mbg.generated
     */
    private String lastAccessUrl;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Integer getBlacklistId() {
        return blacklistId;
    }

    public void setBlacklistId(Integer blacklistId) {
        this.blacklistId = blacklistId;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getLastAccessTime() {
        return lastAccessTime;
    }

    public void setLastAccessTime(Date lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    public String getLastAccessUrl() {
        return lastAccessUrl;
    }

    public void setLastAccessUrl(String lastAccessUrl) {
        this.lastAccessUrl = lastAccessUrl;
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

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", blacklistId=").append(blacklistId);
        sb.append(", ipAddr=").append(ipAddr);
        sb.append(", description=").append(description);
        sb.append(", count=").append(count);
        sb.append(", lastAccessTime=").append(lastAccessTime);
        sb.append(", lastAccessUrl=").append(lastAccessUrl);
        sb.append(", createBy=").append(createBy);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", updateTime=").append(updateTime);
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
        BlogSysBlickList other = (BlogSysBlickList) that;
        return (this.getBlacklistId() == null ? other.getBlacklistId() == null : this.getBlacklistId().equals(other.getBlacklistId()))
            && (this.getIpAddr() == null ? other.getIpAddr() == null : this.getIpAddr().equals(other.getIpAddr()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getCount() == null ? other.getCount() == null : this.getCount().equals(other.getCount()))
            && (this.getLastAccessTime() == null ? other.getLastAccessTime() == null : this.getLastAccessTime().equals(other.getLastAccessTime()))
            && (this.getLastAccessUrl() == null ? other.getLastAccessUrl() == null : this.getLastAccessUrl().equals(other.getLastAccessUrl()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateBy() == null ? other.getUpdateBy() == null : this.getUpdateBy().equals(other.getUpdateBy()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBlacklistId() == null) ? 0 : getBlacklistId().hashCode());
        result = prime * result + ((getIpAddr() == null) ? 0 : getIpAddr().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getCount() == null) ? 0 : getCount().hashCode());
        result = prime * result + ((getLastAccessTime() == null) ? 0 : getLastAccessTime().hashCode());
        result = prime * result + ((getLastAccessUrl() == null) ? 0 : getLastAccessUrl().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateBy() == null) ? 0 : getUpdateBy().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }
}
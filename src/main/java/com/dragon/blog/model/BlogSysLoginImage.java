package com.dragon.blog.model;

import java.io.Serializable;

public class BlogSysLoginImage implements Serializable {
    /**
     * 登录图片ID
     *
     * @mbg.generated
     */
    private String loginImageId;

    /**
     * 文件名
     *
     * @mbg.generated
     */
    private String name;

    /**
     * 路径
     *
     * @mbg.generated
     */
    private String filePath;

    /**
     * 状态  （1：启动，0：停用）
     *
     * @mbg.generated
     */
    private Integer status;

    /**
     * 排序
     *
     * @mbg.generated
     */
    private Integer orderBy;

    private static final long serialVersionUID = 1L;

    public String getLoginImageId() {
        return loginImageId;
    }

    public void setLoginImageId(String loginImageId) {
        this.loginImageId = loginImageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(Integer orderBy) {
        this.orderBy = orderBy;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", loginImageId=").append(loginImageId);
        sb.append(", name=").append(name);
        sb.append(", filePath=").append(filePath);
        sb.append(", status=").append(status);
        sb.append(", orderBy=").append(orderBy);
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
        BlogSysLoginImage other = (BlogSysLoginImage) that;
        return (this.getLoginImageId() == null ? other.getLoginImageId() == null : this.getLoginImageId().equals(other.getLoginImageId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getFilePath() == null ? other.getFilePath() == null : this.getFilePath().equals(other.getFilePath()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getOrderBy() == null ? other.getOrderBy() == null : this.getOrderBy().equals(other.getOrderBy()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLoginImageId() == null) ? 0 : getLoginImageId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getFilePath() == null) ? 0 : getFilePath().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getOrderBy() == null) ? 0 : getOrderBy().hashCode());
        return result;
    }
}
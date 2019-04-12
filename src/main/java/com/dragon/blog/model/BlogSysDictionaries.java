package com.dragon.blog.model;

import java.io.Serializable;

public class BlogSysDictionaries implements Serializable {
    /**
     * 字典ID
     *
     * @mbg.generated
     */
    private String dictionariesId;

    /**
     * 字典名称（中文）
     *
     * @mbg.generated
     */
    private String nameCh;

    /**
     * 字典名称（英文）
     *
     * @mbg.generated
     */
    private String nameEn;

    /**
     * 编码
     *
     * @mbg.generated
     */
    private String encoding;

    /**
     * 排序
     *
     * @mbg.generated
     */
    private Integer orderBy;

    /**
     * 上级ID
     *
     * @mbg.generated
     */
    private String parentId;

    /**
     * 数据库表组
     *
     * @mbg.generated
     */
    private String tasName;

    private static final long serialVersionUID = 1L;

    public String getDictionariesId() {
        return dictionariesId;
    }

    public void setDictionariesId(String dictionariesId) {
        this.dictionariesId = dictionariesId;
    }

    public String getNameCh() {
        return nameCh;
    }

    public void setNameCh(String nameCh) {
        this.nameCh = nameCh;
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public Integer getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(Integer orderBy) {
        this.orderBy = orderBy;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getTasName() {
        return tasName;
    }

    public void setTasName(String tasName) {
        this.tasName = tasName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dictionariesId=").append(dictionariesId);
        sb.append(", nameCh=").append(nameCh);
        sb.append(", nameEn=").append(nameEn);
        sb.append(", encoding=").append(encoding);
        sb.append(", orderBy=").append(orderBy);
        sb.append(", parentId=").append(parentId);
        sb.append(", tasName=").append(tasName);
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
        BlogSysDictionaries other = (BlogSysDictionaries) that;
        return (this.getDictionariesId() == null ? other.getDictionariesId() == null : this.getDictionariesId().equals(other.getDictionariesId()))
            && (this.getNameCh() == null ? other.getNameCh() == null : this.getNameCh().equals(other.getNameCh()))
            && (this.getNameEn() == null ? other.getNameEn() == null : this.getNameEn().equals(other.getNameEn()))
            && (this.getEncoding() == null ? other.getEncoding() == null : this.getEncoding().equals(other.getEncoding()))
            && (this.getOrderBy() == null ? other.getOrderBy() == null : this.getOrderBy().equals(other.getOrderBy()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getTasName() == null ? other.getTasName() == null : this.getTasName().equals(other.getTasName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDictionariesId() == null) ? 0 : getDictionariesId().hashCode());
        result = prime * result + ((getNameCh() == null) ? 0 : getNameCh().hashCode());
        result = prime * result + ((getNameEn() == null) ? 0 : getNameEn().hashCode());
        result = prime * result + ((getEncoding() == null) ? 0 : getEncoding().hashCode());
        result = prime * result + ((getOrderBy() == null) ? 0 : getOrderBy().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getTasName() == null) ? 0 : getTasName().hashCode());
        return result;
    }
}
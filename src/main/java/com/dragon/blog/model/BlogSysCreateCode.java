package com.dragon.blog.model;

import java.io.Serializable;

public class BlogSysCreateCode implements Serializable {
    /**
     * 创建代码ID
     *
     * @mbg.generated
     */
    private String createCodeId;

    /**
     * 包名
     *
     * @mbg.generated
     */
    private String packageName;

    /**
     * 类名
     *
     * @mbg.generated
     */
    private String objectName;

    /**
     * 表名
     *
     * @mbg.generated
     */
    private String tableName;

    /**
     * 属性集合
     *
     * @mbg.generated
     */
    private String fieldList;

    /**
     * 创建时间
     *
     * @mbg.generated
     */
    private String createTime;

    /**
     * 类型
     *
     * @mbg.generated
     */
    private String type;

    /**
     * 说明
     *
     * @mbg.generated
     */
    private String title;

    private static final long serialVersionUID = 1L;

    public String getCreateCodeId() {
        return createCodeId;
    }

    public void setCreateCodeId(String createCodeId) {
        this.createCodeId = createCodeId;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getFieldList() {
        return fieldList;
    }

    public void setFieldList(String fieldList) {
        this.fieldList = fieldList;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", createCodeId=").append(createCodeId);
        sb.append(", packageName=").append(packageName);
        sb.append(", objectName=").append(objectName);
        sb.append(", tableName=").append(tableName);
        sb.append(", fieldList=").append(fieldList);
        sb.append(", createTime=").append(createTime);
        sb.append(", type=").append(type);
        sb.append(", title=").append(title);
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
        BlogSysCreateCode other = (BlogSysCreateCode) that;
        return (this.getCreateCodeId() == null ? other.getCreateCodeId() == null : this.getCreateCodeId().equals(other.getCreateCodeId()))
            && (this.getPackageName() == null ? other.getPackageName() == null : this.getPackageName().equals(other.getPackageName()))
            && (this.getObjectName() == null ? other.getObjectName() == null : this.getObjectName().equals(other.getObjectName()))
            && (this.getTableName() == null ? other.getTableName() == null : this.getTableName().equals(other.getTableName()))
            && (this.getFieldList() == null ? other.getFieldList() == null : this.getFieldList().equals(other.getFieldList()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCreateCodeId() == null) ? 0 : getCreateCodeId().hashCode());
        result = prime * result + ((getPackageName() == null) ? 0 : getPackageName().hashCode());
        result = prime * result + ((getObjectName() == null) ? 0 : getObjectName().hashCode());
        result = prime * result + ((getTableName() == null) ? 0 : getTableName().hashCode());
        result = prime * result + ((getFieldList() == null) ? 0 : getFieldList().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        return result;
    }
}
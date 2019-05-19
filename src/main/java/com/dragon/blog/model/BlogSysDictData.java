package com.dragon.blog.model;

import java.io.Serializable;
import java.util.Date;

public class BlogSysDictData implements Serializable {
    /**
     * 字典编码
     *
     * @mbg.generated
     */
    private Integer dictCode;

    /**
     * 字典排序
     *
     * @mbg.generated
     */
    private Integer dictSort;

    /**
     * 字典标签
     *
     * @mbg.generated
     */
    private String dictLabel;

    /**
     * 字典键值
     *
     * @mbg.generated
     */
    private String dictValue;

    /**
     * 字典类型
     *
     * @mbg.generated
     */
    private String dictType;

    /**
     * 样式属性（其他样式扩展）
     *
     * @mbg.generated
     */
    private String cssClass;

    /**
     * 表格回显样式
     *
     * @mbg.generated
     */
    private String listClass;

    /**
     * 是否默认（Y是 N否）
     *
     * @mbg.generated
     */
    private String isDefault;

    /**
     * 状态（0正常 1停用）
     *
     * @mbg.generated
     */
    private String status;

    /**
     * 创建者
     *
     * @mbg.generated
     */
    private String createBy;

    /**
     * 创建时间
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     * 更新者
     *
     * @mbg.generated
     */
    private String updateBy;

    /**
     * 更新时间
     *
     * @mbg.generated
     */
    private Date updateTime;

    /**
     * 备注
     *
     * @mbg.generated
     */
    private String remark;

    private static final long serialVersionUID = 1L;

    public Integer getDictCode() {
        return dictCode;
    }

    public void setDictCode(Integer dictCode) {
        this.dictCode = dictCode;
    }

    public Integer getDictSort() {
        return dictSort;
    }

    public void setDictSort(Integer dictSort) {
        this.dictSort = dictSort;
    }

    public String getDictLabel() {
        return dictLabel;
    }

    public void setDictLabel(String dictLabel) {
        this.dictLabel = dictLabel;
    }

    public String getDictValue() {
        return dictValue;
    }

    public void setDictValue(String dictValue) {
        this.dictValue = dictValue;
    }

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    public String getListClass() {
        return listClass;
    }

    public void setListClass(String listClass) {
        this.listClass = listClass;
    }

    public String getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(String isDefault) {
        this.isDefault = isDefault;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", dictCode=").append(dictCode);
        sb.append(", dictSort=").append(dictSort);
        sb.append(", dictLabel=").append(dictLabel);
        sb.append(", dictValue=").append(dictValue);
        sb.append(", dictType=").append(dictType);
        sb.append(", cssClass=").append(cssClass);
        sb.append(", listClass=").append(listClass);
        sb.append(", isDefault=").append(isDefault);
        sb.append(", status=").append(status);
        sb.append(", createBy=").append(createBy);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", remark=").append(remark);
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
        BlogSysDictData other = (BlogSysDictData) that;
        return (this.getDictCode() == null ? other.getDictCode() == null : this.getDictCode().equals(other.getDictCode()))
            && (this.getDictSort() == null ? other.getDictSort() == null : this.getDictSort().equals(other.getDictSort()))
            && (this.getDictLabel() == null ? other.getDictLabel() == null : this.getDictLabel().equals(other.getDictLabel()))
            && (this.getDictValue() == null ? other.getDictValue() == null : this.getDictValue().equals(other.getDictValue()))
            && (this.getDictType() == null ? other.getDictType() == null : this.getDictType().equals(other.getDictType()))
            && (this.getCssClass() == null ? other.getCssClass() == null : this.getCssClass().equals(other.getCssClass()))
            && (this.getListClass() == null ? other.getListClass() == null : this.getListClass().equals(other.getListClass()))
            && (this.getIsDefault() == null ? other.getIsDefault() == null : this.getIsDefault().equals(other.getIsDefault()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateBy() == null ? other.getUpdateBy() == null : this.getUpdateBy().equals(other.getUpdateBy()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDictCode() == null) ? 0 : getDictCode().hashCode());
        result = prime * result + ((getDictSort() == null) ? 0 : getDictSort().hashCode());
        result = prime * result + ((getDictLabel() == null) ? 0 : getDictLabel().hashCode());
        result = prime * result + ((getDictValue() == null) ? 0 : getDictValue().hashCode());
        result = prime * result + ((getDictType() == null) ? 0 : getDictType().hashCode());
        result = prime * result + ((getCssClass() == null) ? 0 : getCssClass().hashCode());
        result = prime * result + ((getListClass() == null) ? 0 : getListClass().hashCode());
        result = prime * result + ((getIsDefault() == null) ? 0 : getIsDefault().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateBy() == null) ? 0 : getUpdateBy().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }
}
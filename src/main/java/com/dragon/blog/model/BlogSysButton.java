package com.dragon.blog.model;

import java.io.Serializable;

public class BlogSysButton implements Serializable {
    /**
     * 主键ID
     *
     * @mbg.generated
     */
    private String buttonId;

    /**
     * 名称
     *
     * @mbg.generated
     */
    private String name;

    /**
     * 权限标识
     *
     * @mbg.generated
     */
    private String rightsName;

    /**
     * 备注
     *
     * @mbg.generated
     */
    private String remark;

    private static final long serialVersionUID = 1L;

    public String getButtonId() {
        return buttonId;
    }

    public void setButtonId(String buttonId) {
        this.buttonId = buttonId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRightsName() {
        return rightsName;
    }

    public void setRightsName(String rightsName) {
        this.rightsName = rightsName;
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
        sb.append(", buttonId=").append(buttonId);
        sb.append(", name=").append(name);
        sb.append(", rightsName=").append(rightsName);
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
        BlogSysButton other = (BlogSysButton) that;
        return (this.getButtonId() == null ? other.getButtonId() == null : this.getButtonId().equals(other.getButtonId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getRightsName() == null ? other.getRightsName() == null : this.getRightsName().equals(other.getRightsName()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getButtonId() == null) ? 0 : getButtonId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getRightsName() == null) ? 0 : getRightsName().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        return result;
    }
}
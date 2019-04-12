package com.dragon.blog.model;

import java.io.Serializable;

public class BlogSysRoleButton implements Serializable {
    /**
     * 主键ID
     *
     * @mbg.generated
     */
    private String roleButtonId;

    /**
     * 角色ID
     *
     * @mbg.generated
     */
    private String roleId;

    /**
     * 按钮ID
     *
     * @mbg.generated
     */
    private String buttonId;

    private static final long serialVersionUID = 1L;

    public String getRoleButtonId() {
        return roleButtonId;
    }

    public void setRoleButtonId(String roleButtonId) {
        this.roleButtonId = roleButtonId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getButtonId() {
        return buttonId;
    }

    public void setButtonId(String buttonId) {
        this.buttonId = buttonId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", roleButtonId=").append(roleButtonId);
        sb.append(", roleId=").append(roleId);
        sb.append(", buttonId=").append(buttonId);
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
        BlogSysRoleButton other = (BlogSysRoleButton) that;
        return (this.getRoleButtonId() == null ? other.getRoleButtonId() == null : this.getRoleButtonId().equals(other.getRoleButtonId()))
            && (this.getRoleId() == null ? other.getRoleId() == null : this.getRoleId().equals(other.getRoleId()))
            && (this.getButtonId() == null ? other.getButtonId() == null : this.getButtonId().equals(other.getButtonId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRoleButtonId() == null) ? 0 : getRoleButtonId().hashCode());
        result = prime * result + ((getRoleId() == null) ? 0 : getRoleId().hashCode());
        result = prime * result + ((getButtonId() == null) ? 0 : getButtonId().hashCode());
        return result;
    }
}
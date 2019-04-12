package com.dragon.blog.model;

import java.io.Serializable;

public class BlogSysRole implements Serializable {
    /**
     * 角色ID
     *
     * @mbg.generated
     */
    private String roleId;

    /**
     * 角色名称
     *
     * @mbg.generated
     */
    private String roleName;

    /**
     * 权限
     *
     * @mbg.generated
     */
    private String rights;

    /**
     * 上级ID
     *
     * @mbg.generated
     */
    private String parentId;

    /**
     * 新增权限
     *
     * @mbg.generated
     */
    private String addRights;

    /**
     * 删除权限
     *
     * @mbg.generated
     */
    private String delRights;

    /**
     * 修改权限
     *
     * @mbg.generated
     */
    private String editRights;

    /**
     * 查看权限
     *
     * @mbg.generated
     */
    private String checkRight;

    private static final long serialVersionUID = 1L;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRights() {
        return rights;
    }

    public void setRights(String rights) {
        this.rights = rights;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getAddRights() {
        return addRights;
    }

    public void setAddRights(String addRights) {
        this.addRights = addRights;
    }

    public String getDelRights() {
        return delRights;
    }

    public void setDelRights(String delRights) {
        this.delRights = delRights;
    }

    public String getEditRights() {
        return editRights;
    }

    public void setEditRights(String editRights) {
        this.editRights = editRights;
    }

    public String getCheckRight() {
        return checkRight;
    }

    public void setCheckRight(String checkRight) {
        this.checkRight = checkRight;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", roleId=").append(roleId);
        sb.append(", roleName=").append(roleName);
        sb.append(", rights=").append(rights);
        sb.append(", parentId=").append(parentId);
        sb.append(", addRights=").append(addRights);
        sb.append(", delRights=").append(delRights);
        sb.append(", editRights=").append(editRights);
        sb.append(", checkRight=").append(checkRight);
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
        BlogSysRole other = (BlogSysRole) that;
        return (this.getRoleId() == null ? other.getRoleId() == null : this.getRoleId().equals(other.getRoleId()))
            && (this.getRoleName() == null ? other.getRoleName() == null : this.getRoleName().equals(other.getRoleName()))
            && (this.getRights() == null ? other.getRights() == null : this.getRights().equals(other.getRights()))
            && (this.getParentId() == null ? other.getParentId() == null : this.getParentId().equals(other.getParentId()))
            && (this.getAddRights() == null ? other.getAddRights() == null : this.getAddRights().equals(other.getAddRights()))
            && (this.getDelRights() == null ? other.getDelRights() == null : this.getDelRights().equals(other.getDelRights()))
            && (this.getEditRights() == null ? other.getEditRights() == null : this.getEditRights().equals(other.getEditRights()))
            && (this.getCheckRight() == null ? other.getCheckRight() == null : this.getCheckRight().equals(other.getCheckRight()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRoleId() == null) ? 0 : getRoleId().hashCode());
        result = prime * result + ((getRoleName() == null) ? 0 : getRoleName().hashCode());
        result = prime * result + ((getRights() == null) ? 0 : getRights().hashCode());
        result = prime * result + ((getParentId() == null) ? 0 : getParentId().hashCode());
        result = prime * result + ((getAddRights() == null) ? 0 : getAddRights().hashCode());
        result = prime * result + ((getDelRights() == null) ? 0 : getDelRights().hashCode());
        result = prime * result + ((getEditRights() == null) ? 0 : getEditRights().hashCode());
        result = prime * result + ((getCheckRight() == null) ? 0 : getCheckRight().hashCode());
        return result;
    }
}
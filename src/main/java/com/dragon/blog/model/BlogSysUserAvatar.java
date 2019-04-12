package com.dragon.blog.model;

import java.io.Serializable;

public class BlogSysUserAvatar implements Serializable {
    /**
     * 头像ID
     *
     * @mbg.generated
     */
    private String userPhotoId;

    /**
     * 用户名
     *
     * @mbg.generated
     */
    private String userName;

    /**
     * 照片原图
     *
     * @mbg.generated
     */
    private String photo;

    /**
     * 头像1
     *
     * @mbg.generated
     */
    private String avatarOne;

    /**
     * 头像2
     *
     * @mbg.generated
     */
    private String avatarTwo;

    /**
     * 头像3
     *
     * @mbg.generated
     */
    private String avatarThree;

    private static final long serialVersionUID = 1L;

    public String getUserPhotoId() {
        return userPhotoId;
    }

    public void setUserPhotoId(String userPhotoId) {
        this.userPhotoId = userPhotoId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getAvatarOne() {
        return avatarOne;
    }

    public void setAvatarOne(String avatarOne) {
        this.avatarOne = avatarOne;
    }

    public String getAvatarTwo() {
        return avatarTwo;
    }

    public void setAvatarTwo(String avatarTwo) {
        this.avatarTwo = avatarTwo;
    }

    public String getAvatarThree() {
        return avatarThree;
    }

    public void setAvatarThree(String avatarThree) {
        this.avatarThree = avatarThree;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userPhotoId=").append(userPhotoId);
        sb.append(", userName=").append(userName);
        sb.append(", photo=").append(photo);
        sb.append(", avatarOne=").append(avatarOne);
        sb.append(", avatarTwo=").append(avatarTwo);
        sb.append(", avatarThree=").append(avatarThree);
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
        BlogSysUserAvatar other = (BlogSysUserAvatar) that;
        return (this.getUserPhotoId() == null ? other.getUserPhotoId() == null : this.getUserPhotoId().equals(other.getUserPhotoId()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getPhoto() == null ? other.getPhoto() == null : this.getPhoto().equals(other.getPhoto()))
            && (this.getAvatarOne() == null ? other.getAvatarOne() == null : this.getAvatarOne().equals(other.getAvatarOne()))
            && (this.getAvatarTwo() == null ? other.getAvatarTwo() == null : this.getAvatarTwo().equals(other.getAvatarTwo()))
            && (this.getAvatarThree() == null ? other.getAvatarThree() == null : this.getAvatarThree().equals(other.getAvatarThree()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserPhotoId() == null) ? 0 : getUserPhotoId().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getPhoto() == null) ? 0 : getPhoto().hashCode());
        result = prime * result + ((getAvatarOne() == null) ? 0 : getAvatarOne().hashCode());
        result = prime * result + ((getAvatarTwo() == null) ? 0 : getAvatarTwo().hashCode());
        result = prime * result + ((getAvatarThree() == null) ? 0 : getAvatarThree().hashCode());
        return result;
    }
}
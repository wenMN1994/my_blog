package com.dragon.blog.model;

import java.io.Serializable;
import java.util.Date;

public class BlogAds implements Serializable {
    /**
     * 自增id
     *
     * @mbg.generated
     */
    private Integer adId;

    /**
     * 广告位置ID
     *
     * @mbg.generated
     */
    private Integer adPositionId;

    /**
     * 广告文件
     *
     * @mbg.generated
     */
    private String adFile;

    /**
     * 广告名称
     *
     * @mbg.generated
     */
    private String adName;

    /**
     * 广告网址
     *
     * @mbg.generated
     */
    private String adUrl;

    /**
     * 广告开始日期
     *
     * @mbg.generated
     */
    private Date adStartDate;

    /**
     * 广告结束日期
     *
     * @mbg.generated
     */
    private Date adEndDate;

    /**
     * 排序号
     *
     * @mbg.generated
     */
    private Integer adSort;

    /**
     * 广告点击数
     *
     * @mbg.generated
     */
    private Integer adClickNum;

    /**
     * 广告类型
     *
     * @mbg.generated
     */
    private Byte positionType;

    /**
     * 删除标志	-1:删除 1:有效
     *
     * @mbg.generated
     */
    private Byte dataFlag;

    /**
     * 创建时间
     *
     * @mbg.generated
     */
    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getAdId() {
        return adId;
    }

    public void setAdId(Integer adId) {
        this.adId = adId;
    }

    public Integer getAdPositionId() {
        return adPositionId;
    }

    public void setAdPositionId(Integer adPositionId) {
        this.adPositionId = adPositionId;
    }

    public String getAdFile() {
        return adFile;
    }

    public void setAdFile(String adFile) {
        this.adFile = adFile;
    }

    public String getAdName() {
        return adName;
    }

    public void setAdName(String adName) {
        this.adName = adName;
    }

    public String getAdUrl() {
        return adUrl;
    }

    public void setAdUrl(String adUrl) {
        this.adUrl = adUrl;
    }

    public Date getAdStartDate() {
        return adStartDate;
    }

    public void setAdStartDate(Date adStartDate) {
        this.adStartDate = adStartDate;
    }

    public Date getAdEndDate() {
        return adEndDate;
    }

    public void setAdEndDate(Date adEndDate) {
        this.adEndDate = adEndDate;
    }

    public Integer getAdSort() {
        return adSort;
    }

    public void setAdSort(Integer adSort) {
        this.adSort = adSort;
    }

    public Integer getAdClickNum() {
        return adClickNum;
    }

    public void setAdClickNum(Integer adClickNum) {
        this.adClickNum = adClickNum;
    }

    public Byte getPositionType() {
        return positionType;
    }

    public void setPositionType(Byte positionType) {
        this.positionType = positionType;
    }

    public Byte getDataFlag() {
        return dataFlag;
    }

    public void setDataFlag(Byte dataFlag) {
        this.dataFlag = dataFlag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", adId=").append(adId);
        sb.append(", adPositionId=").append(adPositionId);
        sb.append(", adFile=").append(adFile);
        sb.append(", adName=").append(adName);
        sb.append(", adUrl=").append(adUrl);
        sb.append(", adStartDate=").append(adStartDate);
        sb.append(", adEndDate=").append(adEndDate);
        sb.append(", adSort=").append(adSort);
        sb.append(", adClickNum=").append(adClickNum);
        sb.append(", positionType=").append(positionType);
        sb.append(", dataFlag=").append(dataFlag);
        sb.append(", createTime=").append(createTime);
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
        BlogAds other = (BlogAds) that;
        return (this.getAdId() == null ? other.getAdId() == null : this.getAdId().equals(other.getAdId()))
            && (this.getAdPositionId() == null ? other.getAdPositionId() == null : this.getAdPositionId().equals(other.getAdPositionId()))
            && (this.getAdFile() == null ? other.getAdFile() == null : this.getAdFile().equals(other.getAdFile()))
            && (this.getAdName() == null ? other.getAdName() == null : this.getAdName().equals(other.getAdName()))
            && (this.getAdUrl() == null ? other.getAdUrl() == null : this.getAdUrl().equals(other.getAdUrl()))
            && (this.getAdStartDate() == null ? other.getAdStartDate() == null : this.getAdStartDate().equals(other.getAdStartDate()))
            && (this.getAdEndDate() == null ? other.getAdEndDate() == null : this.getAdEndDate().equals(other.getAdEndDate()))
            && (this.getAdSort() == null ? other.getAdSort() == null : this.getAdSort().equals(other.getAdSort()))
            && (this.getAdClickNum() == null ? other.getAdClickNum() == null : this.getAdClickNum().equals(other.getAdClickNum()))
            && (this.getPositionType() == null ? other.getPositionType() == null : this.getPositionType().equals(other.getPositionType()))
            && (this.getDataFlag() == null ? other.getDataFlag() == null : this.getDataFlag().equals(other.getDataFlag()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAdId() == null) ? 0 : getAdId().hashCode());
        result = prime * result + ((getAdPositionId() == null) ? 0 : getAdPositionId().hashCode());
        result = prime * result + ((getAdFile() == null) ? 0 : getAdFile().hashCode());
        result = prime * result + ((getAdName() == null) ? 0 : getAdName().hashCode());
        result = prime * result + ((getAdUrl() == null) ? 0 : getAdUrl().hashCode());
        result = prime * result + ((getAdStartDate() == null) ? 0 : getAdStartDate().hashCode());
        result = prime * result + ((getAdEndDate() == null) ? 0 : getAdEndDate().hashCode());
        result = prime * result + ((getAdSort() == null) ? 0 : getAdSort().hashCode());
        result = prime * result + ((getAdClickNum() == null) ? 0 : getAdClickNum().hashCode());
        result = prime * result + ((getPositionType() == null) ? 0 : getPositionType().hashCode());
        result = prime * result + ((getDataFlag() == null) ? 0 : getDataFlag().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }
}
package com.dragon.blog.model;

import java.io.Serializable;

public class BlogAdPositions implements Serializable {
    /**
     * 自增ID
     *
     * @mbg.generated
     */
    private Integer positionId;

    /**
     * 广告类型  1：PC版
     *
     * @mbg.generated
     */
    private Byte positionType;

    /**
     * 广告位置名称
     *
     * @mbg.generated
     */
    private String positionName;

    /**
     * 广告位置代码
     *
     * @mbg.generated
     */
    private Byte dataFlag;

    private String positionCode;

    /**
     * 排序号
     *
     * @mbg.generated
     */
    private Integer apSort;

    private static final long serialVersionUID = 1L;

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public Byte getPositionType() {
        return positionType;
    }

    public void setPositionType(Byte positionType) {
        this.positionType = positionType;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Byte getDataFlag() {
        return dataFlag;
    }

    public void setDataFlag(Byte dataFlag) {
        this.dataFlag = dataFlag;
    }

    public String getPositionCode() {
        return positionCode;
    }

    public void setPositionCode(String positionCode) {
        this.positionCode = positionCode;
    }

    public Integer getApSort() {
        return apSort;
    }

    public void setApSort(Integer apSort) {
        this.apSort = apSort;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", positionId=").append(positionId);
        sb.append(", positionType=").append(positionType);
        sb.append(", positionName=").append(positionName);
        sb.append(", dataFlag=").append(dataFlag);
        sb.append(", positionCode=").append(positionCode);
        sb.append(", apSort=").append(apSort);
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
        BlogAdPositions other = (BlogAdPositions) that;
        return (this.getPositionId() == null ? other.getPositionId() == null : this.getPositionId().equals(other.getPositionId()))
            && (this.getPositionType() == null ? other.getPositionType() == null : this.getPositionType().equals(other.getPositionType()))
            && (this.getPositionName() == null ? other.getPositionName() == null : this.getPositionName().equals(other.getPositionName()))
            && (this.getDataFlag() == null ? other.getDataFlag() == null : this.getDataFlag().equals(other.getDataFlag()))
            && (this.getPositionCode() == null ? other.getPositionCode() == null : this.getPositionCode().equals(other.getPositionCode()))
            && (this.getApSort() == null ? other.getApSort() == null : this.getApSort().equals(other.getApSort()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPositionId() == null) ? 0 : getPositionId().hashCode());
        result = prime * result + ((getPositionType() == null) ? 0 : getPositionType().hashCode());
        result = prime * result + ((getPositionName() == null) ? 0 : getPositionName().hashCode());
        result = prime * result + ((getDataFlag() == null) ? 0 : getDataFlag().hashCode());
        result = prime * result + ((getPositionCode() == null) ? 0 : getPositionCode().hashCode());
        result = prime * result + ((getApSort() == null) ? 0 : getApSort().hashCode());
        return result;
    }
}
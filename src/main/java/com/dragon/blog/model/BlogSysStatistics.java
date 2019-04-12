package com.dragon.blog.model;

import java.io.Serializable;

public class BlogSysStatistics implements Serializable {
    /**
     * 主键ID
     *
     * @mbg.generated
     */
    private String statisticsId;

    /**
     * IP地址
     *
     * @mbg.generated
     */
    private String ip;

    /**
     * 地区
     *
     * @mbg.generated
     */
    private String arer;

    /**
     * 网络运营商
     *
     * @mbg.generated
     */
    private String operator;

    /**
     * 日期
     *
     * @mbg.generated
     */
    private String date;

    /**
     * 时间
     *
     * @mbg.generated
     */
    private String time;

    /**
     * 省份
     *
     * @mbg.generated
     */
    private String region;

    private static final long serialVersionUID = 1L;

    public String getStatisticsId() {
        return statisticsId;
    }

    public void setStatisticsId(String statisticsId) {
        this.statisticsId = statisticsId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getArer() {
        return arer;
    }

    public void setArer(String arer) {
        this.arer = arer;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", statisticsId=").append(statisticsId);
        sb.append(", ip=").append(ip);
        sb.append(", arer=").append(arer);
        sb.append(", operator=").append(operator);
        sb.append(", date=").append(date);
        sb.append(", time=").append(time);
        sb.append(", region=").append(region);
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
        BlogSysStatistics other = (BlogSysStatistics) that;
        return (this.getStatisticsId() == null ? other.getStatisticsId() == null : this.getStatisticsId().equals(other.getStatisticsId()))
            && (this.getIp() == null ? other.getIp() == null : this.getIp().equals(other.getIp()))
            && (this.getArer() == null ? other.getArer() == null : this.getArer().equals(other.getArer()))
            && (this.getOperator() == null ? other.getOperator() == null : this.getOperator().equals(other.getOperator()))
            && (this.getDate() == null ? other.getDate() == null : this.getDate().equals(other.getDate()))
            && (this.getTime() == null ? other.getTime() == null : this.getTime().equals(other.getTime()))
            && (this.getRegion() == null ? other.getRegion() == null : this.getRegion().equals(other.getRegion()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getStatisticsId() == null) ? 0 : getStatisticsId().hashCode());
        result = prime * result + ((getIp() == null) ? 0 : getIp().hashCode());
        result = prime * result + ((getArer() == null) ? 0 : getArer().hashCode());
        result = prime * result + ((getOperator() == null) ? 0 : getOperator().hashCode());
        result = prime * result + ((getDate() == null) ? 0 : getDate().hashCode());
        result = prime * result + ((getTime() == null) ? 0 : getTime().hashCode());
        result = prime * result + ((getRegion() == null) ? 0 : getRegion().hashCode());
        return result;
    }
}
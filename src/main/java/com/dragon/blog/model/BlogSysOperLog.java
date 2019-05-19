package com.dragon.blog.model;

import java.io.Serializable;
import java.util.Date;

public class BlogSysOperLog implements Serializable {
    /**
     * 日志主键
     *
     * @mbg.generated
     */
    private Integer operId;

    /**
     * 模块标题
     *
     * @mbg.generated
     */
    private String title;

    /**
     * 业务类型（0其它 1新增 2修改 3删除）
     *
     * @mbg.generated
     */
    private Integer businessType;

    /**
     * 方法名称
     *
     * @mbg.generated
     */
    private String method;

    /**
     * 操作类别（0其它 1后台用户 2手机端用户）
     *
     * @mbg.generated
     */
    private Integer operatorType;

    /**
     * 操作人员
     *
     * @mbg.generated
     */
    private String operName;

    /**
     * 部门名称
     *
     * @mbg.generated
     */
    private String deptName;

    /**
     * 请求URL
     *
     * @mbg.generated
     */
    private String operUrl;

    /**
     * 主机地址
     *
     * @mbg.generated
     */
    private String operIp;

    /**
     * 操作地点
     *
     * @mbg.generated
     */
    private String operLocation;

    /**
     * 请求参数
     *
     * @mbg.generated
     */
    private String operParam;

    /**
     * 操作状态（0正常 1异常）
     *
     * @mbg.generated
     */
    private Integer status;

    /**
     * 错误消息
     *
     * @mbg.generated
     */
    private String errorMsg;

    /**
     * 操作时间
     *
     * @mbg.generated
     */
    private Date operTime;

    private static final long serialVersionUID = 1L;

    public Integer getOperId() {
        return operId;
    }

    public void setOperId(Integer operId) {
        this.operId = operId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getBusinessType() {
        return businessType;
    }

    public void setBusinessType(Integer businessType) {
        this.businessType = businessType;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Integer getOperatorType() {
        return operatorType;
    }

    public void setOperatorType(Integer operatorType) {
        this.operatorType = operatorType;
    }

    public String getOperName() {
        return operName;
    }

    public void setOperName(String operName) {
        this.operName = operName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getOperUrl() {
        return operUrl;
    }

    public void setOperUrl(String operUrl) {
        this.operUrl = operUrl;
    }

    public String getOperIp() {
        return operIp;
    }

    public void setOperIp(String operIp) {
        this.operIp = operIp;
    }

    public String getOperLocation() {
        return operLocation;
    }

    public void setOperLocation(String operLocation) {
        this.operLocation = operLocation;
    }

    public String getOperParam() {
        return operParam;
    }

    public void setOperParam(String operParam) {
        this.operParam = operParam;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Date getOperTime() {
        return operTime;
    }

    public void setOperTime(Date operTime) {
        this.operTime = operTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", operId=").append(operId);
        sb.append(", title=").append(title);
        sb.append(", businessType=").append(businessType);
        sb.append(", method=").append(method);
        sb.append(", operatorType=").append(operatorType);
        sb.append(", operName=").append(operName);
        sb.append(", deptName=").append(deptName);
        sb.append(", operUrl=").append(operUrl);
        sb.append(", operIp=").append(operIp);
        sb.append(", operLocation=").append(operLocation);
        sb.append(", operParam=").append(operParam);
        sb.append(", status=").append(status);
        sb.append(", errorMsg=").append(errorMsg);
        sb.append(", operTime=").append(operTime);
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
        BlogSysOperLog other = (BlogSysOperLog) that;
        return (this.getOperId() == null ? other.getOperId() == null : this.getOperId().equals(other.getOperId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getBusinessType() == null ? other.getBusinessType() == null : this.getBusinessType().equals(other.getBusinessType()))
            && (this.getMethod() == null ? other.getMethod() == null : this.getMethod().equals(other.getMethod()))
            && (this.getOperatorType() == null ? other.getOperatorType() == null : this.getOperatorType().equals(other.getOperatorType()))
            && (this.getOperName() == null ? other.getOperName() == null : this.getOperName().equals(other.getOperName()))
            && (this.getDeptName() == null ? other.getDeptName() == null : this.getDeptName().equals(other.getDeptName()))
            && (this.getOperUrl() == null ? other.getOperUrl() == null : this.getOperUrl().equals(other.getOperUrl()))
            && (this.getOperIp() == null ? other.getOperIp() == null : this.getOperIp().equals(other.getOperIp()))
            && (this.getOperLocation() == null ? other.getOperLocation() == null : this.getOperLocation().equals(other.getOperLocation()))
            && (this.getOperParam() == null ? other.getOperParam() == null : this.getOperParam().equals(other.getOperParam()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getErrorMsg() == null ? other.getErrorMsg() == null : this.getErrorMsg().equals(other.getErrorMsg()))
            && (this.getOperTime() == null ? other.getOperTime() == null : this.getOperTime().equals(other.getOperTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOperId() == null) ? 0 : getOperId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getBusinessType() == null) ? 0 : getBusinessType().hashCode());
        result = prime * result + ((getMethod() == null) ? 0 : getMethod().hashCode());
        result = prime * result + ((getOperatorType() == null) ? 0 : getOperatorType().hashCode());
        result = prime * result + ((getOperName() == null) ? 0 : getOperName().hashCode());
        result = prime * result + ((getDeptName() == null) ? 0 : getDeptName().hashCode());
        result = prime * result + ((getOperUrl() == null) ? 0 : getOperUrl().hashCode());
        result = prime * result + ((getOperIp() == null) ? 0 : getOperIp().hashCode());
        result = prime * result + ((getOperLocation() == null) ? 0 : getOperLocation().hashCode());
        result = prime * result + ((getOperParam() == null) ? 0 : getOperParam().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getErrorMsg() == null) ? 0 : getErrorMsg().hashCode());
        result = prime * result + ((getOperTime() == null) ? 0 : getOperTime().hashCode());
        return result;
    }
}
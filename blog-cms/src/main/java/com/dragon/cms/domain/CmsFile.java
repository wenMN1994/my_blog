package com.dragon.cms.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.dragon.common.annotation.Excel;
import com.dragon.common.core.domain.BaseEntity;

/**
 * 文件管理对象 cms_file
 * 
 * @author DragonWen
 * @date 2021-09-25
 */
public class CmsFile extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 文件ID */
    private Long fileId;

    /** 文件路径 */
    @Excel(name = "文件路径")
    private String fileUrl;

    /** 文件名称 */
    @Excel(name = "文件名称")
    private String fileName;

    /** 文件后缀 */
    @Excel(name = "文件后缀")
    private String suffix;

    /** 文件类型 */
    @Excel(name = "文件类型")
    private String type;

    /** 文件大小 */
    @Excel(name = "文件大小")
    private String fileSize;

    /** 是否有效（0：有效，1无效） */
    @Excel(name = "是否有效", readConverterExp = "0=：有效，1无效")
    private String isEnable;

    public void setFileId(Long fileId) 
    {
        this.fileId = fileId;
    }

    public Long getFileId() 
    {
        return fileId;
    }
    public void setFileUrl(String fileUrl) 
    {
        this.fileUrl = fileUrl;
    }

    public String getFileUrl() 
    {
        return fileUrl;
    }
    public void setFileName(String fileName) 
    {
        this.fileName = fileName;
    }

    public String getFileName() 
    {
        return fileName;
    }
    public void setSuffix(String suffix) 
    {
        this.suffix = suffix;
    }

    public String getSuffix() 
    {
        return suffix;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setFileSize(String fileSize) 
    {
        this.fileSize = fileSize;
    }

    public String getFileSize() 
    {
        return fileSize;
    }
    public void setIsEnable(String isEnable) 
    {
        this.isEnable = isEnable;
    }

    public String getIsEnable() 
    {
        return isEnable;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("fileId", getFileId())
            .append("fileUrl", getFileUrl())
            .append("fileName", getFileName())
            .append("suffix", getSuffix())
            .append("type", getType())
            .append("fileSize", getFileSize())
            .append("isEnable", getIsEnable())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}

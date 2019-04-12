package com.dragon.blog.model;

import java.io.Serializable;

public class BlogSysCodeEditor implements Serializable {
    /**
     * 代码修改ID
     *
     * @mbg.generated
     */
    private String codeEditorId;

    /**
     * 类型
     *
     * @mbg.generated
     */
    private String type;

    /**
     * 文件名
     *
     * @mbg.generated
     */
    private String filename;

    /**
     * 创建时间
     *
     * @mbg.generated
     */
    private String createTime;

    /**
     * 文件内容
     *
     * @mbg.generated
     */
    private String codeContent;

    private static final long serialVersionUID = 1L;

    public String getCodeEditorId() {
        return codeEditorId;
    }

    public void setCodeEditorId(String codeEditorId) {
        this.codeEditorId = codeEditorId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCodeContent() {
        return codeContent;
    }

    public void setCodeContent(String codeContent) {
        this.codeContent = codeContent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", codeEditorId=").append(codeEditorId);
        sb.append(", type=").append(type);
        sb.append(", filename=").append(filename);
        sb.append(", createTime=").append(createTime);
        sb.append(", codeContent=").append(codeContent);
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
        BlogSysCodeEditor other = (BlogSysCodeEditor) that;
        return (this.getCodeEditorId() == null ? other.getCodeEditorId() == null : this.getCodeEditorId().equals(other.getCodeEditorId()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getFilename() == null ? other.getFilename() == null : this.getFilename().equals(other.getFilename()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getCodeContent() == null ? other.getCodeContent() == null : this.getCodeContent().equals(other.getCodeContent()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCodeEditorId() == null) ? 0 : getCodeEditorId().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getFilename() == null) ? 0 : getFilename().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getCodeContent() == null) ? 0 : getCodeContent().hashCode());
        return result;
    }
}
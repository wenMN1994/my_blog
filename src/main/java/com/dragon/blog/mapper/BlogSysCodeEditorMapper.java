package com.dragon.blog.mapper;

import com.dragon.blog.model.BlogSysCodeEditor;
import com.dragon.blog.model.BlogSysCodeEditorExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BlogSysCodeEditorMapper {
    long countByExample(BlogSysCodeEditorExample example);

    int deleteByExample(BlogSysCodeEditorExample example);

    int deleteByPrimaryKey(String codeEditorId);

    int insert(BlogSysCodeEditor record);

    int insertSelective(BlogSysCodeEditor record);

    List<BlogSysCodeEditor> selectByExampleWithBLOBs(BlogSysCodeEditorExample example);

    List<BlogSysCodeEditor> selectByExample(BlogSysCodeEditorExample example);

    BlogSysCodeEditor selectByPrimaryKey(String codeEditorId);

    int updateByExampleSelective(@Param("record") BlogSysCodeEditor record, @Param("example") BlogSysCodeEditorExample example);

    int updateByExampleWithBLOBs(@Param("record") BlogSysCodeEditor record, @Param("example") BlogSysCodeEditorExample example);

    int updateByExample(@Param("record") BlogSysCodeEditor record, @Param("example") BlogSysCodeEditorExample example);

    int updateByPrimaryKeySelective(BlogSysCodeEditor record);

    int updateByPrimaryKeyWithBLOBs(BlogSysCodeEditor record);

    int updateByPrimaryKey(BlogSysCodeEditor record);
}
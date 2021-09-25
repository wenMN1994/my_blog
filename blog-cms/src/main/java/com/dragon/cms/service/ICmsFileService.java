package com.dragon.cms.service;

import java.util.List;
import com.dragon.cms.domain.CmsFile;

/**
 * 文件管理Service接口
 * 
 * @author DragonWen
 * @date 2021-09-25
 */
public interface ICmsFileService 
{
    /**
     * 查询文件管理
     * 
     * @param fileId 文件管理主键
     * @return 文件管理
     */
    public CmsFile selectCmsFileByFileId(Long fileId);

    /**
     * 查询文件管理列表
     * 
     * @param cmsFile 文件管理
     * @return 文件管理集合
     */
    public List<CmsFile> selectCmsFileList(CmsFile cmsFile);

    /**
     * 新增文件管理
     * 
     * @param cmsFile 文件管理
     * @return 结果
     */
    public int insertCmsFile(CmsFile cmsFile);

    /**
     * 修改文件管理
     * 
     * @param cmsFile 文件管理
     * @return 结果
     */
    public int updateCmsFile(CmsFile cmsFile);

    /**
     * 批量删除文件管理
     * 
     * @param fileIds 需要删除的文件管理主键集合
     * @return 结果
     */
    public int deleteCmsFileByFileIds(String fileIds);

    /**
     * 删除文件管理信息
     * 
     * @param fileId 文件管理主键
     * @return 结果
     */
    public int deleteCmsFileByFileId(Long fileId);
}

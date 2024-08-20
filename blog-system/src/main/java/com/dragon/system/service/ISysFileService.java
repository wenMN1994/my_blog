package com.dragon.system.service;

import java.util.List;
import com.dragon.system.domain.SysFile;

/**
 * 文件管理Service接口
 * 
 * @author DragonWen
 * @date 2021-09-25
 */
public interface ISysFileService {
    /**
     * 查询文件管理
     * 
     * @param fileId 文件管理主键
     * @return 文件管理
     */
    public SysFile selectSysFileByFileId(Long fileId);

    /**
     * 查询文件管理列表
     * 
     * @param cmsFile 文件管理
     * @return 文件管理集合
     */
    public List<SysFile> selectSysFileList(SysFile cmsFile);

    /**
     * 新增文件管理
     * 
     * @param cmsFile 文件管理
     * @return 结果
     */
    public int insertSysFile(SysFile cmsFile);

    /**
     * 修改文件管理
     * 
     * @param cmsFile 文件管理
     * @return 结果
     */
    public int updateSysFile(SysFile cmsFile);

    /**
     * 批量删除文件管理
     * 
     *
     * @param ids 需要删除的文件管理主键集合
     * @param updateBy 修改人
     * @return 结果
     */
    public int deleteSysFileByFileIds(String ids, String updateBy);

    /**
     * 删除文件管理信息
     * 
     * @param fileId 文件管理主键
     * @return 结果
     */
    public int deleteSysFileByFileId(Long fileId);

    /**
     * 根据文件路径查询文件信息
     * @param fileUrl
     * @return
     */
    public SysFile selectSysFileByFileUrl(String fileUrl);
}

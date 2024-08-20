package com.dragon.system.service.impl;

import java.util.List;
import com.dragon.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dragon.system.mapper.SysFileMapper;
import com.dragon.system.domain.SysFile;
import com.dragon.system.service.ISysFileService;
import com.dragon.common.core.text.Convert;

/**
 * 文件管理Service业务层处理
 * 
 * @author DragonWen
 * @date 2021-09-25
 */
@Service
public class SysFileServiceImpl implements ISysFileService {
    @Autowired
    private SysFileMapper cmsFileMapper;

    /**
     * 查询文件管理
     * 
     * @param fileId 文件管理主键
     * @return 文件管理
     */
    @Override
    public SysFile selectSysFileByFileId(Long fileId) {
        return cmsFileMapper.selectSysFileByFileId(fileId);
    }

    /**
     * 查询文件管理列表
     * 
     * @param cmsFile 文件管理
     * @return 文件管理
     */
    @Override
    public List<SysFile> selectSysFileList(SysFile cmsFile) {
        return cmsFileMapper.selectSysFileList(cmsFile);
    }

    /**
     * 新增文件管理
     * 
     * @param cmsFile 文件管理
     * @return 结果
     */
    @Override
    public int insertSysFile(SysFile cmsFile) {
        cmsFile.setCreateTime(DateUtils.getNowDate());
        return cmsFileMapper.insertSysFile(cmsFile);
    }

    /**
     * 修改文件管理
     * 
     * @param cmsFile 文件管理
     * @return 结果
     */
    @Override
    public int updateSysFile(SysFile cmsFile) {
        cmsFile.setUpdateTime(DateUtils.getNowDate());
        return cmsFileMapper.updateSysFile(cmsFile);
    }

    /**
     * 批量删除文件管理
     * 
     *
     * @param ids 需要删除的文件管理主键
     * @param updateBy 修改人
     * @return 结果
     */
    @Override
    public int deleteSysFileByFileIds(String ids, String updateBy) {
        return cmsFileMapper.deleteSysFileByFileIds(Convert.toStrArray(ids), updateBy);
    }

    /**
     * 删除文件
     * 
     * @param fileId 文件管理主键
     * @return 结果
     */
    @Override
    public int deleteSysFileByFileId(Long fileId) {
        return cmsFileMapper.deleteSysFileByFileId(fileId);
    }

    /**
     * 根据文件路径查询文件信息
     * @param fileUrl
     * @return
     */
    @Override
    public SysFile selectSysFileByFileUrl(String fileUrl) {
        return cmsFileMapper.selectSysFileByFileUrl(fileUrl);
    }
}

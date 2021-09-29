package com.dragon.cms.service.impl;

import java.util.List;
import com.dragon.common.utils.DateUtils;
import com.dragon.common.utils.oss.OSSClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dragon.cms.mapper.CmsFileMapper;
import com.dragon.cms.domain.CmsFile;
import com.dragon.cms.service.ICmsFileService;
import com.dragon.common.core.text.Convert;

/**
 * 文件管理Service业务层处理
 * 
 * @author DragonWen
 * @date 2021-09-25
 */
@Service
public class CmsFileServiceImpl implements ICmsFileService 
{
    @Autowired
    private CmsFileMapper cmsFileMapper;

    /**
     * 查询文件管理
     * 
     * @param fileId 文件管理主键
     * @return 文件管理
     */
    @Override
    public CmsFile selectCmsFileByFileId(Long fileId)
    {
        return cmsFileMapper.selectCmsFileByFileId(fileId);
    }

    /**
     * 查询文件管理列表
     * 
     * @param cmsFile 文件管理
     * @return 文件管理
     */
    @Override
    public List<CmsFile> selectCmsFileList(CmsFile cmsFile)
    {
        return cmsFileMapper.selectCmsFileList(cmsFile);
    }

    /**
     * 新增文件管理
     * 
     * @param cmsFile 文件管理
     * @return 结果
     */
    @Override
    public int insertCmsFile(CmsFile cmsFile)
    {
        cmsFile.setCreateTime(DateUtils.getNowDate());
        return cmsFileMapper.insertCmsFile(cmsFile);
    }

    /**
     * 修改文件管理
     * 
     * @param cmsFile 文件管理
     * @return 结果
     */
    @Override
    public int updateCmsFile(CmsFile cmsFile)
    {
        cmsFile.setUpdateTime(DateUtils.getNowDate());
        return cmsFileMapper.updateCmsFile(cmsFile);
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
    public int deleteCmsFileByFileIds(String ids, String updateBy)
    {
        return cmsFileMapper.deleteCmsFileByFileIds(Convert.toStrArray(ids), updateBy);
    }

    /**
     * 删除文件
     * 
     * @param fileId 文件管理主键
     * @return 结果
     */
    @Override
    public int deleteCmsFileByFileId(Long fileId)
    {
        return cmsFileMapper.deleteCmsFileByFileId(fileId);
    }
}

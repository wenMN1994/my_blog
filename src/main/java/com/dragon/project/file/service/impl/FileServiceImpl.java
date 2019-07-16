package com.dragon.project.file.service.impl;

import com.dragon.project.file.domain.FileList;
import com.dragon.project.file.domain.FilePath;
import com.dragon.project.file.mapper.FileListMapper;
import com.dragon.project.file.mapper.FilePathMapper;
import com.dragon.project.file.service.FileService;
import com.dragon.project.system.user.domain.User;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author：Dragon Wen
 * @email：18475536452@163.com
 * @date：Created in 2019/7/10 14:30
 * @description： 文件管理服务接口实现
 * @modified By：
 * @version: 1.0.0
 */
@Configurable
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    private FileListMapper fileListMapper;

    @Autowired
    private FilePathMapper filePathMapper;

    @Value("${file.root.path}")
    private String rootPath;

    @Override
    public FilePath selectByPathName(String pathName) {
        return filePathMapper.selectFilePathByPathName(pathName);
    }

    @Override
    public int save(FilePath filePathNew) {
        return filePathMapper.insertFilePath(filePathNew);
    }

    @Override
    public List<FilePath> selectPathByParent(Long parentId) {
        return filePathMapper.selectByParentIdAndPathIstrash(parentId, 0L);
    }

    @Override
    public List<FileList> selectFileByPath(FilePath filePath) {
        return fileListMapper.selectByFilePathAndFileIstrash(filePath.getPathId(), 0L);
    }

    @Override
    public String onlyName(String pathName, FilePath filePath, String shuffix, int num, boolean isFile) {
        Object file = null;
        if(isFile){
            file = fileListMapper.selectByFileNameAndFilePath(pathName, filePath.getPathId());
        } else {
            file = filePathMapper.selectByPathNameAndParentId(pathName, filePath.getPathId());
        }
        if(file != null){
            int numNew = num -1;
            if(shuffix == null){
                pathName = pathName.replace("("+numNew+")", "")+"("+num+")";
            }else{
                pathName = pathName.replace("."+shuffix,"").replace("("+numNew+")", "")+"("+num+")"+"."+shuffix;
            }
            num += 1;
            return onlyName(pathName,filePath,shuffix,num,isFile);
        }
        return pathName;
    }

    @Override
    public FilePath selectFilePathById(Long pathId) {
        return filePathMapper.selectFilePathById(pathId);
    }

    @Override
    public Object saveFile(MultipartFile file, User user, FilePath nowPath, boolean isFile) throws IOException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM");
        File root = new File(this.rootPath,simpleDateFormat.format(new Date()));

        File savePath = new File(root,user.getUserName());

        if (!savePath.exists()) {
            savePath.mkdirs();
        }

        String shuffix = FilenameUtils.getExtension(file.getOriginalFilename());
        String newFileName = UUID.randomUUID().toString().toLowerCase()+"."+shuffix;
        File targetFile = new File(savePath,newFileName);
        file.transferTo(targetFile);


        if(isFile){
            FileList filelist = new FileList();
            String filename = file.getOriginalFilename();
            filename = onlyName(filename,nowPath,shuffix,1,true);
            filelist.setFileName(filename);
            filelist.setFilePath(targetFile.getAbsolutePath().replace("\\", "/").replace(this.rootPath, ""));
            filelist.setFileShuffix(shuffix);
            filelist.setFileSize(file.getSize());
            filelist.setUploadTime(new Date());
            filelist.setPathId(nowPath.getPathId());
            filelist.setContentType(file.getContentType());
            filelist.setFileUserId(user.getUserId());
            fileListMapper.insertFileList(filelist);
            return filelist;
        }else{
            return null;
        }
    }

    @Override
    public void SelectAllParent(FilePath filePath, List<FilePath> allParentPaths) {
        if (filePath.getParentId() != 1L) {
            FilePath filePathItem = filePathMapper.selectFilePathById(filePath.getParentId());
            allParentPaths.add(filePathItem);
            SelectAllParent(filePathItem,allParentPaths);
        }
    }

    @Override
    public FilePath selectFilePathByPathName(String pathName) {
        return filePathMapper.selectFilePathByPathName(pathName);
    }

    @Override
    public FileList selectFileListById(Long fileId) {
        return fileListMapper.selectFileListById(fileId);
    }

    @Override
    public File getFile(String filePath) {
        return new File(this.rootPath,filePath);
    }

    @Override
    public List<FileList> selectDocumentByUserId(Long userId, Long isTrash) {
        return fileListMapper.selectDocumentByUserIdAndIsTrash(userId, isTrash);
    }

    @Override
    public List<FileList> selectByUserIdAndContentTypeLikeAndFileIsTrash(Long userId, String contentType, Long isTrash) {
        return fileListMapper.selectByUserIdAndContentTypeLikeAndFileIsTrash(userId, contentType, isTrash);
    }

    @Override
    public List<FileList> selectFileListByUserIdAndIsTrash(Long userId,Long isTrash) {
        return fileListMapper.selectFileListByUserIdAndIsTrash(userId,isTrash);
    }

    @Override
    public List<FileList> selectFileListByIsShareAndIsTrash(Long isShare,Long isTrash) {
        return fileListMapper.selectFileListByIsShareAndIsTrash(isShare, isTrash);
    }

    @Override
    public List<FilePath> selectPathListByUserIdAndIsTrash(Long userId, Long isTrash) {
        return filePathMapper.selectPathListByUserIdAndIsTrash(userId, isTrash);
    }

    @Override
    public void trashFile(List<Long> checkFileIds, Long setIsTrashHowMany, Long userId) {
        for (Long fileId : checkFileIds) {
            FileList fileList = fileListMapper.selectFileListById(fileId);
            fileList.setFileIstrash(setIsTrashHowMany);
            if(userId != null){
                fileList.setPathId(null);
            }

            fileListMapper.updateFileList(fileList);
        }
    }

    @Override
    public void trashPath(List<Long> checkPathIds, Long setIsTrashHowMany, boolean isFirst) {
        for (Long pathId : checkPathIds) {
            FilePath filePath = filePathMapper.selectFilePathById(pathId);

            //首先将此文件夹下的文件放入回收战
            List<FileList> files = fileListMapper.selectFileListByPathId(pathId);
            if(!files.isEmpty()){
                List<Long> fileIds= new ArrayList<>();
                for (FileList filelist : files) {
                    fileIds.add(filelist.getFileId());
                }
                trashFile(fileIds,2L,null);
            }
            //然后将此文件夹下的文件夹放入回收战
            List<FilePath> filePaths = filePathMapper.selectFilePathByParentId(pathId);
            if(!filePaths.isEmpty()){
                List<Long> pathIdsNext = new ArrayList<>();
                for (FilePath filePathTemp : filePaths) {
                    pathIdsNext.add(filePathTemp.getPathId());
                }
                trashPath(pathIdsNext,2L,false);
            }
            if (isFirst) {
                filePath.setParentId(0L);
            }
            filePath.setPathIstrash(setIsTrashHowMany);
            filePathMapper.updateFilePath(filePath);
        }
    }
}

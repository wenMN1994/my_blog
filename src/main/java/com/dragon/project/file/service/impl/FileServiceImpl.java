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

import java.io.*;
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
    public FileList saveFile(MultipartFile file, User user, FilePath nowPath, boolean isFile) throws IOException {
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
    public Long saveFileReturnSrc(MultipartFile file, User user, FilePath nowPath, boolean isFile) throws IOException {
        FileList fl = saveFile(file,user,nowPath,isFile);
        FileList fileList = fileListMapper.selectFileList(fl);
        return fileList.getFileId();
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
                trashFile(fileIds,1L,null);
            }
            //然后将此文件夹下的文件夹放入回收战
            List<FilePath> filePaths = filePathMapper.selectFilePathByParentId(pathId);
            if(!filePaths.isEmpty()){
                List<Long> pathIdsNext = new ArrayList<>();
                for (FilePath filePathTemp : filePaths) {
                    pathIdsNext.add(filePathTemp.getPathId());
                }
                trashPath(pathIdsNext,1L,false);
            }
            filePath.setPathIstrash(setIsTrashHowMany);
            filePathMapper.updateFilePath(filePath);
        }
    }

    @Override
    public void rename(String name, Long renamefp, Long nowPathId, boolean isFile) {
        if(isFile){
            //文件名修改
            FileList fileList = fileListMapper.selectFileListById(renamefp);
            FilePath filePath = filePathMapper.selectFilePathById(fileList.getPathId());
            String newName = onlyName(name, filePath, fileList.getFileShuffix(), 1, isFile);
            fileList.setFileName(newName);
            fileListMapper.updateFileList(fileList);
        }else{
            //文件夹名修改
            FilePath fp = filePathMapper.selectFilePathById(renamefp);
            FilePath filePath = filePathMapper.selectFilePathById(nowPathId);
            String newName = onlyName(name, filePath, null, 1, false);
            fp.setPathName(newName);
            filePathMapper.updateFilePath(fp);
        }
    }

    @Override
    public List<FilePath> mcpathload(Long mctoid, List<Long> mcpathids) {
        List<FilePath> showsonpath = new ArrayList<>();
        List<FilePath> sonpaths = filePathMapper.selectByParentIdAndPathIstrash(mctoid, 0L);

        for (FilePath sonpath : sonpaths) {
            boolean nosame = true;
            for (Long mcpathid : mcpathids) {
                if(sonpath.getPathId().equals(mcpathid)){
                    nosame = false;
                    break;
                }
            }
            if(nosame){
                showsonpath.add(sonpath);
            }
        }
        return showsonpath;
    }

    @Override
    public void deleteFileByFileId(List<Long> fileIds) {
        for (Long fileId : fileIds) {
            FileList filelist = fileListMapper.selectFileListById(fileId);

            File file = new File(this.rootPath,filelist.getFilePath());
            if(file.exists() && file.isFile()){
                fileListMapper.deleteFileListById(fileId);
                file.delete();
            }
        }
    }

    @Override
    public void deletePathByPathId(List<Long> pathIds) {
        for (Long pathId : pathIds) {
            //首先删除此文件夹下的文件
            List<FileList> files = fileListMapper.selectFileListByPathId(pathId);
            if(!files.isEmpty()){
                List<Long> fileIdList= new ArrayList<>();
                for (FileList fileList : files) {
                    fileIdList.add(fileList.getFileId());
                }
                deleteFileByFileId(fileIdList);
            }

            //然后删除此文件夹下的文件夹
            List<FilePath> filePathList = filePathMapper.selectFilePathByParentId(pathId);
            if(!filePathList.isEmpty()){
                List<Long> pathIdList = new ArrayList<>();
                for (FilePath filePath : filePathList) {
                    pathIdList.add(filePath.getPathId());
                }
                deletePathByPathId(pathIdList);
            }

            filePathMapper.deleteFilePathByPathId(pathId);
        }
    }

    @Override
    public boolean deleteFileByFileId(Long fileId) {
        FileList fileList = fileListMapper.selectFileListById(fileId);
        File file = new File(this.rootPath,fileList.getFilePath());
        int isDelete = fileListMapper.deleteFileListById(fileId);
        boolean b = file.delete();
        if(isDelete == 1 && b){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void moveAndCopy(List<Long> mcfileids, List<Long> mcpathids, Long toPathId, boolean fromWhere, User user) {
        FilePath topath = filePathMapper.selectFilePathById(toPathId);
        if(fromWhere){
            System.out.println("这里是移动！！~~");
            if(!mcfileids.isEmpty()){
                System.out.println("fileid is not null");
                for (Long mcfileid : mcfileids) {
                    FileList filelist = fileListMapper.selectFileListById(mcfileid);
                    String filename = onlyName(filelist.getFileName(),topath,filelist.getFileShuffix(),1,true);
                    filelist.setPathId(topath.getPathId());
                    filelist.setFileName(filename);
                    fileListMapper.updateFileList(filelist);
                }
            }
            if(!mcpathids.isEmpty()){
                System.out.println("pathid is not null");
                for (Long mcpathid : mcpathids) {
                    FilePath filepath = filePathMapper.selectFilePathById(mcpathid);
                    String name = onlyName(filepath.getPathName(), topath, null, 1, false);
                    filepath.setParentId(toPathId);
                    filepath.setPathName(name);
                    filePathMapper.updateFilePath(filepath);
                }
            }
        }else{
            System.out.println("这里是复制！！~~");
            if(!mcfileids.isEmpty()){
                System.out.println("fileid is not null");
                for (Long mcfileid : mcfileids) {
                    FileList filelist = fileListMapper.selectFileListById(mcfileid);
                    copyfile(filelist,topath,true, user);
                }
            }
            if(!mcpathids.isEmpty()){
                System.out.println("pathid is not null");
                for (Long mcpathid : mcpathids) {
                    copypath(mcpathid, toPathId, true, user);
                }
            }
        }
    }

    public void copypath(Long mcpathid,Long toPathId,boolean isfirst,User user){
        FilePath filepath = filePathMapper.selectFilePathById(mcpathid);

        //第一个文件夹的复制
        FilePath copypath = new FilePath();
        copypath.setParentId(toPathId);
        String copypathname = filepath.getPathName();
        if(isfirst){
            copypathname = "拷贝 "+filepath.getPathName().replace("拷贝 ", "");
        }
        copypath.setPathName(copypathname);
        copypath.setPathUserId(user.getUserId());
        copypath = filePathMapper.updateFilePath(copypath);

        //这一个文件夹下的文件的复制
        List<FileList> filelists = fileListMapper.selectByFilePathAndFileIstrash(filepath.getPathId(), 0L);
        for (FileList fileList : filelists) {
            copyfile(fileList,copypath,false, user);
        }

        List<FilePath> filepathsons = filePathMapper.selectByParentIdAndPathIstrash(filepath.getPathId(), 0L);

        if(!filepathsons.isEmpty()){
            for (FilePath filepathson : filepathsons) {
                copypath(filepathson.getPathId(),copypath.getPathId(),false,user);
            }
        }

    }

    /**
     * 文件复制
     * @param filelist
     */
    public void copyfile(FileList filelist,FilePath topath,boolean isfilein, User user){
        File s = getFile(filelist.getFilePath());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM");
        File root = new File(this.rootPath,simpleDateFormat.format(new Date()));
        File savepath = new File(root,user.getUserName());

        if (!savepath.exists()) {
            savepath.mkdirs();
        }

        String shuffix = filelist.getFileShuffix();
//        log.info("shuffix:{}",shuffix);
        String newFileName = UUID.randomUUID().toString().toLowerCase()+"."+shuffix;
        File t = new File(savepath,newFileName);

        copyfileio(s,t);

        FileList filelist1 = new FileList();
        String filename="";
        if(isfilein){
            filename = "拷贝 "+filelist.getFileName().replace("拷贝 ", "");
        }else{
            filename = filelist.getFileName();
        }
        filename = onlyName(filename,topath,shuffix,1,true);
        filelist1.setFileName(filename);
        filelist1.setFilePath(t.getAbsolutePath().replace("\\", "/").replace(this.rootPath, ""));
        filelist1.setFileShuffix(shuffix);
        filelist1.setFileSize(filelist.getFileSize());
        filelist1.setUploadTime(new Date());
        filelist1.setPathId(topath.getPathId());
        filelist1.setContentType(filelist.getContentType());
        filelist1.setFileUserId(user.getUserId());
        fileListMapper.updateFileList(filelist1);

    }
    /**
     * 本地文件复制
     * @param s
     * @param t
     */
    public void copyfileio(File s,File t){
        InputStream fis = null;
        OutputStream fos = null;

        try {
            fis = new BufferedInputStream(new FileInputStream(s));
            fos = new BufferedOutputStream(new FileOutputStream(t));
            byte[] buf = new byte[2048];
            int i ;
            while((i = fis.read(buf)) != -1){
                fos.write(buf, 0, i);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                fis.close();
                fos.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}

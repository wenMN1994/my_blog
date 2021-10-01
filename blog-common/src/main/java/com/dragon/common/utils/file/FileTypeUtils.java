package com.dragon.common.utils.file;

import java.io.File;
import org.apache.commons.lang3.StringUtils;

/**
 * 文件类型工具类
 *
 * @author dragon
 */
public class FileTypeUtils
{
    /**
     * 获取文件类型
     * <p>
     * 例如: dragon.txt, 返回: txt
     * 
     * @param file 文件名
     * @return 后缀（不含".")
     */
    public static String getFileType(File file)
    {
        if (null == file)
        {
            return StringUtils.EMPTY;
        }
        return getFileType(file.getName());
    }

    /**
     * 获取文件类型
     * <p>
     * 例如: dragon.txt, 返回: txt
     *
     * @param fileName 文件名
     * @return 后缀（不含".")
     */
    public static String getFileType(String fileName)
    {
        int separatorIndex = fileName.lastIndexOf(".");
        if (separatorIndex < 0)
        {
            return "";
        }
        return fileName.substring(separatorIndex + 1).toLowerCase();
    }

    /**
     * 获取文件类型
     * 
     * @param photoByte 文件字节码
     * @return 后缀（不含".")
     */
    public static String getFileExtendName(byte[] photoByte)
    {
        String strFileExtendName = "JPG";
        if ((photoByte[0] == 71) && (photoByte[1] == 73) && (photoByte[2] == 70) && (photoByte[3] == 56)
                && ((photoByte[4] == 55) || (photoByte[4] == 57)) && (photoByte[5] == 97))
        {
            strFileExtendName = "GIF";
        }
        else if ((photoByte[6] == 74) && (photoByte[7] == 70) && (photoByte[8] == 73) && (photoByte[9] == 70))
        {
            strFileExtendName = "JPG";
        }
        else if ((photoByte[0] == 66) && (photoByte[1] == 77))
        {
            strFileExtendName = "BMP";
        }
        else if ((photoByte[1] == 80) && (photoByte[2] == 78) && (photoByte[3] == 71))
        {
            strFileExtendName = "PNG";
        }
        return strFileExtendName;
    }

    /**
     * 自定义文件类型
     *
     * @param filenameExtension 文件后缀
     * @return 后缀
     */
    public static String getContentType(String filenameExtension) {
        if ("jpeg".equalsIgnoreCase(filenameExtension) ||
                "jpg".equalsIgnoreCase(filenameExtension) ||
                "bmp".equalsIgnoreCase(filenameExtension) ||
                "gif".equalsIgnoreCase(filenameExtension) ||
                "png".equalsIgnoreCase(filenameExtension)) {
            return "image";
        }
        if ("txt".equalsIgnoreCase(filenameExtension) ||
                "pdf".equalsIgnoreCase(filenameExtension) ||
                "xml".equalsIgnoreCase(filenameExtension) ||
                "html".equalsIgnoreCase(filenameExtension) ||
                "pptx".equalsIgnoreCase(filenameExtension) ||
                "ppt".equalsIgnoreCase(filenameExtension) ||
                "docx".equalsIgnoreCase(filenameExtension) ||
                "doc".equalsIgnoreCase(filenameExtension) ||
                "xlsx".equalsIgnoreCase(filenameExtension) ||
                "xls".equalsIgnoreCase(filenameExtension) ||
                "md".equalsIgnoreCase(filenameExtension) ||
                "sql".equalsIgnoreCase(filenameExtension)) {
            return "document";
        }
        if ("wav".equalsIgnoreCase(filenameExtension) ||
                "mp3".equalsIgnoreCase(filenameExtension) ||
                "wma".equalsIgnoreCase(filenameExtension) ||
                "vqf".equalsIgnoreCase(filenameExtension)) {
            return "audio";
        }
        if ("wmv".equalsIgnoreCase(filenameExtension) ||
                "mp4".equalsIgnoreCase(filenameExtension) ||
                "mov".equalsIgnoreCase(filenameExtension) ||
                "avi".equalsIgnoreCase(filenameExtension)) {
            return "video";
        }
        if ("zip".equalsIgnoreCase(filenameExtension) ||
                "7z".equalsIgnoreCase(filenameExtension) ||
                "rar".equalsIgnoreCase(filenameExtension)) {
            return "package";
        }
        return "other";
    }
}
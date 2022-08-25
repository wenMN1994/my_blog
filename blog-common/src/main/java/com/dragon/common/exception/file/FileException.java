package com.dragon.common.exception.file;

import com.dragon.common.exception.base.BaseException;

/**
 * 文件信息异常类
 * 
 * @author dragon
 */
public class FileException extends BaseException {
    private static final long serialVersionUID = 1L;

    public FileException(String code, Object[] args) {
        super("file", code, args, null);
    }

}

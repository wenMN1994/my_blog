package com.dragon.common.constant;

import com.dragon.base.BaseResult;
import com.dragon.common.CustomResultConstant;

/**
 * @author：Dragon Wen
 * @email：18475536452@163.com
 * @date：Created in 2019/4/14 16:40
 * @description： 常量枚举类
 * @modified By：
 * @version: $version$
 */
public class CustomResult extends BaseResult {

    public CustomResult(CustomResultConstant customResultConstant, Object data) {
        super(customResultConstant.getCode(), customResultConstant.getMessage(), data);
    }
}

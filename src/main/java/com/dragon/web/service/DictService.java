package com.dragon.web.service;

import com.dragon.blog.model.BlogSysDictData;
import com.dragon.blog.model.BlogSysDictDataExample;
import com.dragon.blog.service.BlogSysDictDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author：Dragon Wen
 * @email：18475536452@163.com
 * @date：Created in 2019/6/14 10:49
 * @description：thymeleaf 实现字典读取
 * @modified By：
 * @version: 1.0.0
 */
@Service("dict")
public class DictService
{
    @Autowired
    private BlogSysDictDataService blogSysDictDataService;

    /**
     * 根据字典类型查询字典数据信息
     *
     * @param dictType 字典类型
     * @return 参数键值
     */
    public List<BlogSysDictData> getType(String dictType)
    {
        BlogSysDictDataExample blogSysDictDataExample = new BlogSysDictDataExample();
        blogSysDictDataExample.createCriteria().andDictTypeEqualTo(dictType);
        return blogSysDictDataService.selectByExample(blogSysDictDataExample);
    }

    /**
     * 根据字典类型和字典键值查询字典数据信息
     *
     * @param dictType 字典类型
     * @param dictValue 字典键值
     * @return 字典标签
     */
    public String getLabel(String dictType, String dictValue)
    {
        BlogSysDictDataExample blogSysDictDataExample = new BlogSysDictDataExample();
        blogSysDictDataExample.createCriteria().andDictTypeEqualTo(dictType);
        blogSysDictDataExample.createCriteria().andDictValueEqualTo(dictValue);
        return String.valueOf(blogSysDictDataService.selectByExample(blogSysDictDataExample));
    }
}

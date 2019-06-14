package com.dragon.blog.controller.system.dict;

import com.dragon.base.BaseController;
import com.dragon.blog.model.BlogSysDictData;
import com.dragon.blog.model.BlogSysDictDataExample;
import com.dragon.blog.service.BlogSysDictDataService;
import com.dragon.utils.page.TableDataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author：Dragon Wen
 * @email：18475536452@163.com
 * @date：Created in 2019/6/14 11:31
 * @description：数据字典信息
 * @modified By：
 * @version: 1.0.0
 */
@Controller
@RequestMapping("/system/dict/data")
public class DictDataController extends BaseController {
    private String prefix = "system/dict/data";

    @Autowired
    private BlogSysDictDataService blogSysDictDataService;

    @GetMapping()
    public String dictData()
    {
        return prefix + "/data";
    }

    @GetMapping("/list")
    @ResponseBody
    public TableDataInfo list(BlogSysDictData blogSysDictData)
    {
        startPage();
        BlogSysDictDataExample blogSysDictDataExample = new BlogSysDictDataExample();
        blogSysDictDataExample.createCriteria().andDictTypeEqualTo(blogSysDictData.getDictType());
        List<BlogSysDictData> list = blogSysDictDataService.selectByExample(blogSysDictDataExample);
        return getDataTable(list);
    }
}

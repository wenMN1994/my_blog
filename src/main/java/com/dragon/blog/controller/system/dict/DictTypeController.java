package com.dragon.blog.controller.system.dict;

import com.dragon.base.BaseController;
import com.dragon.blog.model.BlogSysDictType;
import com.dragon.blog.model.BlogSysDictTypeExample;
import com.dragon.blog.service.BlogSysDictTypeService;
import com.dragon.utils.page.TableDataInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/system/dict")
public class DictTypeController extends BaseController {
    private String prefix = "system/dict/type";

    @Autowired
    private BlogSysDictTypeService blogSysDictTypeService;

    @GetMapping()
    public String dictType()
    {
        return prefix + "/type";
    }

    @GetMapping("/list")
    @ResponseBody
    public TableDataInfo list()
    {
        startPage();
        BlogSysDictTypeExample blogSysDictTypeExample = new BlogSysDictTypeExample();
        List<BlogSysDictType> list = blogSysDictTypeService.selectByExample(blogSysDictTypeExample);
        return getDataTable(list);
    }

    /**
     * 查询字典详细
     */
    @GetMapping("/detail/{dictId}")
    public String detail(@PathVariable("dictId") int dictId, ModelMap mmap) {
        BlogSysDictTypeExample blogSysDictTypeExample = new BlogSysDictTypeExample();
        mmap.put("dict", blogSysDictTypeService.selectByPrimaryKey(dictId));
        mmap.put("dictList", blogSysDictTypeService.selectByExample(blogSysDictTypeExample));
        return "system/dict/data/data";
    }
}

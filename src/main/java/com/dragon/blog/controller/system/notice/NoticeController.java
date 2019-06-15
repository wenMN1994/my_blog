package com.dragon.blog.controller.system.notice;

import com.dragon.base.BaseController;
import com.dragon.blog.model.BlogSysNotice;
import com.dragon.blog.model.BlogSysNoticeExample;
import com.dragon.blog.service.BlogSysNoticeService;
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
 * @date：Created in 2019/6/14 15:05
 * @description：公告 信息操作处理
 * @modified By：
 * @version: 1.0.0
 */
@Controller
@RequestMapping("/system/notice")
public class NoticeController extends BaseController {
    private String prefix = "system/notice";

    @Autowired
    private BlogSysNoticeService blogSysNoticeService;

    @GetMapping()
    public String notice() {
        return prefix + "/notice";
    }

    @GetMapping("/list")
    @ResponseBody
    public TableDataInfo list() {
        startPage();
        BlogSysNoticeExample blogSysNoticeExample = new BlogSysNoticeExample();
        List<BlogSysNotice> list = blogSysNoticeService.selectByExample(blogSysNoticeExample);
        return getDataTable(list);
    }
}

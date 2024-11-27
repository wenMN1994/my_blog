package com.dragon.common.utils.markdown;

import com.dragon.common.utils.markdown.renderer.ImageNodeRenderer;
import com.dragon.common.utils.markdown.renderer.LinkNodeRenderer;
import org.commonmark.Extension;
import org.commonmark.ext.gfm.tables.TablesExtension;
import org.commonmark.ext.heading.anchor.HeadingAnchorExtension;
import org.commonmark.ext.image.attributes.ImageAttributesExtension;
import org.commonmark.ext.task.list.items.TaskListItemsExtension;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

import java.util.Arrays;
import java.util.List;

/**
 * @author: DragonWen
 * @date: 2024/7/14
 * @Version: 1.0
 * @description: Markdown 转换器
 */
public class MarkdownHelper {

    /**
     * Markdown 解析器
     */
    private final static Parser PARSER;
    /**
     * HTML 渲染器
     */
    private final static HtmlRenderer HTML_RENDERER;

    /**
     * 初始化
     */
    static {
        // Markdown 拓展
        List<Extension> extensions = Arrays.asList(
                // 表格拓展
                TablesExtension.create(),
                // 标题锚定项
                HeadingAnchorExtension.create(),
                // 图片宽高
                ImageAttributesExtension.create(),
                // 任务列表
                TaskListItemsExtension.create()
        );

        PARSER = Parser.builder().extensions(extensions).build();
        HTML_RENDERER = HtmlRenderer.builder()
                .extensions(extensions)
                // 自定义图片解析
                .nodeRendererFactory(context -> new ImageNodeRenderer(context))
                // 自定义超链接解析
                .nodeRendererFactory(context -> new LinkNodeRenderer(context))
                .build();
    }


    /**
     * 将 Markdown 转换成 HTML
     * @param markdown
     * @return
     */
    public static String convertMarkdown2Html(String markdown) {
        Node document = PARSER.parse(markdown);
        return HTML_RENDERER.render(document);
    }

    public static void main(String[] args) {
        String markdown = "";
        System.out.println(MarkdownHelper.convertMarkdown2Html(markdown));
    }
}

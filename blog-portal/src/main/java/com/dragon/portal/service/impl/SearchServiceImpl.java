package com.dragon.portal.service.impl;

import com.dragon.common.index.ArticleIndex;
import com.dragon.common.utils.DateUtils;
import com.dragon.common.utils.lucene.LuceneHelper;
import com.dragon.portal.domain.Article;
import com.dragon.portal.domain.SearchArticleVo;
import com.dragon.portal.service.ISearchService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.cn.smart.SmartChineseAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.highlight.Highlighter;
import org.apache.lucene.search.highlight.QueryScorer;
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: DragonWen
 * @date: 2024/7/30
 * @Version: 1.0
 * @description:查询服务接口实现
 */
@Service
@Slf4j
public class SearchServiceImpl implements ISearchService {

    @Autowired
    private LuceneHelper luceneHelper;

    /**
     * 文章搜索
     * @param searchArticleVo
     * @return
     */
    @Override
    public Map<String, Object> searchArticlePageList(SearchArticleVo searchArticleVo) {
        Map<String, Object> result = new HashMap<>(16);
        int current = Math.toIntExact(searchArticleVo.getCurrent());
        int size = Math.toIntExact(searchArticleVo.getSize());

        // 查询关键词
        String word = searchArticleVo.getWord();

        // 想要搜索的文档字段（这里指定对文章标题、摘要进行检索，任何一个字段包含该关键词，都会被搜索到）
        String[] columns = {ArticleIndex.COLUMN_TITLE, ArticleIndex.COLUMN_SUMMARY};
        // 查询总记录数
        long total = luceneHelper.searchTotal(ArticleIndex.NAME, word, columns);

        // 执行搜索（分页查询）
        List<Document> documents = luceneHelper.search(ArticleIndex.NAME, word, columns, current, size);

        result.put("total", total);
        result.put("current", current);
        result.put("size", size);

        // 若未查询到相关文档，只接 return
        if (CollectionUtils.isEmpty(documents)) {
            result.put("data", null);
            return result;
        }

        // ======================== 开始关键词高亮处理 ========================
        // 中文分析器
        Analyzer analyzer = new SmartChineseAnalyzer();
        QueryParser parser = new QueryParser(ArticleIndex.COLUMN_TITLE, analyzer);
        Query query = null;
        try {
            query = parser.parse(word);
        } catch (ParseException e) {
            log.error("解析关键词错误:", e);
        }

        // 创建高亮器
        SimpleHTMLFormatter formatter = new SimpleHTMLFormatter("<span style=\"color: #f73131\">", "</span>");
        Highlighter highlighter = new Highlighter(formatter, new QueryScorer(query));

        // 返参 VO
        List<Article> vos = new ArrayList<>();
        // 遍历查询到的文档，进行关键词高亮处理
        documents.forEach(document -> {
            try {
                // 文章标题
                String title = document.get(ArticleIndex.COLUMN_TITLE);

                // 获取高亮的片段
                TokenStream tokenStream = analyzer.tokenStream(ArticleIndex.COLUMN_TITLE, new StringReader(title));
                String titleFragment = highlighter.getBestFragment(tokenStream, title);

                // 如果没有匹配到关键词，则返回原始文本
                String highlightedTitle = StringUtils.isNoneBlank(titleFragment) ? titleFragment : title;

                String id = document.get(ArticleIndex.COLUMN_ID);
                String cover = document.get(ArticleIndex.COLUMN_COVER);
                String createTime = document.get(ArticleIndex.COLUMN_CREATE_TIME);
                String summary = document.get(ArticleIndex.COLUMN_SUMMARY);

                // 组装 VO
                Article searchArticleRespVo = new Article();
                searchArticleRespVo.setArticleId(Long.valueOf(id));
                searchArticleRespVo.setArticleTitle(highlightedTitle);
                searchArticleRespVo.setSummary(summary);
                searchArticleRespVo.setCoverUrl(cover);
                searchArticleRespVo.setCreateTime(DateUtils.dateTime(DateUtils.YYYY_MM_DD_HH_MM_SS, createTime));
                vos.add(searchArticleRespVo);
            } catch (Exception e) {
                log.error("文档转换错误: ", e);
            }
        });
        result.put("data", vos);
        return result;
    }
}

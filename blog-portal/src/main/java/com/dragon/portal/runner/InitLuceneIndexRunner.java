package com.dragon.portal.runner;

import cn.hutool.core.collection.CollectionUtil;
import com.dragon.common.utils.lucene.LuceneHelper;
import com.dragon.common.config.LuceneProperties;
import com.dragon.common.index.ArticleIndex;
import com.dragon.common.utils.DateUtils;
import com.dragon.common.utils.StringUtils;
import com.dragon.portal.domain.Article;
import com.dragon.portal.mapper.ArticleMapper;
import com.dragon.system.domain.SysFile;
import com.dragon.system.service.ISysFileService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 初始化 lucene 索引
 *
 * @author dragon
 * @date 2024-06-29
 */
@Component
@Slf4j
public class InitLuceneIndexRunner implements CommandLineRunner {

    @Autowired
    private LuceneProperties luceneProperties;

    @Autowired
    private LuceneHelper luceneHelper;

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private ISysFileService iSysFileService;

    @Override
    public void run(String... args) throws Exception {
        log.info("==> 开始初始化 Lucene 索引...");
        List<Article> articleList = articleMapper.selectArticleList(new Article());
        // 未发布文章，则不创建 lucene 索引
        if (CollectionUtil.isEmpty(articleList)) {
            log.info("==> 未发布任何文章，暂不创建 Lucene 索引...");
            return;
        }

        // 若配置文件中未配置索引存放目录，日志提示错误信息
        if (StringUtils.isBlank(luceneProperties.getIndexDir())) {
            log.error("==> 未指定 Lucene 索引存放位置，需在 application.yml 文件中添加路径配置...");
            return;
        }
        List<Document> documents = Lists.newArrayList();
        articleList.forEach(article -> {
            Long articleId = article.getArticleId();
            // 获取封面URL
            if(article != null && article.getCover() != null){
                SysFile sysFile = iSysFileService.selectSysFileByFileId(article.getCover());
                if(sysFile != null){
                    article.setCoverUrl(sysFile.getFileUrl());
                }
            }
            // 构建文档
            Document document = new Document();
            // 设置文档字段 Field
            document.add(new TextField(ArticleIndex.COLUMN_ID, String.valueOf(articleId), Field.Store.YES));
            document.add(new TextField(ArticleIndex.COLUMN_TITLE, article.getArticleTitle(), Field.Store.YES));
            document.add(new TextField(ArticleIndex.COLUMN_COVER, article.getCoverUrl(), Field.Store.YES));
            document.add(new TextField(ArticleIndex.COLUMN_SUMMARY, article.getSummary(), Field.Store.YES));
            document.add(new TextField(ArticleIndex.COLUMN_CONTENT, article.getContent(), Field.Store.YES));
            document.add(new TextField(ArticleIndex.COLUMN_CREATE_TIME, DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, article.getCreateTime()), Field.Store.YES));
            documents.add(document);
        });

        // 创建索引
        luceneHelper.createIndex(ArticleIndex.NAME, documents);

        log.info("==> 结束初始化 Lucene 索引...");
    }
}

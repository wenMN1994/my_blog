package com.dragon.portal.event.subscriber;

import com.dragon.common.index.ArticleIndex;
import com.dragon.common.utils.DateUtils;
import com.dragon.common.utils.lucene.LuceneHelper;
import com.dragon.portal.domain.Article;
import com.dragon.portal.event.UpdateArticleEvent;
import com.dragon.portal.mapper.ArticleMapper;
import com.dragon.portal.service.IArticleStatisticsService;
import com.dragon.system.domain.SysFile;
import com.dragon.system.service.ISysFileService;
import lombok.extern.slf4j.Slf4j;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.Term;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

/**
 * 文章更新事件
 *
 * @author dragon
 * @date 2024-06-29
 */
@Component
@Slf4j
public class UpdateArticleSubscriber implements ApplicationListener<UpdateArticleEvent> {

    @Autowired
    private LuceneHelper luceneHelper;

    @Autowired
    private ArticleMapper articleMapper;

    @Autowired
    private IArticleStatisticsService articleStatisticsService;

    @Autowired
    private ISysFileService iSysFileService;

    @Override
    @Async("threadPoolTaskExecutor")
    public void onApplicationEvent(UpdateArticleEvent event) {
        // 在这里处理收到的事件，可以是任何逻辑操作
        List<Long> articleIds = event.getArticleIds();
        Integer type = event.getType();
        // 获取当前线程名称
        String threadName = Thread.currentThread().getName();
        log.info("==> threadName: {}", threadName);
        log.info("==> 文章更新事件消费开始，articleIds: {}", articleIds);
        for (Long articleId : articleIds) {
            // 搜索新发布的文章
            Article article = articleMapper.selectArticleByArticleId(articleId);
            // 获取封面URL
            if(article != null && article.getCover() != null){
                SysFile sysFile = iSysFileService.selectSysFileByFileId(article.getCover());
                if(sysFile != null){
                    article.setCoverUrl(sysFile.getFileUrl());
                }
            }
            // 构建文档
            Document document = new Document();
            document.add(new TextField(ArticleIndex.COLUMN_ID, String.valueOf(articleId), Field.Store.YES));
            document.add(new TextField(ArticleIndex.COLUMN_TITLE, article.getArticleTitle(), Field.Store.YES));
            document.add(new TextField(ArticleIndex.COLUMN_COVER, article.getCoverUrl(), Field.Store.YES));
            document.add(new TextField(ArticleIndex.COLUMN_SUMMARY, article.getSummary(), Field.Store.YES));
            document.add(new TextField(ArticleIndex.COLUMN_CONTENT, article.getContent(), Field.Store.YES));
            document.add(new TextField(ArticleIndex.COLUMN_CREATE_TIME, DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD_HH_MM_SS, article.getCreateTime()), Field.Store.YES));

            if (Objects.equals(1, type)) {
                // 添加文档
                long count = luceneHelper.addDocument(ArticleIndex.NAME, document);
                log.info("==> 添加文章对应 Lucene 文档结束，articleId: {}，受影响行数: {}", articleId, count);
            } else if (Objects.equals(2, type)) {
                // 更新条件
                Term condition = new Term(ArticleIndex.COLUMN_ID, String.valueOf(articleId));
                long count = luceneHelper.updateDocument(ArticleIndex.NAME, document, condition);
                log.info("==> 更新文章对应 Lucene 文档结束，articleId: {}，受影响行数: {}", articleId, count);
            } else {
                // 删除条件，根据文章 id 来删除
                Term condition = new Term(ArticleIndex.COLUMN_ID, String.valueOf(articleId));
                long count = luceneHelper.deleteDocument(ArticleIndex.NAME, condition);
                log.info("==> 删除文章对应 Lucene 文档结束，articleId: {}，受影响行数: {}", articleId, count);
            }
        }
        log.info("==> 文章更新事件消费成功，articleIds: {}", articleIds);
        // 重新统计各分类下文章总数
        articleStatisticsService.statisticsCategoryArticleTotal();
        log.info("==> 重新统计各分类下文章总数");

        // 重新统计各标签下文章总数
        articleStatisticsService.statisticsTagArticleTotal();
        log.info("==> 重新统计各标签下文章总数");
    }
}
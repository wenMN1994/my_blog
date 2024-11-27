package com.dragon.portal.runner;

import com.dragon.portal.service.IArticleStatisticsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author: DragonWen
 * @date: 2024/6/29
 * @Version: 1.0
 * @description: 统计各标签下文章数量
 */
@Component
@Slf4j
public class StatisticsTagArticleTotalRunner implements CommandLineRunner {

    @Autowired
    private IArticleStatisticsService articleStatisticsService;

    /**
     * 统计各标签下文章数量
     * @param args
     * @throws Exception
     */
    @Async("threadPoolTaskExecutor")
    @Override
    public void run(String... args) throws Exception {
        log.info("==> 开始统计各标签下文章数量...");
        articleStatisticsService.statisticsTagArticleTotal();
        log.info("==> 结束统计各标签下文章数量...");
    }
}

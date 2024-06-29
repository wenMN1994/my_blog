package com.dragon.common.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * lucene 配置
 *
 * @author dragon
 * @date 2024-06-29
 */
@ConfigurationProperties(prefix = "lucene")
@Component
@Data
public class LuceneProperties {

    private String indexDir;
}

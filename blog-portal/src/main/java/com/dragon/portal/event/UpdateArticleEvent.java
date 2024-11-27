package com.dragon.portal.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.util.List;

/**
 * 文章更新事件
 *
 * @author dragon
 * @date 2024-06-29
 */
@Getter
public class UpdateArticleEvent extends ApplicationEvent {

    /**
     * 文章 ID 集合
     */
    private List<Long> articleIds;

    /**
     * 类型：1：发布，2：更新 3：删除
     */
    private Integer type;

    public UpdateArticleEvent(Object source, List<Long> articleIds, Integer type) {
        super(source);
        this.articleIds = articleIds;
        this.type = type;
    }
}

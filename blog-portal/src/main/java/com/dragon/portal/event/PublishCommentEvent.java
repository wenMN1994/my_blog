package com.dragon.portal.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * @author: DragonWen
 * @date: 2024/8/23
 * @Version: 1.0
 * @description: 评论发布事件
 */
@Getter
public class PublishCommentEvent extends ApplicationEvent {

    /**
     * 评论 ID
     */
    private Long commentId;

    public PublishCommentEvent(Object source, Long commentId) {
        super(source);
        this.commentId = commentId;
    }
}

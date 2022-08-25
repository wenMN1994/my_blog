package com.dragon.quartz.task;

import com.dragon.common.utils.StringUtils;
import org.springframework.stereotype.Component;

/**
 * 定时任务调度测试
 * 
 * @author dragon
 */
@Component("blogTask")
public class BlogTask {
    public void blogMultipleParams(String s, Boolean b, Long l, Double d, Integer i) {
        System.out.println(StringUtils.format("执行多参方法： 字符串类型{}，布尔类型{}，长整型{}，浮点型{}，整形{}", s, b, l, d, i));
    }

    public void blogParams(String params) {
        System.out.println("执行有参方法：" + params);
    }

    public void blogNoParams() {
        System.out.println("执行无参方法");
    }
}

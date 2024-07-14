package com.dragon.common.utils.markdown;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: DragonWen
 * @date: 2024/7/14
 * @Version: 1.0
 * @description: Markdown 统计工具类
 */
public class MarkdownStatsUtil {

    /**
     * 每分钟阅读的字数，假设为 300 个字 （根据实际情况进行调整）
     */
    private static final int WORDS_READ_PRE_MINUTE = 300;

    private static final Pattern chinesePattern = Pattern.compile("[\\u4e00-\\u9fa5]");

    /**
     * 计算 markdown 字数
     * @param markdown
     * @return
     */
    public static int calculateWordCount(String markdown) {
        // 将 markdown 中连续的空白字符（包括空格、制表符、换行符等）替换成一个空格
        String cleanText = markdown.replaceAll("\\s+", " ");
        // 使用正则表达式匹配中文
        Matcher chineseMatcher = chinesePattern.matcher(cleanText);
        // 计算中文字数
        int chineseCount = 0;
        while (chineseMatcher.find()) {
            chineseCount++;
        }
        // 去除中文
        String textWithoutChinese = cleanText.replaceAll("[\\u4e00-\\u9fa5]", "");

        if (StringUtils.isBlank(textWithoutChinese)) {
            return chineseCount;
        }
        // 使用空格分割文本为单词
        String[] words = textWithoutChinese.trim().split("\\s+");
        return chineseCount + words.length;
    }

    /**
     * 计算阅读时长
     * @param wordCount
     * @return
     */
    public static String calculateReadingTime(int wordCount) {
        // 判断总字数是否大于一分钟阅读字数
        if (wordCount >= WORDS_READ_PRE_MINUTE) {
            // 计算花费分钟数
            int minutes = wordCount / WORDS_READ_PRE_MINUTE;
            return "约 " + minutes + " 分钟";
        }
        // 若总字数小于一分钟阅读字数，则按秒来计算
        int seconds = (wordCount % WORDS_READ_PRE_MINUTE) * 60 / WORDS_READ_PRE_MINUTE;
        // 最小阅读时长为 1s
        if (seconds == 0) {
            seconds = 1;
        }
        return "约 " + seconds + " 秒";
    }
}

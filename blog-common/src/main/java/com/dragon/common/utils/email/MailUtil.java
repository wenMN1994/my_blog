package com.dragon.common.utils.email;

import com.dragon.common.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @author：DragonWen
 * @email：18475536452@163.com
 * @date：Created 2022-08-18
 * @description：发送邮件工具类
 */
@Slf4j
@Component
public class MailUtil {

    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    private JavaMailSender mailSender;

    /**
     * 发送邮件
     * @param to 收件人
     * @param cc 抄送
     * @param bcc 密送
     * @param subject 主题
     * @param content 内容
     * @return
     */
    public boolean sendText(String to, String cc, String bcc, String subject, String content) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            // 发送者
            message.setFrom(from);
            // 收件人
            message.setTo(to);
            // 抄送
            if(!StringUtils.isEmpty(cc)){
                message.setCc(cc);
            }
            // 密送
            if(!StringUtils.isEmpty(bcc)){
                message.setBcc(bcc);
            }
            //邮件主题
            message.setSubject(subject);
            //邮件内容
            message.setText(content);
            mailSender.send(message);
            return true;
        } catch (Exception e) {
            log.error("邮件发送异常：", e);
            return false;
        }
    }

    /**
     * 发送富文本邮件
     * @param to 收件人
     * @param cc 抄送
     * @param bcc 密送
     * @param subject 主题
     * @param content 内容
     * @return
     */
    public boolean sendHtml(String to, String cc, String bcc, String subject, String content) {
        // 使用 JavaMail 的 MimeMessage，支持更多复杂的邮件格式和内容
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            // 创建 MimeMessageHelper 对象，处理 MimeMessage 辅助类
            getMimeMessageHelper(to, cc, bcc, subject, content, mimeMessage);
            mailSender.send(mimeMessage);
            return true;
        } catch (MessagingException e) {
            log.error("邮件发送异常：", e);;
            return false;
        }
    }

    /**
     * 发送富文本带附件的邮件
     * @param to 收件人
     * @param cc 抄送
     * @param bcc 密送
     * @param subject 主题
     * @param content 内容
     * @param file 附件
     * @param fileName 附件名
     * @return
     */
    public boolean sendHtmlWithAttach(String to, String cc, String bcc, String subject, String content, File file, String fileName) {
        // 使用 JavaMail 的 MimeMessage，支持更多复杂的邮件格式和内容
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = getMimeMessageHelper(to, cc, bcc, subject, content, mimeMessage);
            //添加附件,并重命名
            helper.addAttachment(fileName, file);
            mailSender.send(mimeMessage);
            return true;
        } catch (MessagingException e) {
            log.error("发送富文本带附件的邮件：", e);
            return false;
        }
    }

    /**
     * 创建 MimeMessageHelper 对象，处理 MimeMessage 辅助类
     * @param to 收件人
     * @param cc 抄送
     * @param bcc 密送
     * @param subject 主题
     * @param content 内容
     * @param mimeMessage
     * @return
     * @throws MessagingException
     */
    private MimeMessageHelper getMimeMessageHelper(String to, String cc, String bcc, String subject, String content, MimeMessage mimeMessage) throws MessagingException {
        // 创建 MimeMessageHelper 对象，处理 MimeMessage 辅助类
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        // 使用辅助类 MimeMessage 设定参数
        helper.setFrom(from);
        // 收件人
        helper.setTo(to);
        // 抄送
        if(!StringUtils.isEmpty(cc)){
            helper.setCc(cc);
        }
        // 密送
        if(!StringUtils.isEmpty(bcc)){
            helper.setBcc(bcc);
        }
        // 邮件主题
        helper.setSubject(subject);
        // 邮件内容
        helper.setText(content, true);
        return helper;
    }
}

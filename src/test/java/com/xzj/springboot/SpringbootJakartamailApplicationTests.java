package com.xzj.springboot;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Objects;

@Slf4j
@SpringBootTest
class SpringbootJakartamailApplicationTests {

    //注入邮件发送对象
    @Resource private JavaMailSender mailSender;

    @Test
    void testMailB() throws MessagingException {
        //创建复杂有限发送对象
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
        //messageHelper.setFrom("antladdie@163.com");           // 设置发件人邮箱（若配置默认邮箱则不用再设置）
        messageHelper.setTo("liuyuhui@tartansh.com");            // 设置收件人邮箱
        //messageHelper.setCc("xiaofeng500@qq.com");            // 设置抄报人邮箱（可以不填写）
        //messageHelper.setBcc("575814158@qq.com");             // 设置密送人邮箱（可以不填写）
        messageHelper.setSubject("问题反馈");                  // 设置邮件主题

        //获取项目资源根目录 resources/file  并准备资源
        String rootPath = Objects.requireNonNull(SpringbootJakartamailApplicationTests.class.getClassLoader().getResource("file")).getFile();
        FileSystemResource xls = new FileSystemResource(new File(rootPath + "/bitRun.xls"));
        FileSystemResource xlsx = new FileSystemResource(new File(rootPath + "/production.xlsx"));
        //FileSystemResource mp3 = new FileSystemResource(new File(rootPath + "/mu.mp3"));
        //FileSystemResource zip = new FileSystemResource(new File(rootPath + "/redis.zip"));

        //关于附件  资源  HTML 文本的设置
        //设置附件
        //设置一个 图片附件
//        messageHelper.addAttachment(Objects.requireNonNull(jpg.getFilename()), jpg);
        //设置一个 excel附件
        messageHelper.addAttachment(Objects.requireNonNull(xls.getFilename()), xls);
        messageHelper.addAttachment(Objects.requireNonNull(xlsx.getFilename()), xlsx);
        //设置一个 mp3附件
        //messageHelper.addAttachment(Objects.requireNonNull(mp3.getFilename()), mp3);
        //设置一个 zip附件  不过发送垃圾附件可能会被识别 554 HL:IHU 发信IP因发送垃圾邮件或存在异常的连接行为
        //messageHelper.addAttachment(Objects.requireNonNull(zip.getFilename()), zip);

        //设置邮件内容   cid:资源id     在内容中引用资源    后面true代表是html内容
        //messageHelper.setText("<h2 style='color:#f00;'>欠费通知：您已欠费200元<img src='cid:p01' alt='' style='width:200px;height:50px;'></h2>", true);
        messageHelper.setText("bug如文件所示");

        //设置资源 必须设置否则传送文件会出错
        FileSystemResource resPng = new FileSystemResource(new File(rootPath + "/b.png"));
        messageHelper.addInline("p01",resPng);

        //发送
        try {
            mailSender.send(mimeMessage);
        } catch (MailException e) {
            log.info("发送失败，查看网络");
        }
    }
}

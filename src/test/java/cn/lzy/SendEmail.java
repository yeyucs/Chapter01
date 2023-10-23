package cn.lzy;

import cn.lzy.taskmanagement.email.SendEmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;

/**
 * @author:韦盛彪
 * @creat: 2023-10-23  11:04
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SendEmail {
    @Autowired
    private SendEmailService sendEmailService;
    @Autowired
    private TemplateEngine templateEngine;
    @Test
    public void sendSimpleMailTest() {
        String to="2186581367@qq.com";
        String subject="发邮件";
        //定义邮件内容
        String filePath="C:\\Users\\86136\\AppData\\Roaming\\Tencent\\WeMeet\\Global\\IM\\file\\2023-10\\13819927683625612987\\7c8faec9aea71e74e42b441c12e5197d\\第九章作业.txt";
        String rscPath="C:\\Users\\86136\\Pictures\\Saved Pictures\\茉吱生日回壁纸.png";



        sendEmailService.sendMailWithAttachment(to,subject,"测试",rscPath,"id",filePath,"第九章作业");
    }


    @Test
    public void sendSimpleMailTestFilePath() {
        String to="2186581367@qq.com";
        String subject="单独发附件";
        //定义邮件内容
        String filePath="C:\\Users\\86136\\AppData\\Roaming\\Tencent\\WeMeet\\Global\\IM\\file\\2023-10\\13819927683625612987\\7c8faec9aea71e74e42b441c12e5197d\\第九章作业.txt";

        sendEmailService.sendMailWithAttachmentfilePath(to,subject,"",filePath,"第九章作业");
    }

    @Test
    public void sendSimpleMailTestrscPath() {
        String to="2186581367@qq.com";
        String subject="单独发图片";

        //定义邮件内容
        String rscPath="C:\\Users\\86136\\Pictures\\Saved Pictures\\茉吱生日回壁纸.png";

        sendEmailService.sendMailWithAttachmentrscPath(to,subject,"",rscPath,"img001");
    }

    @Test
    public void sendSimpleMailTestchun() {
        String to="2186581367@qq.com";
        String subject="纯文字";
        String text="Spring Boot 纯文本邮件测试";

        sendEmailService.sendSimpleEmail(to,subject,text);

    }

    @Test
    public void sendTemplateEmailTest() {
        String to="2186581367@qq.com";
        String subject="模板邮件";

        Context context = new Context();
        context.setVariable("username","石头");
        context.setVariable("code","456123");

        String emailContent = templateEngine.process("emailTemplate_vercode",context);

        sendEmailService.sendSimpleEmailHtml(to,subject,emailContent);

    }
}
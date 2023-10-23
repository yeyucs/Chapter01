package cn.lzy.taskmanagement.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @author:韦盛彪
 * @creat: 2023-10-23  11:00
 */
@Service
public class SendEmailService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String from;
    public void sendMailWithAttachment(String to, String subject, String text,String rscPath,String rscId,String filePath,String fileName)  {

        boolean isSend = true;
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(from);// 发件人
            helper.setTo(to);// 收件人
            helper.setSubject(subject);// 标题
            helper.setText(text);// text：内容

            /* 创建html内容，若不创建html标签,则图片会以附件的形式发送，而并非直接以内容显示 */
            String content = "<html><body>" + text + "<img src=\'cid:" + rscId + "\'></img>" + "</body></html>";
            helper.setText(content, true);// text：内容，true:为HTML邮件（false则为普通文本邮件）
            File file = new File(rscPath);// 创建图片文件
            FileSystemResource resource = new FileSystemResource(file);
            helper.addInline(rscId, resource);

            File file1 = new File(filePath);// 创建文件
            FileSystemResource resource1 = new FileSystemResource(file1);
            helper.addAttachment(fileName, resource1);//若要添加多个附件,需要创建多个file然后分别addAttachment
            javaMailSender.send(mimeMessage);// 发送邮件
            System.out.println("邮件发送成功");
        }catch (MessagingException e){
            System.out.println("邮件发送失败"+e.getMessage());
            e.printStackTrace();
        }
    }

    public void sendMailWithAttachmentfilePath(String to, String subject, String text,String filePath,String fileName)  {

        boolean isSend = true;
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(from);// 发件人
            helper.setTo(to);// 收件人
            helper.setSubject(subject);// 标题
            helper.setText(text);// text：内容

            File file1 = new File(filePath);// 创建文件
            FileSystemResource resource1 = new FileSystemResource(file1);
            helper.addAttachment(fileName, resource1);//若要添加多个附件,需要创建多个file然后分别addAttachment
            javaMailSender.send(mimeMessage);// 发送邮件
            System.out.println("单独发送附件邮件发送成功");
        }catch (MessagingException e){
            System.out.println("单独发送附件邮件发送失败"+e.getMessage());
            e.printStackTrace();
        }
    }

    public void sendMailWithAttachmentrscPath(String to, String subject, String text,String rscPath,String rscId)  {

        boolean isSend = true;
        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(from);// 发件人
            helper.setTo(to);// 收件人
            helper.setSubject(subject);// 标题
            helper.setText(text, true);// text：内容

            /* 创建html内容，若不创建html标签,则图片会以附件的形式发送，而并非直接以内容显示 */
            String content = "<html><body>" + text + "<img src=\'cid:" + rscId + "\'></img>" + "</body></html>";
            helper.setText(content, true);// text：内容，true:为HTML邮件（false则为普通文本邮件）
            File file = new File(rscPath);// 创建图片文件
            FileSystemResource resource = new FileSystemResource(file);
            helper.addInline(rscId, resource);
            javaMailSender.send(mimeMessage);// 发送邮件
            System.out.println("单独发送图片邮件发送成功");
        }catch (MessagingException e){
            System.out.println("单独发送图片邮件发送失败"+e.getMessage());
            e.printStackTrace();
        }
    }

    public void sendSimpleEmail(String to,String subject,String text) {
        SimpleMailMessage helper = new SimpleMailMessage();
        helper.setFrom(from);// 发件人
        helper.setTo(to);// 收件人
        helper.setSubject(subject);// 标题
        helper.setText(text);// text：内容
        try {
            //发送邮件
            javaMailSender.send(helper);
            System.out.println("纯文本邮件发送成功");
        } catch (MailException e) {
            System.out.println("纯文本邮件发送失败"+e.getMessage());
            e.printStackTrace();
        }
    }

    public void sendSimpleEmailHtml(String to,String subject,String content) {
        MimeMessage message = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom(from);// 发件人
        helper.setTo(to);// 收件人
        helper.setSubject(subject);// 标题
        helper.setText(content, true);// text：内容

            //发送邮件
            javaMailSender.send(message);
            System.out.println("模板邮件发送成功");
        } catch (MessagingException e) {
            System.out.println("模板邮件发送失败"+e.getMessage());
            e.printStackTrace();
        }
    }
}

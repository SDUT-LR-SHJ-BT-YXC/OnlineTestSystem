package cn.OnlineTestSystem.utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

/**
 * @ClassName SendEmailUtils
 * @Desciption 发送一封邮件
 * @Author shangjin
 * @Date 2019-12-08 16:46
 * @Version 1.0
 **/
public class SendEmailUtils {
    //发送用的email
    private static String fromEmail = "shangjinv5@163.com";
    //163客户端授权码
    private static String authorization = "951780442sj";
    /**
     * @Author: Shangjin
     * @Description:发送邮件
     * @Param:
     * @Return:
     * @Date: 17:47 2019-12-08
     */
    public static void sendEmail(String toEmail, String content) throws UnsupportedEncodingException, MessagingException {
        Properties properties = new Properties();
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.smtp.host", "smtp.163.com");
        properties.setProperty("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail,authorization );
            }
        });
        session.setDebug(true);
        Transport transport = session.getTransport();
        transport.connect("smtp.163.com", fromEmail, authorization);

        MimeMessage message = createMimeMessage(session, fromEmail, toEmail, content);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }
    /**
     * @Author: Shangjin
     * @Description:创建一个MinmeMessage对象
     * @Param:
     * @Return:
     * @Date: 17:47 2019-12-08
     */
    private static MimeMessage createMimeMessage(Session session, String sendMail, String receivemail, String content) throws UnsupportedEncodingException, MessagingException {
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(sendMail, "在线答题系统", "UTF-8"));
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receivemail, "在线答题系统用户", "UTF-8"));
        message.setSubject("修改密码", "UTF-8");
        message.setContent(content, "text/html;charset=UTF-8");
        message.setSentDate(new Date());
        message.saveChanges();
        return message;
    }
}

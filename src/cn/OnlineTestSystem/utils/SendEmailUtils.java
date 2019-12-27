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
    // 发件人的 邮箱 和 密码（替换为自己的邮箱和密码）
    // PS: 某些邮箱服务器为了增加邮箱本身密码的安全性，给 SMTP 客户端设置了独立密码（有的邮箱称为“授权码”）,
    // 对于开启了独立密码的邮箱, 这里的邮箱密码必需使用这个独立密码（授权码）。

    private static String fromEmail = "shangjinv5@163.com";//发送用的email
    private static String authorization = "951780442sj";//163客户端授权码
    /**
     * @Author: Shangjin
     * @Description:发送邮件
     * @Param:
     * @Return:
     * @Date: 17:47 2019-12-08
     */
    public static void sendEmail(String toEmail, String content) throws UnsupportedEncodingException, MessagingException {
        Properties properties = new Properties();
        // 1. 创建参数配置, 用于连接邮件服务器的参数配置
        properties.setProperty("mail.transport.protocol", "smtp");// 使用的协议（JavaMail规范要求）
        //SMTP服务器地址：一般是 smtp.xxx.com，比如163邮箱是smtp.163.com，qq邮箱是smtp.qq.com。
        properties.setProperty("mail.smtp.host", "smtp.163.com");//发件人的邮箱的 SMTP 服务器地址
        properties.setProperty("mail.smtp.auth", "true");// 需要请求认证
        // PS: 某些邮箱服务器要求 SMTP 连接需要使用 SSL 安全认证 (为了提高安全性, 邮箱支持SSL连接, 也可以自己开启),
        // 如果无法连接邮件服务器, 仔细查看控制台打印的 log, 如果有有类似 “连接失败, 要求 SSL 安全连接” 等错误,
        // 打开下面 /* ... */ 之间的注释代码, 开启 SSL 安全连接。
        /*
       // SMTP 服务器的端口 (非 SSL 连接的端口一般默认为 25, 可以不添加, 如果开启了 SSL 连接,
       //   需要改为对应邮箱的 SMTP 服务器的端口, 具体可查看对应邮箱服务的帮助,
        //   QQ邮箱的SMTP(SLL)端口为465或587, 其他邮箱自行去查看)
       final String smtpPort = "465";
        props.setProperty("mail.smtp.port", smtpPort);
        props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.setProperty("mail.smtp.socketFactory.fallback", "false");
        props.setProperty("mail.smtp.socketFactory.port", smtpPort);
        */

        // 2. 根据配置创建会话对象, 用于和邮件服务器交互
        Session session = Session.getDefaultInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail,authorization );
            }
        });
        session.setDebug(false);// 设置为debug模式, 可以查看详细的发送 log

        // 3. 创建一封邮件
        MimeMessage message = createMimeMessage(session, fromEmail, toEmail, content);

        // 4. 根据 Session 获取邮件传输对象
        Transport transport = session.getTransport();

        //5. 使用 邮箱账号 和 密码 连接邮件服务器, 这里认证的邮箱必须与 message 中的发件人邮箱一致, 否则报错
        transport.connect("smtp.163.com", fromEmail, authorization);

        // 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
        transport.sendMessage(message, message.getAllRecipients());

        // 7.关闭连接
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
        //创建一封邮件
        MimeMessage message = new MimeMessage(session);

        // 设置From: 发件人
        message.setFrom(new InternetAddress(sendMail, "在线答题系统", "UTF-8"));

        //设置收件人
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receivemail, "在线答题系统用户", "UTF-8"));

        //设置邮件主题
        message.setSubject("修改密码", "UTF-8");

        //设置邮件内容
        message.setContent(content, "text/html;charset=UTF-8");

        //设置邮件时间
        message.setSentDate(new Date());
        message.saveChanges();
        return message;
    }
}

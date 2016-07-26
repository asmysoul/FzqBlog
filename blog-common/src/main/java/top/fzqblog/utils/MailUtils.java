package top.fzqblog.utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;





/**
 * javaMail发送邮件工具类
 * 
 */
public class MailUtils {
        /**
         * 发送邮件
         * 
         * @param toAddress
         *            接收邮件地址
         * @param subject
         *            邮件主题
         * @param content
         *            邮件内容
         * @throws Exception 
         */
        public static void sendMail(final String sendUserName,
                        final String sendPassword, String toAddress, String subject, String content) throws Exception {
        	Properties p = new Properties();
    		p.setProperty("mail.host", "smtp.sina.com");
    		p.setProperty("mail.smtp.auth", "true");
    		Authenticator auth = new Authenticator(){
    			@Override
    			protected PasswordAuthentication getPasswordAuthentication() {
    				return new PasswordAuthentication(sendUserName,sendPassword);
    			}
    		};
    		Session session = Session.getInstance(p, auth);
    		MimeMessage mm = new MimeMessage(session);
			mm.setFrom(new InternetAddress(sendUserName));
			mm.setRecipient(RecipientType.TO, new InternetAddress(toAddress));
			mm.setSubject(subject);
			mm.setContent(content, "text/html;charset=utf-8");
			Transport.send(mm);	
        }
}


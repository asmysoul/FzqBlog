package top.fzqblog.test.service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import top.fzqblog.exception.BussinessException;
import top.fzqblog.po.model.User;
import top.fzqblog.service.UserService;
import top.fzqblog.utils.MailUtils;
import top.fzqblog.utils.StringUtils;


@ContextConfiguration(locations = {"classpath:spring.xml"})
public class ServiceTest extends AbstractTestNGSpringContextTests{
	private Logger logger = LoggerFactory.getLogger(ServiceTest.class);
	@Autowired
	private UserService userService;
	@Test
	public void test() throws BussinessException{
		User user = new User();
		user.setUserName("fan52000");
		user.setEmail("2770@qq.com");
		user.setPassword("123456");
		userService.register(user);
	}
	
	@Test
	public void testlogin() throws BussinessException{
		System.out.println(userService.login("fan520@qq.com", "fan520"));
	}
	
	@Test
	public void testMailUtils() throws Exception{
		String checkCode = StringUtils.getActivationCode(6);
		
		String subject = "FZQBLOG邮件";
		
		StringBuffer content = new StringBuffer("亲爱的" + "asa"+ "用户<br><br>");
		content.append("您的验证码是" + checkCode);
		MailUtils.sendMail("fzqblog@163.com", "fan27708324", "27708324@qq.com",
					subject, new String(content));
	}
	
	@Test
	public void testsendMail() throws Exception{
		userService.sendCheckCode("27708324@qq.com");
	}
	
	@Test
	public void testsendgetRandomString() throws Exception{
		System.out.println(StringUtils.getActivationCode(6));
	}
	
	@Test
	public void mailTest(){
		Properties p = new Properties();
		p.setProperty("mail.host", "smtp.sina.com");
		p.setProperty("mail.smtp.auth", "true");
		Authenticator auth = new Authenticator(){
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("fzqblog@sina.com","fan520");
			}
		};
		Session session = Session.getInstance(p, auth);
		MimeMessage mm = new MimeMessage(session);
		try {
			mm.setFrom(new InternetAddress("fzqblog@sina.com"));
			mm.setRecipient(RecipientType.TO, new InternetAddress("1134273060@qq.com"));
			mm.setSubject("测试邮件");
			mm.setContent("测试一下啦啦啦啦", "text/html;charset=utf-8");
			Transport.send(mm);
		} catch (AddressException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

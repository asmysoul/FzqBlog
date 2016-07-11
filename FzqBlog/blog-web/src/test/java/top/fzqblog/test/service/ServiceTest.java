package top.fzqblog.test.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import top.fzqblog.exception.BussinessException;
import top.fzqblog.po.model.User;
import top.fzqblog.service.UserService;


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
}

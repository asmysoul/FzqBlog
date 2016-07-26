package top.fzqblog.test.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import top.fzqblog.po.model.SignInfo;
import top.fzqblog.service.SignInService;

@ContextConfiguration(locations = {"classpath:spring.xml"})
public class SignInServiceTest extends AbstractTestNGSpringContextTests{
	private Logger logger = LoggerFactory.getLogger(ServiceTest.class);
	
	@Autowired
	private SignInService signInService;
	
	@Test
	public void testFindSignInfoByUserid(){
		SignInfo signInfo = signInService.findSignInfoByUserid(10000);
		System.out.println(signInfo.getCurDate());
		System.out.println(signInfo.getTodaySignInCount());
		System.out.println(signInfo.getUserSignInCount());
	}

}

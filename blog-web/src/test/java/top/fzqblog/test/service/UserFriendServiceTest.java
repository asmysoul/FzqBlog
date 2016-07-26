package top.fzqblog.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import top.fzqblog.po.model.UserFriend;
import top.fzqblog.po.query.UserFriendQuery;
import top.fzqblog.service.UserFriendService;
import top.fzqblog.utils.PageResult;

@ContextConfiguration(locations = {"classpath:spring.xml"})
public class UserFriendServiceTest extends AbstractTestNGSpringContextTests{
	@Autowired
	private UserFriendService userFriendService;
	
	@Test
	public void testFindFriendList(){
		UserFriendQuery userFriendQuery = new UserFriendQuery();
		userFriendQuery.setUserId(10033);
		PageResult<UserFriend> pageResult = this.userFriendService.findFriendList(userFriendQuery);
		System.out.println(pageResult.getList());
	}
}

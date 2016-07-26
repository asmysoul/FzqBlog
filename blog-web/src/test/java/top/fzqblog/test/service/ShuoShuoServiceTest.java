package top.fzqblog.test.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import top.fzqblog.exception.BussinessException;
import top.fzqblog.po.model.ShuoShuo;
import top.fzqblog.po.model.ShuoShuoComment;
import top.fzqblog.po.model.ShuoShuoLike;
import top.fzqblog.po.query.ShuoShuoQuery;
import top.fzqblog.service.ShuoShuoService;
import top.fzqblog.service.impl.FormateAtService;
import top.fzqblog.utils.StringUtils;

@ContextConfiguration(locations = {"classpath:spring.xml"})
public class ShuoShuoServiceTest extends AbstractTestNGSpringContextTests{
	@Autowired
	private FormateAtService fas;
	@Autowired
	private ShuoShuoService shuoShuoService;
	@Test
	public void AddLinkTest(){
		String str = "http://www.baidu.com";
		System.out.println(StringUtils.addLink(str));
	}
	
	@Test
	public void formatAt(){
		System.out.println(fas.generateRefererLinks("@asmysoul dasfasdf", new HashSet<Integer>()));
	}
	
	@Test
	public void addShuoShuoTest() throws BussinessException{
		ShuoShuo shuoShuo = new ShuoShuo();
		shuoShuo.setUserId(10034);
		shuoShuo.setContent("无形之刃，最为致命");
		shuoShuo.setUserName("劫");
		shuoShuoService.addShuoShuo(shuoShuo);
	}
	@Test
	public void findShuoShuosTest(){
		System.out.println(this.shuoShuoService.findShuoShuoList(new ShuoShuoQuery()).getList());
	}
	
	@Test
	public void addCommentTest() throws BussinessException{
		ShuoShuoComment shuoShuoComment = new ShuoShuoComment();
		shuoShuoComment.setContent("哈哈哈");
		shuoShuoComment.setUserId(10038);
		shuoShuoComment.setShuoshuoId(111);
		this.shuoShuoService.addShuoShuoComment(shuoShuoComment);
	}
	
	@Test
	public void doLikeTest() throws BussinessException{
		ShuoShuoLike shuoShuoLike = new ShuoShuoLike();
		shuoShuoLike.setUserId(10034);
		shuoShuoLike.setShuoshuoId(128);
		this.shuoShuoService.doShuoShuoLike(shuoShuoLike);
	}
}

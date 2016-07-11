package top.fzqblog.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import top.fzqblog.exception.BussinessException;
import top.fzqblog.po.enums.ResponseCode;
import top.fzqblog.po.model.User;
import top.fzqblog.po.vo.AjaxResponse;
import top.fzqblog.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService UserService;
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	@RequestMapping("register")
	public String register(){
		return "/page/register";
	}
	@ResponseBody
	@RequestMapping("register.do")
	public AjaxResponse<Object> registerdo(HttpSession session, User user){
		System.out.println(user);
		AjaxResponse<Object> ajaxResponse = new AjaxResponse<Object>();
		try {
			UserService.register(user);
			ajaxResponse.setResponseCode(ResponseCode.SUCCESS);
		} catch (BussinessException e) {
			ajaxResponse.setErrorMsg(e.getLocalizedMessage());
			ajaxResponse.setResponseCode(ResponseCode.BUSSINESSERROR);
			logger.error("用户注册失败,用户名:{}邮箱:{}", user.getUserName(), user.getEmail());
		}catch (Exception e) {
			ajaxResponse.setErrorMsg(ResponseCode.SERVERERROR.getDesc());
			ajaxResponse.setResponseCode(ResponseCode.SERVERERROR);
			logger.error("用户注册失败,用户名:{}邮箱:{}", user.getUserName(), user.getEmail());
		}
		return ajaxResponse;
	}
	@RequestMapping("index")
	public String index(){
		return "/page/index";
	}
}

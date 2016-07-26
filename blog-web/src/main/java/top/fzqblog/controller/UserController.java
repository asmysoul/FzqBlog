package top.fzqblog.controller;


import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import org.springframework.web.servlet.ModelAndView;

import com.sun.mail.util.LogOutputStream;

import top.fzqblog.exception.BussinessException;
import top.fzqblog.po.enums.ResponseCode;
import top.fzqblog.po.model.SessionUser;
import top.fzqblog.po.model.SignInfo;
import top.fzqblog.po.model.User;
import top.fzqblog.po.vo.AjaxResponse;
import top.fzqblog.service.SignInService;
import top.fzqblog.service.UserService;
import top.fzqblog.utils.Constants;
import top.fzqblog.utils.StringUtils;

@Controller
public class UserController extends BaseController{
	@Autowired
	private UserService userService;
	@Autowired
	private SignInService signInService;
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	@RequestMapping("register")
	public String register(){
		return "/page/register";
	}
	
	@ResponseBody
	@RequestMapping("register.do")
	public AjaxResponse<Object> registerdo(HttpSession session, User user){
		AjaxResponse<Object> ajaxResponse = new AjaxResponse<Object>();
		try {
			userService.register(user);
			ajaxResponse.setResponseCode(ResponseCode.SUCCESS);
			SessionUser sessionUser = new SessionUser();
			sessionUser.setUserid(user.getUserid());
			sessionUser.setUserName(user.getUserName());
			sessionUser.setUserIcon(user.getUserIcon());
			session.setAttribute(Constants.SESSION_USER_KEY, sessionUser);
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
	public ModelAndView index(HttpSession session){
		Integer userid = this.getUserid(session);
		ModelAndView view = new ModelAndView("/page/index");
		if(userid !=null){
			SignInfo signInfo = this.signInService.findSignInfoByUserid(userid);
			view.addObject("signInfo", signInfo);
		}
		return view;
	}
	
	@RequestMapping("login")
	public String login(){
		return "/page/login";
	}
	
	@ResponseBody
	@RequestMapping("login.do")
	public AjaxResponse<Object> logindo(HttpServletRequest request, HttpServletResponse response, 
			String account, String password, String rememberMe){
		final String REMEMBERME = "1";
		AjaxResponse<Object> ajaxResponse = new AjaxResponse<Object>();
		HttpSession session = request.getSession();
		User user = null;
		try {
			user = userService.login(account, password);
			user.setLastLoginTime(new Date());
			ajaxResponse.setResponseCode(ResponseCode.SUCCESS);
			SessionUser sessionUser = new SessionUser();
			sessionUser.setUserid(user.getUserid());
			sessionUser.setUserName(user.getUserName());
			sessionUser.setUserIcon(user.getUserIcon());
			session.setAttribute(Constants.SESSION_USER_KEY, sessionUser);
			if(REMEMBERME.equals(rememberMe)){    // 清除之前的Cookie 信息    
				String infor = URLEncoder.encode(account.toString(), "utf-8") + "|" + user.getPassword();  
			    Cookie cookie = new Cookie(Constants.COOKIE_USER_INFO, null);    
			    cookie.setPath("/");    
			    cookie.setMaxAge(0);    
			    // 建用户信息保存到Cookie中    
			    cookie = new Cookie(Constants.COOKIE_USER_INFO, infor);    
			    cookie.setPath("/");    
			    // 设置最大生命周期为1年。    
			    cookie.setMaxAge(31536000);    
			    response.addCookie(cookie);   
			} 
			else {    
			    Cookie cookie = new Cookie(Constants.COOKIE_USER_INFO, null);
			    cookie.setMaxAge(0);    
			    cookie.setPath("/");    
			    response.addCookie(cookie);
			}
		} catch (BussinessException e) {
			ajaxResponse.setErrorMsg(e.getLocalizedMessage());
			ajaxResponse.setResponseCode(ResponseCode.BUSSINESSERROR);
			logger.error("用户登录失败,账号:{}",account);
		}catch (Exception e) {
			ajaxResponse.setErrorMsg(ResponseCode.SERVERERROR.getDesc());
			ajaxResponse.setResponseCode(ResponseCode.SERVERERROR);
			logger.error("用户登录失败,账号:{}", account);
		}
		return ajaxResponse;
	}
	
	@RequestMapping("findpassword")
	public String findPassword(){
		return "/page/findpassword";
	}
	
	@ResponseBody
	@RequestMapping("sendCheckCode")
	public  AjaxResponse<Object> sendCheckCode(String email){
		AjaxResponse<Object> ajaxResponse = new AjaxResponse<Object>();
		try {
			userService.sendCheckCode(email);
			ajaxResponse.setResponseCode(ResponseCode.SUCCESS);
		} catch (BussinessException e) {
			ajaxResponse.setErrorMsg(e.getLocalizedMessage());
			ajaxResponse.setResponseCode(ResponseCode.BUSSINESSERROR);
			logger.error("验证码发送失败,邮箱:{}" );
		}catch (Exception e) {
			ajaxResponse.setErrorMsg(ResponseCode.SERVERERROR.getDesc());
			ajaxResponse.setResponseCode(ResponseCode.SERVERERROR);
			logger.error("验证码发送失败,邮箱:{}", email);
		}
		return ajaxResponse;
	}
	
	@ResponseBody
	@RequestMapping("findPassword.do")
	public AjaxResponse<Object> findPassworddo(String email, String password, String checkcode){
		AjaxResponse<Object> ajaxResponse = new AjaxResponse<Object>();
		try {
			userService.modifyPassword(email, password, checkcode);
			ajaxResponse.setResponseCode(ResponseCode.SUCCESS);
		} catch (BussinessException e) {
			ajaxResponse.setErrorMsg(e.getLocalizedMessage());
			ajaxResponse.setResponseCode(ResponseCode.BUSSINESSERROR);
			logger.error("密码修改失败,邮箱{}", email);
		}
		catch (Exception e) {
			ajaxResponse.setErrorMsg(ResponseCode.SERVERERROR.getDesc());
			ajaxResponse.setResponseCode(ResponseCode.SERVERERROR);
			logger.error("密码修改失败,邮箱:{}", email);
		}
		return ajaxResponse;
	}
	
	@RequestMapping("logout")
	public ModelAndView logout(HttpSession session, HttpServletResponse response){
		ModelAndView view = new ModelAndView("page/login");
		session.invalidate();
		Cookie cookie = new Cookie(Constants.COOKIE_USER_INFO, null);
	    cookie.setMaxAge(0);    
	    cookie.setPath("/");    
	    response.addCookie(cookie);
		return view;
	}
	

}

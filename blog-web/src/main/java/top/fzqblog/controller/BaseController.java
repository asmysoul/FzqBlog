package top.fzqblog.controller;

import java.lang.reflect.Method;

import javax.servlet.http.HttpSession;

import top.fzqblog.po.enums.ResponseCode;
import top.fzqblog.po.model.SessionUser;
import top.fzqblog.po.model.User;
import top.fzqblog.po.vo.AjaxResponse;
import top.fzqblog.utils.Constants;



public class BaseController {
	
	public void setUserBaseInfo(Class<?> clazz, Object obj, HttpSession session){
		SessionUser sessionUser = (SessionUser) session.getAttribute(Constants.SESSION_USER_KEY);
		Integer userId = sessionUser.getUserid();
		String userName = sessionUser.getUserName();
		String userIcon = sessionUser.getUserIcon();
		try {
			Method UserIdMethod = clazz.getDeclaredMethod("setUserId", Integer.class);
			UserIdMethod.invoke(obj, userId);
			Method UserNameMethod = clazz.getDeclaredMethod("setUserName", String.class);
			UserNameMethod.invoke(obj, userName);
			Method UserIconMethod = clazz.getDeclaredMethod("setUserIcon", String.class);
			UserIconMethod.invoke(obj, userIcon);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	
	public Integer getUserid(HttpSession session){
		Object sessionObject = session.getAttribute(Constants.SESSION_USER_KEY);
		if(sessionObject != null){
			return ((SessionUser)sessionObject).getUserid();
		}
		return null;
	}
}

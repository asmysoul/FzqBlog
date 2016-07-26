package top.fzqblog.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import top.fzqblog.po.enums.ResponseCode;
import top.fzqblog.po.model.SessionUser;
import top.fzqblog.po.model.UserFriend;
import top.fzqblog.po.query.UserFriendQuery;
import top.fzqblog.po.vo.AjaxResponse;
import top.fzqblog.service.UserFriendService;
import top.fzqblog.utils.Constants;
import top.fzqblog.utils.PageResult;

@Controller
public class UserFriendController extends BaseController {
	@Autowired
	private UserFriendService userFriendService;
	
	private Logger logger = LoggerFactory.getLogger(UserFriendController.class);
	
	@ResponseBody
	@RequestMapping("loadUserFriend")
	public AjaxResponse<Object> loadUserFriend(HttpSession session, int pageNum){
		AjaxResponse<Object> ajaxResponse = new AjaxResponse<Object>();
		SessionUser sessionUser = (SessionUser) session.getAttribute(Constants.SESSION_USER_KEY);
		if(sessionUser==null){
			ajaxResponse.setResponseCode(ResponseCode.BUSSINESSERROR);
			ajaxResponse.setErrorMsg("请先登录");
			return ajaxResponse;
		}
		int userId = this.getUserid(session);
		UserFriendQuery userFriendQuery = new UserFriendQuery();
		userFriendQuery.setUserId(userId);
		userFriendQuery.setPageNum(pageNum);
		PageResult<UserFriend> pageResult = this.userFriendService.findFriendList(userFriendQuery);
		ajaxResponse.setData(pageResult);
		return ajaxResponse;
	}
}

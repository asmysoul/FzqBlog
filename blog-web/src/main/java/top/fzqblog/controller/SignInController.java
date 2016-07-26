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
import top.fzqblog.po.model.SessionUser;
import top.fzqblog.po.model.SignInfo;
import top.fzqblog.po.vo.AjaxResponse;
import top.fzqblog.service.SignInService;
import top.fzqblog.utils.Constants;

@Controller
public class SignInController extends BaseController {
	private Logger logger = LoggerFactory.getLogger(SignInController.class);
	@Autowired
	private SignInService signInService;
	
	
	@ResponseBody
	@RequestMapping("loadSignInfo")
	public AjaxResponse<Object> loadSignInfo(HttpSession session){
		AjaxResponse<Object> ajaxResponse = new AjaxResponse<Object>();
		Integer userid = this.getUserid(session);
		SignInfo signInfo = this.signInService.findSignInfoByUserid(userid);
		ajaxResponse.setData(signInfo);
		return ajaxResponse;
	}
	
	@ResponseBody
	@RequestMapping("signIn")
	public AjaxResponse<Object> signIn(HttpSession session){
		AjaxResponse<Object> ajaxResponse = new AjaxResponse<Object>();
		SessionUser sessionUser = (SessionUser) session.getAttribute(Constants.SESSION_USER_KEY);
		try {
			this.signInService.doSignIn(sessionUser);
			ajaxResponse.setResponseCode(ResponseCode.SUCCESS);
		} catch (BussinessException e) {
			ajaxResponse.setErrorMsg(e.getLocalizedMessage());
			ajaxResponse.setResponseCode(ResponseCode.BUSSINESSERROR);
			logger.error("用户{}签到失败", sessionUser.getUserName());
		}catch (Exception e) {
			ajaxResponse.setErrorMsg(ResponseCode.SERVERERROR.getDesc());
			ajaxResponse.setResponseCode(ResponseCode.SERVERERROR);
			logger.error("用户签到失败,用户名",sessionUser.getUserName());
		}
		return ajaxResponse;
	}
}

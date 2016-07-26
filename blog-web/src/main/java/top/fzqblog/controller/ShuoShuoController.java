package top.fzqblog.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;








import top.fzqblog.exception.BussinessException;
import top.fzqblog.po.query.ShuoShuoQuery;
import top.fzqblog.po.vo.AjaxResponse;
import top.fzqblog.service.ShuoShuoService;
import top.fzqblog.utils.Constants;
import top.fzqblog.utils.PageResult;
import top.fzqblog.po.enums.ResponseCode;
import top.fzqblog.po.model.SessionUser;
import top.fzqblog.po.model.ShuoShuo;
import top.fzqblog.po.model.ShuoShuoComment;
import top.fzqblog.po.model.ShuoShuoLike;

@Controller
public class ShuoShuoController extends BaseController {
	@Autowired
	private ShuoShuoService shuoShuoService;
	private Logger logger = LoggerFactory.getLogger(ShuoShuoController.class);
	@RequestMapping("shuoshuo")
	public ModelAndView ShuoShuo(){
		ModelAndView view = new ModelAndView("page/shuoshuo");
		return view;
	}
	
	@ResponseBody
	@RequestMapping("loadShuoShuos")
	public AjaxResponse<Object> loadShuoShuos(HttpSession session, int pageNum){
		AjaxResponse<Object> ajaxResponse = new AjaxResponse<Object>();
		ShuoShuoQuery shuoShuoQuery = new ShuoShuoQuery();
		shuoShuoQuery.setPageNum(pageNum);
		PageResult<ShuoShuo> pageResult = this.shuoShuoService.findShuoShuoList(shuoShuoQuery);
		ajaxResponse.setData(pageResult);
		return ajaxResponse;
	}
	
	@ResponseBody
	@RequestMapping("publicShuoShuo")
	public AjaxResponse<Object> publicShuoShuo(HttpSession session, ShuoShuo shuoShuo){
		AjaxResponse<Object> ajaxResponse = new AjaxResponse<Object>();
		SessionUser sessionUser = (SessionUser) session.getAttribute(Constants.SESSION_USER_KEY);
		if(sessionUser==null){
			ajaxResponse.setResponseCode(ResponseCode.BUSSINESSERROR);
			ajaxResponse.setErrorMsg("请先登录");
			return ajaxResponse;
		}
		try {
			this.setUserBaseInfo(ShuoShuo.class, shuoShuo, session);
			this.shuoShuoService.addShuoShuo(shuoShuo);
			ajaxResponse.setResponseCode(ResponseCode.SUCCESS);
			ajaxResponse.setData(shuoShuo);
		} catch (BussinessException e) {
			ajaxResponse.setResponseCode(ResponseCode.BUSSINESSERROR);
			ajaxResponse.setErrorMsg(e.getLocalizedMessage());
			logger.error("{}说说发表出错", shuoShuo.getUserName());
		}
		return ajaxResponse;
	}
	
	@ResponseBody
	@RequestMapping("publicShuoShuoComment")
	public AjaxResponse<Object> publicShuoShuo(HttpSession session, ShuoShuoComment shuoShuoComment){
		AjaxResponse<Object> ajaxResponse = new AjaxResponse<Object>();
		SessionUser sessionUser = (SessionUser) session.getAttribute(Constants.SESSION_USER_KEY);
		if(sessionUser==null){
			ajaxResponse.setResponseCode(ResponseCode.BUSSINESSERROR);
			ajaxResponse.setErrorMsg("请先登录");
			return ajaxResponse;
		}
		try {
			this.setUserBaseInfo(ShuoShuoComment.class, shuoShuoComment, session);
			this.shuoShuoService.addShuoShuoComment(shuoShuoComment);
			ajaxResponse.setResponseCode(ResponseCode.SUCCESS);
			ajaxResponse.setData(shuoShuoComment);
		} catch (BussinessException e) {
			ajaxResponse.setResponseCode(ResponseCode.BUSSINESSERROR);
			ajaxResponse.setErrorMsg(e.getLocalizedMessage());
			logger.error("{}评论出错", shuoShuoComment.getUserName());
		}
		return ajaxResponse;
	}
	
	@ResponseBody
	@RequestMapping("doShuoShuoLike")
	public AjaxResponse<Object> doShuoShuoLike(HttpSession session, ShuoShuoLike shuoShuoLike){
		AjaxResponse<Object> ajaxResponse = new AjaxResponse<Object>();
		SessionUser sessionUser = (SessionUser) session.getAttribute(Constants.SESSION_USER_KEY);
		if(sessionUser==null){
			ajaxResponse.setResponseCode(ResponseCode.BUSSINESSERROR);
			ajaxResponse.setErrorMsg("请先登录");
			return ajaxResponse;
		}
		this.setUserBaseInfo(ShuoShuoLike.class, shuoShuoLike, session);
		try {
			this.shuoShuoService.doShuoShuoLike(shuoShuoLike);
			ajaxResponse.setResponseCode(ResponseCode.SUCCESS);
			ajaxResponse.setData(shuoShuoLike);
		} catch (BussinessException e) {
			ajaxResponse.setResponseCode(ResponseCode.BUSSINESSERROR);
			ajaxResponse.setErrorMsg(e.getLocalizedMessage());
			logger.error("{}点赞出错", shuoShuoLike.getUserName());
		}
		return ajaxResponse;
	}
}

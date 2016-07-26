package top.fzqblog.filter;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import top.fzqblog.po.model.SessionUser;
import top.fzqblog.po.model.User;
import top.fzqblog.service.UserService;
import top.fzqblog.service.impl.UserServiceImpl;
import top.fzqblog.utils.Constants;
import top.fzqblog.utils.SpringContextUtil;

public class AuthorityFilter implements Filter {
	private Logger logger = LoggerFactory.getLogger(AuthorityFilter.class);

	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		Object sessionUserObj = session
				.getAttribute(Constants.SESSION_USER_KEY);
		// 自动登陆
		if (null == sessionUserObj) {
			autoLogin(req, resp);
			sessionUserObj = session.getAttribute(Constants.SESSION_USER_KEY);
		}
		chain.doFilter(request, response);
	}

	private void autoLogin(HttpServletRequest req, HttpServletResponse response) {
		try {
			Cookie cookieInfo = getCookieByName(req, Constants.COOKIE_USER_INFO);	
			if (cookieInfo != null) {
				String info = URLDecoder.decode(cookieInfo.getValue(), "utf-8");
				if (info != null && !"".equals(info)) {
					String infos[] = info.split("\\|");
					UserService userService = (UserServiceImpl) SpringContextUtil
							.getBean("userService");
					User user = userService.login(infos[0], infos[1],false);
					if (user != null) {
						SessionUser loginUser = new SessionUser();
						loginUser.setUserid(user.getUserid());
						loginUser.setUserName(user.getUserName());
						loginUser.setUserIcon(user.getUserIcon());
						req.getSession().setAttribute(
								Constants.SESSION_USER_KEY, loginUser);
					}
				}
			}
		} catch (Exception e) {
			// 清楚cookie信息
			Cookie cookie = new Cookie(Constants.COOKIE_USER_INFO, null);
			cookie.setMaxAge(0);
			cookie.setPath("/");
			response.addCookie(cookie);
			logger.error("自动登陆失败：", e);
		}

	}
	private Cookie  getCookieByName(HttpServletRequest req, String cookieName){
		Cookie[] cookies = req.getCookies();
		for(int i =0; i < cookies.length; i++){
			if(cookieName.equals(cookies[i].getName())){
				return new Cookie(cookies[i].getName(), cookies[i].getValue());
			}
		}
		return null;
	}
	public void destroy() {

	}

}

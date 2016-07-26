package top.fzqblog.service.impl;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.quartz.ee.jta.UserTransactionHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import top.fzqblog.po.model.User;
import top.fzqblog.service.UserService;

@Component
public class FormateAtService {
	
	@Autowired
	private UserService userService;
	private static String userUrl = "http://localhost:8091/user/";
	//private static Pattern referer_pattern = Pattern.compile("@.+?[\\s:]");@([^@\\s\\:\\;\\,\\\\.\\<\\?\\？\\{\\}\\&]{1,})
	private static Pattern referer_pattern = Pattern.compile("@([^@\\s\\:\\;\\,\\\\.\\<\\?\\？\\{\\}\\&]{1,})");//
	public String generateRefererLinks(String msg, Set<Integer> userIds){
		StringBuilder html = new StringBuilder();
		int lastIdx = 0;
		Matcher matcher = referer_pattern.matcher(msg);
		while (matcher.find()) {
			String origion_str = matcher.group();
			String userName = origion_str.substring(1, origion_str.length()).trim();
			html.append(msg.substring(lastIdx, matcher.start()));
			User user = this.userService.findUserByUserName(userName);
			if(null != user){
				html.append("<a href=\"" + userUrl + user.getUserid() + "\"  class=\"referer\"  target=\"_blank\">@");
				html.append(userName.trim());
				html.append("</a> ");
				userIds.add(user.getUserid());
			}
			else{
				html.append(origion_str);
			}
			lastIdx = matcher.end();
		}
		html.append(msg.substring(lastIdx));
		return html.toString();
	}
}

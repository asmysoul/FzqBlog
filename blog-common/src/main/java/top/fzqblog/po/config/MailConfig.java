package top.fzqblog.po.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
@Component
public class MailConfig {
	@Value("#{applicationProperties['fzqblog.top.sendUserName']}")
	private String sendUserName;
	
	@Value("#{applicationProperties['fzqblog.top.sendPassword']}")
	private String sendPassword;

	public String getSendUserName() {
		return sendUserName;
	}

	public void setSendUserName(String sendUserName) {
		this.sendUserName = sendUserName;
	}

	public String getSendPassword() {
		return sendPassword;
	}

	public void setSendPassword(String sendPassword) {
		this.sendPassword = sendPassword;
	}
	
	
}

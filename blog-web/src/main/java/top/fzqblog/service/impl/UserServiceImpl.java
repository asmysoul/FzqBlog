package top.fzqblog.service.impl;
import java.util.Date;
import java.util.List;















import org.apache.taglibs.standard.tag.rt.fmt.BundleTag;
import org.mortbay.jetty.security.UserRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.fzqblog.exception.BussinessException;
import top.fzqblog.mapper.UserMapper;
import top.fzqblog.po.config.MailConfig;
import top.fzqblog.po.model.User;
import top.fzqblog.po.query.UserQuery;
import top.fzqblog.service.UserService;
import top.fzqblog.utils.Constants;
import top.fzqblog.utils.MailUtils;
import top.fzqblog.utils.StringUtils;
@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper<User, UserQuery> userMapper;
	@Autowired
	private MailConfig mailConfig;
	public void register(User user) throws BussinessException {
		String userName = user.getUserName();
		String password = user.getPassword();
		String email = user.getEmail();
		if(StringUtils.isEmpty(userName) || StringUtils.isEmpty(email) || StringUtils.isEmpty(email)
				|| userName.length() < Constants.LENGTH_6 || userName.length() > Constants.LENGTH_20
				|| password.length() < Constants.LENGTH_6 || password.length() > Constants.LENGTH_16
				|| !StringUtils.isUserName(userName) || !StringUtils.isPassword(password)|| !StringUtils.isEmail(email)
				){
			throw new BussinessException("输入参数不合法");
		}
		if(this.findUserByUserName(userName) != null){
			throw new BussinessException("用户名已存在");
		}
		System.out.println(email);
		if(this.findUserByEmail(email) != null){
			throw new BussinessException("邮箱已存在");
		}
		Date date = new Date();
		user.setRegisterTime(date);
		user.setLastLoginTime(date);
		user.setUserIcon(StringUtils.getRandomUserIcon());
		//md5加密密码
		user.setPassword(StringUtils.encode(password));
		this.userMapper.insert(user);
	}

	public User findUserByUserName(String userName) {	
		UserQuery userQuery = new UserQuery();
		userQuery.setUserName(userName);
		List<User> userList = userMapper.selectList(userQuery);
		if(userList.size() == 1){
			return userList.get(0);
		}
		return null;
	}

	public User findUserByEmail(String email) {
		UserQuery userQuery = new UserQuery();
		userQuery.setEmail(email);
		List<User> userList = userMapper.selectList(userQuery);
		if(userList.size() == 1){
			return userList.get(0);
		}
		return null;
	}
	public User findUserByUserid(Integer userid) {
		UserQuery userQuery = new UserQuery();
		userQuery.setUserid(userid);
		List<User> userList = userMapper.selectList(userQuery);
		if(userList.size() == 1){
			return userList.get(0);
		}
		return null;
	}

	public User login(String account, String password)
			throws BussinessException {
		if(StringUtils.isEmpty(account) || StringUtils.isEmpty(password)){
			throw new BussinessException("输入参数不合法");
		}
		User user = null;
		if(account.contains("@")){
			user = this.findUserByEmail(account);
		}
		else {
			user = this.findUserByUserName(account);
		}
		if(user == null){
			throw new BussinessException("用户不存在");
		}
		if(!StringUtils.encode(password).equals(user.getPassword())){
			throw new BussinessException("密码错误");
		}
		return user;
	}
	public User login(String account, String password,boolean isNeedEncoder)
			throws BussinessException {
		if(StringUtils.isEmpty(account) || StringUtils.isEmpty(password)){
			throw new BussinessException("输入参数不合法");
		}
		User user = null;
		if(account.contains("@")){
			user = this.findUserByEmail(account);
		}
		else {
			user = this.findUserByUserName(account);
		}
		if(user == null){
			throw new BussinessException("用户不存在");
		}
		if(isNeedEncoder){
			if(!StringUtils.encode(password).equals(user.getPassword())){
				throw new BussinessException("密码错误");
			}
		}
		else{
			if(!password.equals(user.getPassword())){
				throw new BussinessException("密码错误");
			}
		}
		return user;
	}

	public void sendCheckCode(String email) throws BussinessException {
			if(StringUtils.isEmpty(email) || !StringUtils.isEmail(email)){
				throw new BussinessException("输入参数不合法");
			}
			User user = this.findUserByEmail(email);
			
			if(user == null){
				throw new BussinessException("邮箱不存在");
			}
			
			String checkCode = StringUtils.getActivationCode(6);
			
			String subject = "FZQBLOG邮件";
			
			StringBuffer content = new StringBuffer("亲爱的" + user.getUserName() + "用户<br><br>");
			content.append("欢迎您使用<a href='http://localhost:8091/index'>FZQBLOG</a>的找回密码功能<br><br>");
			content.append("您的验证码是<h3 style='color:red;'>" + checkCode + "</h3>");
			try {
				MailUtils.sendMail(mailConfig.getSendUserName(), mailConfig.getSendPassword(), email,
						subject, new String(content));
			} catch (Exception e) {
				throw new BussinessException("发送邮件失败,请稍后再试");
			}
			user.setActivationCode(checkCode);
			this.userMapper.update(user);
	}

	public void modifyPassword(String email, String password, String checkcode) throws BussinessException {
		if(StringUtils.isEmpty(email) || StringUtils.isEmpty(password) || StringUtils.isEmpty(checkcode) ||
				 password.length() < Constants.LENGTH_6 || password.length() > Constants.LENGTH_16				
				){
				throw new BussinessException("输入参数不合法");
		}
		User user = this.findUserByEmail(email);
		if(user == null){
			throw new BussinessException("邮箱不存在");
		}
		if(!checkcode.equalsIgnoreCase(user.getActivationCode())){
			throw new BussinessException("验证码错误");
		}
		user.setPassword(password);
		this.userMapper.update(user);	
	}

	public void addMark(int mark, int userid) {
		User user = this.findUserByUserid(userid);
		user.setMark(user.getMark() + mark);
		this.userMapper.update(user);		
	}

}

package top.fzqblog.service.impl;
import java.util.Date;
import java.util.List;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.fzqblog.exception.BussinessException;
import top.fzqblog.mapper.UserMapper;
import top.fzqblog.po.model.User;
import top.fzqblog.po.query.UserQuery;
import top.fzqblog.service.UserService;
import top.fzqblog.utils.Constants;
import top.fzqblog.utils.StringUtils;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper<User, UserQuery> userMapper;
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

}

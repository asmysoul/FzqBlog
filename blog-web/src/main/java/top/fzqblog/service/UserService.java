package top.fzqblog.service;

import top.fzqblog.exception.BussinessException;
import top.fzqblog.po.model.User;

public interface UserService {
	public void register(User user) throws BussinessException;
	
	public User findUserByUserName(String userName);
	
	public User findUserByEmail(String email);
	public User findUserByUserid(Integer userid);
	
	public User login(String account, String password) throws BussinessException;
	public User login(String account, String password,boolean isNeedEncoder) throws BussinessException;
	public void sendCheckCode(String email) throws BussinessException;
	
	public void modifyPassword(String email, String password, String checkcode) throws BussinessException;
	
	public void addMark(int mark, int userid);
	
}

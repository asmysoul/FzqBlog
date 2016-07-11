package top.fzqblog.service;

import top.fzqblog.exception.BussinessException;
import top.fzqblog.po.model.User;

public interface UserService {
	public void register(User user) throws BussinessException;
	
	public User findUserByUserName(String userName);
	
	public User findUserByEmail(String email);
	
}

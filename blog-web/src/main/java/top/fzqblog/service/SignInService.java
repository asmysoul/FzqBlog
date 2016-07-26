package top.fzqblog.service;

import top.fzqblog.exception.BussinessException;
import top.fzqblog.po.model.SessionUser;
import top.fzqblog.po.model.SignIn;
import top.fzqblog.po.model.SignInfo;

public interface SignInService {
	public SignInfo findSignInfoByUserid(Integer userid);
	
	public SignIn doSignIn(SessionUser sessionUser)throws BussinessException;
}

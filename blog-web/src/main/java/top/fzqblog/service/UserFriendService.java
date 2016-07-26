package top.fzqblog.service;

import top.fzqblog.po.model.UserFriend;
import top.fzqblog.po.query.UserFriendQuery;
import top.fzqblog.utils.PageResult;



public interface UserFriendService {
	/**
	 * 
	 * @param userFriendQuery
	 * @return关注的用户
	 */
	public PageResult<UserFriend> findFriendList(UserFriendQuery userFriendQuery);
}

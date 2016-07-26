package top.fzqblog.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.fzqblog.mapper.UserFriendMapper;
import top.fzqblog.po.enums.PageSize;
import top.fzqblog.po.model.UserFriend;
import top.fzqblog.po.query.UserFriendQuery;
import top.fzqblog.service.UserFriendService;
import top.fzqblog.utils.Page;
import top.fzqblog.utils.PageResult;
@Service
public class UserFriendServiceImpl implements UserFriendService {
	@Autowired
	private UserFriendMapper<UserFriend, UserFriendQuery> userFriendMapper;
	
	public PageResult<UserFriend>  findFriendList(
			UserFriendQuery userFriendQuery) {
		int count = this.userFriendMapper.selectCount(userFriendQuery);
		int size = PageSize.PAGE_SIZE21.getSize();
		int pageNum = 1;
		if(userFriendQuery.getPageNum() > 1){
			pageNum = userFriendQuery.getPageNum();
		}
		Page page = new Page(pageNum, count, size);
		userFriendQuery.setPage(page);
		List<UserFriend> list = this.userFriendMapper.selectList(userFriendQuery);
		return new PageResult<UserFriend>(page,	 list);
	}

}

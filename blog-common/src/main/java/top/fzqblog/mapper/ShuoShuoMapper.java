package top.fzqblog.mapper;



import java.util.List;

import top.fzqblog.po.query.ShuoShuoQuery;

public interface ShuoShuoMapper<T, Q> extends BaseMapper<T, Q> {
	public void updateShuoShuoCommentCount(Integer id);
	
	public void updateShuoShuoLikeCount(Integer id);
	
	public List<T> selectActiveUser4ShuoShuo(ShuoShuoQuery shuoShuoQuery);
		
}
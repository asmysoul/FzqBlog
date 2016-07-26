package top.fzqblog.mapper;

import java.util.List;

import top.fzqblog.po.model.ShuoShuoLike;




public interface ShuoShuoLikeMapper<T, Q> extends BaseMapper<T, Q> {
	public List<ShuoShuoLike> selectListByShuoShuoId(Integer shuoshuoId);
}
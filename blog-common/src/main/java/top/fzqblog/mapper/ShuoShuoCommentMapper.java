package top.fzqblog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import top.fzqblog.po.model.ShuoShuoComment;

public interface ShuoShuoCommentMapper<T, Q> extends BaseMapper<T, Q>{
	public List<ShuoShuoComment> selectListByShuoShuoId(Integer shuoshuoId);//@Param("shuoShuoId") Integer shuoShuoId
}
package top.fzqblog.service;

import java.util.List;

import top.fzqblog.exception.BussinessException;
import top.fzqblog.po.model.ShuoShuo;
import top.fzqblog.po.model.ShuoShuoComment;
import top.fzqblog.po.model.ShuoShuoLike;
import top.fzqblog.po.query.ShuoShuoQuery;
import top.fzqblog.utils.PageResult;

public interface ShuoShuoService {
	
	/**
	 * 添加说说
	 */
	public void addShuoShuo(ShuoShuo shuoShuo)throws BussinessException;
	
	
	/**
	 * 查找说说
	 */
	public ShuoShuo findShuoShuo(Integer userid, int id);
	/**
	 * 分页搜索说说
	 * @param shuoShuoQuery
	 * @return
	 */
	public PageResult<ShuoShuo> findShuoShuoList(ShuoShuoQuery shuoShuoQuery);
	
	/**
	 * 添加评论
	 * @param shuoShuoComment
	 * @throws BussinessException
	 */
	public void addShuoShuoComment(ShuoShuoComment shuoShuoComment)throws BussinessException;
	
	/**
	 * 加载说说评论
	 * @param shuoShuoId
	 * @return
	 */
	public List<ShuoShuoComment> loadShuoShuoComment(Integer shuoShuoId);
	
	/**
	 * 查找活跃用户
	 * @return
	 */
	public List<ShuoShuo> findActiveUser4ShuoShuo();
	
	/**
	 *点赞
	 * @throws BussinessException
	 */
	public void doShuoShuoLike(ShuoShuoLike shuoShuoLike)throws BussinessException;
	
	/**
	 * 查找说说的点赞
	 * @param shuoShuoLike
	 */
	public List<ShuoShuoLike> findShuoShuoLike(ShuoShuoQuery shuoShuoQuery);
	
 }

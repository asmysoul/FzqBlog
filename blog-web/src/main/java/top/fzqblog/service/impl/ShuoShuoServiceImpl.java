package top.fzqblog.service.impl;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import top.fzqblog.exception.BussinessException;
import top.fzqblog.mapper.ShuoShuoCommentMapper;
import top.fzqblog.mapper.ShuoShuoLikeMapper;
import top.fzqblog.mapper.ShuoShuoMapper;
import top.fzqblog.po.enums.MarkEnum;
import top.fzqblog.po.enums.PageSize;
import top.fzqblog.po.enums.TextLengthEnum;
import top.fzqblog.po.model.ShuoShuo;
import top.fzqblog.po.model.ShuoShuoComment;
import top.fzqblog.po.model.ShuoShuoLike;
import top.fzqblog.po.query.ShuoShuoQuery;
import top.fzqblog.service.ShuoShuoService;
import top.fzqblog.service.UserService;
import top.fzqblog.utils.ImageUtils;
import top.fzqblog.utils.Page;
import top.fzqblog.utils.PageResult;
import top.fzqblog.utils.StringUtils;
@Service
public class ShuoShuoServiceImpl implements ShuoShuoService {
	@Autowired
	private ShuoShuoMapper<ShuoShuo, ShuoShuoQuery> shuoShuoMapper;
	
	@Autowired
	private ShuoShuoCommentMapper<ShuoShuoComment, ShuoShuoQuery> shuoShuoCommentMapper;
	
	@Autowired
	private ShuoShuoLikeMapper<ShuoShuoLike, ShuoShuoQuery> shuoShuoLikeMapper;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private FormateAtService formateAtService;
	
	@Transactional(propagation=Propagation.REQUIRES_NEW, rollbackFor=BussinessException.class)
	public void addShuoShuo(ShuoShuo shuoShuo) throws BussinessException {
		String content = shuoShuo.getContent();
		if(StringUtils.isEmpty(content) || content.length() > TextLengthEnum.TEXT.getLength()){
			throw new BussinessException("参数错误");
		}
		content = StringUtils.addLink(content);//给网页加链接
		Set<Integer> userIdSet = new HashSet<Integer>();
		String formatContent = formateAtService.generateRefererLinks(content, userIdSet);
		//TODO给用户发消息
		String thumnail = ImageUtils.createThumbnail(shuoShuo.getImageUrl(), false);
		shuoShuo.setImageUrlSmall(thumnail);
		shuoShuo.setContent(formatContent);
		shuoShuo.setCreateTime(new Date());
		shuoShuo.setLikeCount(0);
		shuoShuo.setCommentCount(0);
		this.shuoShuoMapper.insert(shuoShuo);
		this.userService.addMark(MarkEnum.MARK_SHUOSHUO.getMark(), shuoShuo.getUserId());
	}

	public ShuoShuo findShuoShuo(Integer userid, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional(propagation=Propagation.REQUIRES_NEW, rollbackFor=BussinessException.class)
	public void addShuoShuoComment(ShuoShuoComment shuoShuoComment)
			throws BussinessException {
		String content = shuoShuoComment.getContent();
		if(StringUtils.isEmpty(content) || content.length() > TextLengthEnum.TEXT.getLength()){
			throw new BussinessException("参数错误");
		}
		content = StringUtils.addLink(content);//给网页加链接
		Set<Integer> userIdSet = new HashSet<Integer>();
		String formatContent = formateAtService.generateRefererLinks(content, userIdSet);
		//TODO给用户发消息
		shuoShuoComment.setContent(formatContent);
		shuoShuoComment.setCreateTime(new Date());
		this.shuoShuoMapper.updateShuoShuoCommentCount(shuoShuoComment.getShuoshuoId());
		this.shuoShuoCommentMapper.insert(shuoShuoComment);
		this.userService.addMark(MarkEnum.MARK_COMMENT.getMark(), shuoShuoComment.getUserId());		
	}

	public List<ShuoShuoComment> loadShuoShuoComment(Integer shuoShuoId) {
		// TODO 用来加载说说的评论
		return null;
	}

	public List<ShuoShuo> findActiveUser4ShuoShuo() {
		// TODO 加载活跃用户
		return null;
	}

	public PageResult<ShuoShuo> findShuoShuoList(ShuoShuoQuery shuoShuoQuery) {
		int count = this.shuoShuoMapper.selectCount(shuoShuoQuery);
		int size = PageSize.PAGE_SIZE10.getSize();
		int pageNum = 1;
		if(shuoShuoQuery.getPageNum() != 1){
			pageNum = shuoShuoQuery.getPageNum();
		}
		Page page = new Page(pageNum, count, size);
		shuoShuoQuery.setPage(page);
		List<ShuoShuo> shuoShuos = this.shuoShuoMapper.selectList(shuoShuoQuery);
		return new PageResult<ShuoShuo>(page, shuoShuos);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW, rollbackFor=BussinessException.class)
	public void doShuoShuoLike(ShuoShuoLike shuoShuoLike) throws BussinessException {
		ShuoShuoQuery shuoShuoQuery = new ShuoShuoQuery();
		shuoShuoQuery.setUserId(shuoShuoLike.getUserId());
		System.out.println(shuoShuoQuery.getShuoShuoId());
		shuoShuoQuery.setShuoShuoId(shuoShuoLike.getShuoshuoId());
		if(this.findShuoShuoLike(shuoShuoQuery).size() >= 1){
			throw new BussinessException("您已经点过赞了");
		}
		shuoShuoLike.setCreateTime(new Date());
		this.shuoShuoMapper.updateShuoShuoLikeCount(shuoShuoLike.getShuoshuoId());
		this.shuoShuoLikeMapper.insert(shuoShuoLike);
	}

	public List<ShuoShuoLike> findShuoShuoLike(ShuoShuoQuery shuoShuoQuery) {
		List<ShuoShuoLike> shuoShuoLikeList = this.shuoShuoLikeMapper.selectList(shuoShuoQuery);
		System.out.println(shuoShuoLikeList);
		return shuoShuoLikeList;
	}

}

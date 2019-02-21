package com.xian.hkx.gxzx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xian.hkx.gxzx.entities.Reply;

public interface ReplyDao {
	
	/**
	 * 根据页数和bbsid获取回复评论信息
	 * @param bbsid
	 * @param pagenum
	 * @param pagesize
	 * @return List<Reply>
	 */
	public List<Reply> getReply(@Param("bbsid")int bbsid, @Param("pagenum")int pagenum, @Param("pagesize")int pagesize);
	
	/**
	 * 新增评论
	 * @param reply
	 * @return int
	 */
	public int addReply(Reply reply);
	
	/**
	 * 根据帖子ID删除所属评论
	 * @param bbsid
	 * @return int
	 */
	public int deleteReply(@Param("bbsid")int bbsid);

}

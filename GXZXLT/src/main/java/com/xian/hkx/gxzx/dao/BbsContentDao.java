package com.xian.hkx.gxzx.dao;

import org.apache.ibatis.annotations.Param;

import com.xian.hkx.gxzx.entities.BbsContent;

public interface BbsContentDao {
	
	/**
	 * 新增帖子内容 
	 * @param bbsContent
	 * @return int
	 */
	public int addBbsContent(BbsContent bbsContent);
	
	/**
	 *  根据BbdID获取内容
	 * @param bbsid
	 * @return BbsContent
	 */
	public BbsContent getBbsContent(@Param("bbsid")int bbsid);
	
	/**
	 * 删除帖子内容
	 * @param bbsid
	 * @return int
	 */
	public int deleteContent(@Param("bbsid")int bbsid);

}

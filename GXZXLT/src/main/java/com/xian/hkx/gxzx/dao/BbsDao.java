package com.xian.hkx.gxzx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xian.hkx.gxzx.entities.Bbs;

public interface BbsDao {
	
	/**
	 * 根据页数获取本业所有的帖子 
	 * @param pageno 页数
	 * @param pagesize 每页的数据量
	 * @return List<Bbs>
	 */
	public List<Bbs> getAllBbss(@Param("pageno")int pageno, @Param("pagesize")int pagesize);
	
	/**
	 * 根据职员ID和页数获取本业所有的帖子 
	 * @param pageno
	 * @param pagesize
	 * @param userid
	 * @return List<Bbs>
	 */
	public List<Bbs> getAllBbssByUserid(@Param("pageno")int pageno, @Param("pagesize")int pagesize, @Param("userid")int userid);
	
	/**
	 * 获取被顶置的帖子 
	 * @return List<Bbs>
	 */
	public List<Bbs> getOverHeadBbss();
	
	/**
	 * 获取总帖子的数量 
	 * @return int
	 */
	public int getCountOfAllBbs();
	
	/**
	 *  根据职员ID获取总帖子的数量 
	 * @param userid
	 * @return int
	 */
	public int getCountOfAllBbsByUserid(@Param("userid")int userid);
	
	/**
  	 * 新增帖子
	 * @param bbs
	 * @return int
	 */
	public int addBbs(Bbs bbs);
	
	/**
	 *  根据ID获取帖子
	 * @param id
	 * @return Bbs
	 */
	public Bbs getBbsById(@Param("id")int id);
	
	/**
	 * 更新帖子
	 * @param bbs
	 * @return int
	 */
	public int updateBbs(Bbs bbs);
	
	/**
	 * 删除帖子
	 * @param bbsid
	 * @return int
	 */
	public int deleteBbs(@Param("id")int bbsid);
	

}

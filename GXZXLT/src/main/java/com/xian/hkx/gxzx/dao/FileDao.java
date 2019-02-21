package com.xian.hkx.gxzx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xian.hkx.gxzx.entities.Files;

public interface FileDao {
	/**
	 * 获取所有文档(按照时间从大到小) 
	 * @return List<File>
	 */
	public List<Files> getAllFiles();
	
	/**
	 * 获取所有文档(按照下载次数从大到小)
	 * @return List<File>
	 */
	public List<Files> getAllFilesByDownCount();
	
	/**
	 * 根据职员ID和分页参数获取指定页数的数据
	 * @param pageno
	 * @param pagesize
	 * @param userid
	 * @return List<File>
	 */
	public List<Files> getAllFilesByUserid(@Param("pageno")int pageno, @Param("pagesize")int pagesize, @Param("userid")int userid);
	
	/**
	 * 根据页数获取本页的所有数据
	 * @param pageno
	 * @param pagesize
	 * @return List<File>
	 */
	public List<Files> getAllFilesByPagenum(@Param("pageno")int pageno, @Param("pagesize")int pagesize);
	
	/**
	 * 根据userid获取文档
	 * @param userid
	 * @return List<File>
	 */
	public List<Files> getFilesByUserId(@Param("userid")int userid);
	
	/**
	 * 根据ID获取文档
	 * @param id
	 * @return File
	 */
	public Files getFile(@Param("gid")int id);
	
	/**
	 * 新增文档
	 * @param file
	 * @return int
	 */
	public int addFile(Files file);
	
	/**
	 * 删除文档
	 * @param id
	 * @return int
	 */
	public int deleteFile(@Param("did")int id);
	
	/**
	 * 根据职员ID获取获取文档数量
	 * @param userid
	 * @return int
	 */
	public int getCountFileByUserid(@Param("userid")int userid);
	
	/**
	 * 获取文档的数据量
	 * @return int
	 */
	public int getCountFiles();
	
	/**
	 *  更新文档信息
	 * @param files
	 * @return int
	 */
	public int updateFile(Files files);

}

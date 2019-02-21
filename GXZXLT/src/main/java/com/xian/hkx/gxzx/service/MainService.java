package com.xian.hkx.gxzx.service;

import java.util.List;
import java.util.Map;

import com.xian.hkx.gxzx.entities.Files;

public interface MainService {
	/**
	 * 获取所有文档
	 * @return List<File>
	 */
	public List<Files> getAllFiles();
	
	/**
	 * 获取最新上传的五个文档 
	 * @return List<File>
	 */
	public List<Files> getNewFiles();
	
	/**
	 * 获取下载次数最多的五个文档
	 * @return List<File>
	 */
	public List<Files> getDownMaxFiles();
	
	/**
	 * 根据页数获取本页所有的帖子 
	 * @return List<Bbs>
	 */
	public List<Map<String, String>> getAllBbss(int pageno);
	
	/**
   	 * 获取所有帖子的页数
	 * @return int
	 */
	public int getCountBbs();
	
	/**
	 * 根据职员ID和页数获取本页所有的帖子 
	 * @param pageno
	 * @param userid
	 * @return List<Map<String,String>>
	 */
	public List<Map<String, String>> getAllBbssByUserid(int pageno, int userid);
	
	
	/**
	 * 根据职员ID和页数获取本页所有的文档
	 * @param pageno
	 * @param userid
	 * @return List<Map<String,String>>
	 */
	public List<Map<String,String>> getAllFilesByUserid(int pageno, int userid);
	
	/**
	 * 根据页数获取本页所有的帖子 
	 * @param pageno
	 * @return List<Map<String,String>>
	 */
	public List<Map<String, String>> getAllFiles(int pageno);
	
	/**
	 * 新增帖子
	 * @param userid
	 * @param title
	 * @param content
	 * @return int
	 */
	public int addBbs(int userid, String title, String content);
	
	/**
	 * 根据用户ID修改用户密码
	 * @param userid
	 * @param password
	 * @return int
	 */
	public int changePwd(int userid, String password);
	
	/**
	 * 根据页数获取人员信息 
	 * @param pageno
	 * @return List<Map<String,String>>
	 */
	public List<Map<String, String>> getAllUsers(int pageno);
	
	/**
	 * 新增用户
	 * @param loginname
	 * @param username
	 * @param password
	 * @return int
	 */
	public int addUser(String loginname, String username, String password);
	
	/**
	 *  根据文件ID获取指定样式的文件信息
	 * @param fileId
	 * @return Map<String,String>
	 */
	public Map<String, String> getFileByFileId(int fileId);
	
	/**
	 *  根据ID获取帖子所有内容
	 * @param id
	 * @return List<Map<String,String>>
	 */
	public Map<String, String> getBbsContent(int id);
	
	/**
	 * 根据页数和BBSID获取评论信息
	 * @param pageno
	 * @param bbsid
	 * @return List<Map<String,String>>
	 */
	public List<Map<String, String>> getReply(int pageno, int bbsid);
	
	/**
	 * 新增评论
	 * @param bbsid
	 * @param userid
	 * @param content
	 * @return int
	 */
	public int addReply(int bbsid, int userid, String content);
	
	/**
	 * 删除帖子
	 * @param bbsid
	 * @return int
	 */
	public int deleteBbs(int bbsid);
	
	/**
	 * 根据用户ID获取用户信息 
	 * @param userid
	 * @return Map<String,String>
	 */
	public Map<String, String> getUserById(int userid);
	
	/**
	 * 更新用户信息 
	 * @param userid
	 * @param loginname
	 * @param username
	 * @param password
	 * @return int
	 */
	public int upDateUser(int userid, String loginname, String username, String password, int type);
	
	/**
	 * 根据用户ID删除用户
	 * @param userid
	 * @return int
	 */
	public int deleteUser(int userid);

}

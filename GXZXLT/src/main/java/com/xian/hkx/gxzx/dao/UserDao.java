package com.xian.hkx.gxzx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xian.hkx.gxzx.entities.User;
/**
 * 
 * <p>用户Mapper映射器</p>
 *
 * <p>Copyright: 版权所有 (c) 2002 - 2008<br>
 * Company: 久其</p>
 *
 * @author hekaixian
 * @version 2019年1月3日
 */
public interface UserDao {
	/**
	 * 获取所有用户数量
	 * @return List<User>
	 */
	public int getAllUsersCount();

	/**
	 * 根据登录名和密码获取用户 
	 * @param loginname
	 * @param password
	 * @return User
	 */
	public User getUserByNameAndpwd(@Param("loginname")String loginname, @Param("password")String password);
	
	/**
	 * 新增用户 
	 * @param user
	 * @return int
	 */
	public int addUser(User user);
	
	/**
	 * 根据用户ID删除用户 
	 * @param id
	 * @return int
	 */
	public int deleteUser(@Param("id")int id);
	
	/**
	 * 更新用户 
	 * @param user
	 * @return int
	 */
	public int updateUser(User user);
	
	/**
	 * 根据用户ID获取用户
	 * @param id
	 * @return User
	 */
	public User getUserById(@Param("id")int id);
	
	/**
	 * 根据用户ID修改用户密码
	 * @param id
	 * @param pwd
	 * @return int
	 */
	public int updatePwdById(@Param("id")int id, @Param("password")String pwd);
	
	/**
	 * 根据页数来获取用户 
	 * @param pageno
	 * @param pagesize
	 * @return List<User>
	 */
	public List<User> getAllUserByPageno(@Param("pageno")int pageno, @Param("pagesize")int pagesize);
	
	/**
	 * 根据登录名获取用户 
	 * @param loginname
	 * @return User
	 */
	public User getUserByLoginname(@Param("loginname")String loginname);
	
}

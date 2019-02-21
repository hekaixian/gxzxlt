package com.xian.hkx.gxzx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xian.hkx.gxzx.entities.User;
/**
 * 
 * <p>�û�Mapperӳ����</p>
 *
 * <p>Copyright: ��Ȩ���� (c) 2002 - 2008<br>
 * Company: ����</p>
 *
 * @author hekaixian
 * @version 2019��1��3��
 */
public interface UserDao {
	/**
	 * ��ȡ�����û�����
	 * @return List<User>
	 */
	public int getAllUsersCount();

	/**
	 * ���ݵ�¼���������ȡ�û� 
	 * @param loginname
	 * @param password
	 * @return User
	 */
	public User getUserByNameAndpwd(@Param("loginname")String loginname, @Param("password")String password);
	
	/**
	 * �����û� 
	 * @param user
	 * @return int
	 */
	public int addUser(User user);
	
	/**
	 * �����û�IDɾ���û� 
	 * @param id
	 * @return int
	 */
	public int deleteUser(@Param("id")int id);
	
	/**
	 * �����û� 
	 * @param user
	 * @return int
	 */
	public int updateUser(User user);
	
	/**
	 * �����û�ID��ȡ�û�
	 * @param id
	 * @return User
	 */
	public User getUserById(@Param("id")int id);
	
	/**
	 * �����û�ID�޸��û�����
	 * @param id
	 * @param pwd
	 * @return int
	 */
	public int updatePwdById(@Param("id")int id, @Param("password")String pwd);
	
	/**
	 * ����ҳ������ȡ�û� 
	 * @param pageno
	 * @param pagesize
	 * @return List<User>
	 */
	public List<User> getAllUserByPageno(@Param("pageno")int pageno, @Param("pagesize")int pagesize);
	
	/**
	 * ���ݵ�¼����ȡ�û� 
	 * @param loginname
	 * @return User
	 */
	public User getUserByLoginname(@Param("loginname")String loginname);
	
}

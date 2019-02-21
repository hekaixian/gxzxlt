package com.xian.hkx.gxzx.service;

import java.util.List;
import java.util.Map;

import com.xian.hkx.gxzx.entities.Files;

public interface MainService {
	/**
	 * ��ȡ�����ĵ�
	 * @return List<File>
	 */
	public List<Files> getAllFiles();
	
	/**
	 * ��ȡ�����ϴ�������ĵ� 
	 * @return List<File>
	 */
	public List<Files> getNewFiles();
	
	/**
	 * ��ȡ���ش�����������ĵ�
	 * @return List<File>
	 */
	public List<Files> getDownMaxFiles();
	
	/**
	 * ����ҳ����ȡ��ҳ���е����� 
	 * @return List<Bbs>
	 */
	public List<Map<String, String>> getAllBbss(int pageno);
	
	/**
   	 * ��ȡ�������ӵ�ҳ��
	 * @return int
	 */
	public int getCountBbs();
	
	/**
	 * ����ְԱID��ҳ����ȡ��ҳ���е����� 
	 * @param pageno
	 * @param userid
	 * @return List<Map<String,String>>
	 */
	public List<Map<String, String>> getAllBbssByUserid(int pageno, int userid);
	
	
	/**
	 * ����ְԱID��ҳ����ȡ��ҳ���е��ĵ�
	 * @param pageno
	 * @param userid
	 * @return List<Map<String,String>>
	 */
	public List<Map<String,String>> getAllFilesByUserid(int pageno, int userid);
	
	/**
	 * ����ҳ����ȡ��ҳ���е����� 
	 * @param pageno
	 * @return List<Map<String,String>>
	 */
	public List<Map<String, String>> getAllFiles(int pageno);
	
	/**
	 * ��������
	 * @param userid
	 * @param title
	 * @param content
	 * @return int
	 */
	public int addBbs(int userid, String title, String content);
	
	/**
	 * �����û�ID�޸��û�����
	 * @param userid
	 * @param password
	 * @return int
	 */
	public int changePwd(int userid, String password);
	
	/**
	 * ����ҳ����ȡ��Ա��Ϣ 
	 * @param pageno
	 * @return List<Map<String,String>>
	 */
	public List<Map<String, String>> getAllUsers(int pageno);
	
	/**
	 * �����û�
	 * @param loginname
	 * @param username
	 * @param password
	 * @return int
	 */
	public int addUser(String loginname, String username, String password);
	
	/**
	 *  �����ļ�ID��ȡָ����ʽ���ļ���Ϣ
	 * @param fileId
	 * @return Map<String,String>
	 */
	public Map<String, String> getFileByFileId(int fileId);
	
	/**
	 *  ����ID��ȡ������������
	 * @param id
	 * @return List<Map<String,String>>
	 */
	public Map<String, String> getBbsContent(int id);
	
	/**
	 * ����ҳ����BBSID��ȡ������Ϣ
	 * @param pageno
	 * @param bbsid
	 * @return List<Map<String,String>>
	 */
	public List<Map<String, String>> getReply(int pageno, int bbsid);
	
	/**
	 * ��������
	 * @param bbsid
	 * @param userid
	 * @param content
	 * @return int
	 */
	public int addReply(int bbsid, int userid, String content);
	
	/**
	 * ɾ������
	 * @param bbsid
	 * @return int
	 */
	public int deleteBbs(int bbsid);
	
	/**
	 * �����û�ID��ȡ�û���Ϣ 
	 * @param userid
	 * @return Map<String,String>
	 */
	public Map<String, String> getUserById(int userid);
	
	/**
	 * �����û���Ϣ 
	 * @param userid
	 * @param loginname
	 * @param username
	 * @param password
	 * @return int
	 */
	public int upDateUser(int userid, String loginname, String username, String password, int type);
	
	/**
	 * �����û�IDɾ���û�
	 * @param userid
	 * @return int
	 */
	public int deleteUser(int userid);

}

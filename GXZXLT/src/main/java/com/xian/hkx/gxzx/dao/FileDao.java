package com.xian.hkx.gxzx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xian.hkx.gxzx.entities.Files;

public interface FileDao {
	/**
	 * ��ȡ�����ĵ�(����ʱ��Ӵ�С) 
	 * @return List<File>
	 */
	public List<Files> getAllFiles();
	
	/**
	 * ��ȡ�����ĵ�(�������ش����Ӵ�С)
	 * @return List<File>
	 */
	public List<Files> getAllFilesByDownCount();
	
	/**
	 * ����ְԱID�ͷ�ҳ������ȡָ��ҳ��������
	 * @param pageno
	 * @param pagesize
	 * @param userid
	 * @return List<File>
	 */
	public List<Files> getAllFilesByUserid(@Param("pageno")int pageno, @Param("pagesize")int pagesize, @Param("userid")int userid);
	
	/**
	 * ����ҳ����ȡ��ҳ����������
	 * @param pageno
	 * @param pagesize
	 * @return List<File>
	 */
	public List<Files> getAllFilesByPagenum(@Param("pageno")int pageno, @Param("pagesize")int pagesize);
	
	/**
	 * ����userid��ȡ�ĵ�
	 * @param userid
	 * @return List<File>
	 */
	public List<Files> getFilesByUserId(@Param("userid")int userid);
	
	/**
	 * ����ID��ȡ�ĵ�
	 * @param id
	 * @return File
	 */
	public Files getFile(@Param("gid")int id);
	
	/**
	 * �����ĵ�
	 * @param file
	 * @return int
	 */
	public int addFile(Files file);
	
	/**
	 * ɾ���ĵ�
	 * @param id
	 * @return int
	 */
	public int deleteFile(@Param("did")int id);
	
	/**
	 * ����ְԱID��ȡ��ȡ�ĵ�����
	 * @param userid
	 * @return int
	 */
	public int getCountFileByUserid(@Param("userid")int userid);
	
	/**
	 * ��ȡ�ĵ���������
	 * @return int
	 */
	public int getCountFiles();
	
	/**
	 *  �����ĵ���Ϣ
	 * @param files
	 * @return int
	 */
	public int updateFile(Files files);

}

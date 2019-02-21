package com.xian.hkx.gxzx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xian.hkx.gxzx.entities.Bbs;

public interface BbsDao {
	
	/**
	 * ����ҳ����ȡ��ҵ���е����� 
	 * @param pageno ҳ��
	 * @param pagesize ÿҳ��������
	 * @return List<Bbs>
	 */
	public List<Bbs> getAllBbss(@Param("pageno")int pageno, @Param("pagesize")int pagesize);
	
	/**
	 * ����ְԱID��ҳ����ȡ��ҵ���е����� 
	 * @param pageno
	 * @param pagesize
	 * @param userid
	 * @return List<Bbs>
	 */
	public List<Bbs> getAllBbssByUserid(@Param("pageno")int pageno, @Param("pagesize")int pagesize, @Param("userid")int userid);
	
	/**
	 * ��ȡ�����õ����� 
	 * @return List<Bbs>
	 */
	public List<Bbs> getOverHeadBbss();
	
	/**
	 * ��ȡ�����ӵ����� 
	 * @return int
	 */
	public int getCountOfAllBbs();
	
	/**
	 *  ����ְԱID��ȡ�����ӵ����� 
	 * @param userid
	 * @return int
	 */
	public int getCountOfAllBbsByUserid(@Param("userid")int userid);
	
	/**
  	 * ��������
	 * @param bbs
	 * @return int
	 */
	public int addBbs(Bbs bbs);
	
	/**
	 *  ����ID��ȡ����
	 * @param id
	 * @return Bbs
	 */
	public Bbs getBbsById(@Param("id")int id);
	
	/**
	 * ��������
	 * @param bbs
	 * @return int
	 */
	public int updateBbs(Bbs bbs);
	
	/**
	 * ɾ������
	 * @param bbsid
	 * @return int
	 */
	public int deleteBbs(@Param("id")int bbsid);
	

}

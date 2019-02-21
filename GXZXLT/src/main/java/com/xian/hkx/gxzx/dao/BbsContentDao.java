package com.xian.hkx.gxzx.dao;

import org.apache.ibatis.annotations.Param;

import com.xian.hkx.gxzx.entities.BbsContent;

public interface BbsContentDao {
	
	/**
	 * ������������ 
	 * @param bbsContent
	 * @return int
	 */
	public int addBbsContent(BbsContent bbsContent);
	
	/**
	 *  ����BbdID��ȡ����
	 * @param bbsid
	 * @return BbsContent
	 */
	public BbsContent getBbsContent(@Param("bbsid")int bbsid);
	
	/**
	 * ɾ����������
	 * @param bbsid
	 * @return int
	 */
	public int deleteContent(@Param("bbsid")int bbsid);

}

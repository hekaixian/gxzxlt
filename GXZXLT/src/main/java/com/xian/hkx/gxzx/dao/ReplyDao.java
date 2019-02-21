package com.xian.hkx.gxzx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.xian.hkx.gxzx.entities.Reply;

public interface ReplyDao {
	
	/**
	 * ����ҳ����bbsid��ȡ�ظ�������Ϣ
	 * @param bbsid
	 * @param pagenum
	 * @param pagesize
	 * @return List<Reply>
	 */
	public List<Reply> getReply(@Param("bbsid")int bbsid, @Param("pagenum")int pagenum, @Param("pagesize")int pagesize);
	
	/**
	 * ��������
	 * @param reply
	 * @return int
	 */
	public int addReply(Reply reply);
	
	/**
	 * ��������IDɾ����������
	 * @param bbsid
	 * @return int
	 */
	public int deleteReply(@Param("bbsid")int bbsid);

}

package com.xian.hkx.gxzx.entities;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * <p>����ʵ����</p>
 *
 * <p>Copyright: ��Ȩ���� (c) 2002 - 2008<br>
 * Company: ����</p>
 *
 * @author hekaixian
 * @version 2019��1��25��
 */
@SuppressWarnings("serial")
public class Bbs implements Serializable{
	
	private Integer id;
	private Integer userid;
	private String title;
	private Integer replycount;
	private Date createtime;
	private Integer overhead;
	public Bbs() {
		
	}
	public Bbs(Integer id, Integer userid, String title, Integer replycount, Date createtime, Integer overhead) {
		super();
		this.id = id;
		this.userid = userid;
		this.title = title;
		this.replycount = replycount;
		this.createtime = createtime;
		this.overhead = overhead;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getReplycount() {
		return replycount;
	}
	public void setReplycount(Integer replycount) {
		this.replycount = replycount;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public Integer getOverhead() {
		return overhead;
	}
	public void setOverhead(Integer overhead) {
		this.overhead = overhead;
	}

	
}

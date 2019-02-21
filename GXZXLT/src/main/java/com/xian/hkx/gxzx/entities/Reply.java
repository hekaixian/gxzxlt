package com.xian.hkx.gxzx.entities;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Reply implements Serializable {
	
	private Integer id;
	private Integer bbsid;
	private Integer userid;
	private String content;
	private Date replytime;
	
	public Reply() {
		
	}
	public Reply(Integer id, Integer bbsid, Integer userid, String content, Date replytime) {
		super();
		this.id = id;
		this.bbsid = bbsid;
		this.userid = userid;
		this.content = content;
		this.replytime = replytime;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getBbsid() {
		return bbsid;
	}
	public void setBbsid(Integer bbsid) {
		this.bbsid = bbsid;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getReplytime() {
		return replytime;
	}
	public void setReplytime(Date replytime) {
		this.replytime = replytime;
	}
	

}

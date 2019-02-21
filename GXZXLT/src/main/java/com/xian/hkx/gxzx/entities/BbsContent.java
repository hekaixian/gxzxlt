package com.xian.hkx.gxzx.entities;

import java.io.Serializable;

/**
 * 
 * <p>帖子内容实体类</p>
 *
 * <p>Copyright: 版权所有 (c) 2002 - 2008<br>
 * Company: 久其</p>
 *
 * @author hekaixian
 * @version 2019年1月25日
 */
@SuppressWarnings("serial")
public class BbsContent implements Serializable{
	
	private Integer id;
	private Integer bbsid;
	private String content;
	public BbsContent() {
		
	}
	public BbsContent(Integer id, Integer bbsid, String content) {
		super();
		this.id = id;
		this.bbsid = bbsid;
		this.content = content;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
    
}

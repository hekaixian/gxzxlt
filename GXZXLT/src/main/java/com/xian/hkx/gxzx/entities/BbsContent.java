package com.xian.hkx.gxzx.entities;

import java.io.Serializable;

/**
 * 
 * <p>��������ʵ����</p>
 *
 * <p>Copyright: ��Ȩ���� (c) 2002 - 2008<br>
 * Company: ����</p>
 *
 * @author hekaixian
 * @version 2019��1��25��
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

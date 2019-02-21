package com.xian.hkx.gxzx.entities;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * <p>文档实体类</p>
 *
 * <p>Copyright: 版权所有 (c) 2002 - 2008<br>
 * Company: 久其</p>
 *
 * @author hekaixian
 * @version 2019年1月25日
 */
@SuppressWarnings("serial")
public class Files implements Serializable {
	private Integer id;
	private Integer userid;
	private String filepath;
	private Date uploadtime;
	private String title;
	private String filedescribe;
	private Integer loadcount;
	public Files(){
		
	}
	public Files(Integer id, Integer userid, String filepath, Date uploadtime, String title, String filedescribe,
			Integer loadcount) {
		super();
		this.id = id;
		this.userid = userid;
		this.filepath = filepath;
		this.uploadtime = uploadtime;
		this.title = title;
		this.filedescribe = filedescribe;
		this.loadcount = loadcount;
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
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	public Date getUploadtime() {
		return uploadtime;
	}
	public void setUploadtime(Date uploadtime) {
		this.uploadtime = uploadtime;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFiledescribe() {
		return filedescribe;
	}
	public void setFiledescribe(String filedescribe) {
		this.filedescribe = filedescribe;
	}
	public Integer getLoadcount() {
		return loadcount;
	}
	public void setLoadcount(Integer loadcount) {
		this.loadcount = loadcount;
	}
	

}

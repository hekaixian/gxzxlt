package com.xian.hkx.gxzx.entities;

import java.io.Serializable;
/**
 * 
 * <p>用户实体类</p>
 *
 * <p>Copyright: 版权所有 (c) 2002 - 2008<br>
 * Company: 久其</p>
 *
 * @author hekaixian
 * @version 2019年1月3日
 */
@SuppressWarnings("serial")
public class User implements Serializable {

	private Integer id;//用户ID
	private String loginname;//登录名
	private String password;//密码
	private String username;//用户姓名
	private Integer type;//用户类型
	private Integer actionauthority;//操作权限
	public User() {
		
	}
	public User(Integer id, String loginname, String password, String username, Integer type, Integer actionauthority) {
		super();
		this.id = id;
		this.loginname = loginname;
		this.password = password;
		this.username = username;
		this.type = type;
		this.actionauthority = actionauthority;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLoginname() {
		return loginname;
	}
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getActionauthority() {
		return actionauthority;
	}
	public void setActionauthority(Integer actionauthority) {
		this.actionauthority = actionauthority;
	}
	

}

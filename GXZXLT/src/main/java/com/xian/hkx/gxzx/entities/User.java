package com.xian.hkx.gxzx.entities;

import java.io.Serializable;
/**
 * 
 * <p>�û�ʵ����</p>
 *
 * <p>Copyright: ��Ȩ���� (c) 2002 - 2008<br>
 * Company: ����</p>
 *
 * @author hekaixian
 * @version 2019��1��3��
 */
@SuppressWarnings("serial")
public class User implements Serializable {

	private Integer id;//�û�ID
	private String loginname;//��¼��
	private String password;//����
	private String username;//�û�����
	private Integer type;//�û�����
	private Integer actionauthority;//����Ȩ��
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

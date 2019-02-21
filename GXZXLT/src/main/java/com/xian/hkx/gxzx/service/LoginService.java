package com.xian.hkx.gxzx.service;

import com.xian.hkx.gxzx.entities.User;

public interface LoginService {
	/**
	 * µÇÂ¼¼ì²é 
	 * @param loginname
	 * @param password
	 * @return int
	 */
	public User checkLogin(String loginname, String password);

}

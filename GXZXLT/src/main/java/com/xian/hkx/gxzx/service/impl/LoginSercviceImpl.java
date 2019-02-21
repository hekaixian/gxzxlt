package com.xian.hkx.gxzx.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xian.hkx.gxzx.dao.UserDao;
import com.xian.hkx.gxzx.entities.User;
import com.xian.hkx.gxzx.service.LoginService;
/**
 * <p>负责用户登录的业务层</p>
 *
 * <p>Copyright: 版权所有 (c) 2002 - 2008<br>
 * Company: 久其</p>
 *
 * @author hekaixian
 * @version 2019年1月4日
 */
@Service
public class LoginSercviceImpl implements LoginService{
	@Resource
	private UserDao userDao;
    
	public User checkLogin(String loginname, String password) {
		User user = userDao.getUserByNameAndpwd(loginname, password);
		return user;
	}

}

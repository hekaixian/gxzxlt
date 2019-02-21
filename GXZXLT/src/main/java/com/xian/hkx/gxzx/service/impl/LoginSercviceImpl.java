package com.xian.hkx.gxzx.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xian.hkx.gxzx.dao.UserDao;
import com.xian.hkx.gxzx.entities.User;
import com.xian.hkx.gxzx.service.LoginService;
/**
 * <p>�����û���¼��ҵ���</p>
 *
 * <p>Copyright: ��Ȩ���� (c) 2002 - 2008<br>
 * Company: ����</p>
 *
 * @author hekaixian
 * @version 2019��1��4��
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

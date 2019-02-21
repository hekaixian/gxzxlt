package com.xian.hkx.gxzx.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xian.hkx.gxzx.entities.User;
import com.xian.hkx.gxzx.service.impl.LoginSercviceImpl;
import com.xian.hkx.gxzx.util.Result;

@Controller
public class LoginController {
	
	@Resource
	private LoginSercviceImpl loginService;
	
	@RequestMapping("/Login")
	public String login() {
		return "Login";
	}
	
	@RequestMapping("/Index")
	public String Index(HttpSession session) {
		if (session.getAttribute("loginname") == null) {
			return "Login";
		}
		return "Index";
	}
	
	@RequestMapping("/toLogin")
	@ResponseBody
	public Result<Object> toLogin(HttpServletRequest request,HttpSession session) {
		String loginname = request.getParameter("loginname");
		String password = request.getParameter("password");
		User user = loginService.checkLogin(loginname, password);
		int status = 0;
		if (user != null) {
			session.setAttribute("username", user.getUsername());
			session.setAttribute("userid", user.getId());
			session.setAttribute("loginname", loginname);
			session.setAttribute("password", password);
			session.setAttribute("type", user.getType());
			status = 1;
		}
		Result<Object> result = new Result<Object>();
		result.setStatus(status);      
		return result;
	}
	

}

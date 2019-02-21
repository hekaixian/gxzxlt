package com.xian.hkx.gxzx.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xian.hkx.gxzx.entities.Files;
import com.xian.hkx.gxzx.service.MainService;

@Controller
public class MainController {
	@Resource
	private MainService mainService;
	
	@RequestMapping("/toIndex")
	public void toIndex(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws ServletException, IOException {
		
		List<Files> fileNewList = mainService.getNewFiles();
		List<Files> fileDownList = mainService.getDownMaxFiles();
		request.setAttribute("fileNewList", fileNewList);
		request.setAttribute("fileDownList", fileDownList);
		request.getRequestDispatcher("Index").forward(request, response);
	}
	
	@RequestMapping("/getBbss")
	@ResponseBody
	public List<Map<String, String>> getBbs(HttpServletRequest request,HttpServletResponse response) {
		int pageno = Integer.parseInt(request.getParameter("pageno"));
		List<Map<String, String>> bbsMaps = mainService.getAllBbss(pageno);
		return bbsMaps;
	}
	
	@RequestMapping("/getFiles")
	@ResponseBody
	public List<Map<String, String>> getFile(HttpServletRequest request,HttpServletResponse response) {
		int pageno = Integer.parseInt(request.getParameter("pageno"));
		List<Map<String, String>> fileMaps = mainService.getAllFiles(pageno);
		return fileMaps;
	}
	
	@RequestMapping("/toMyfile")
	public String toMyfile(HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		if (session.getAttribute("loginname") == null) {
			return "Login";
		}
		List<Files> fileNewList = mainService.getNewFiles();
		List<Files> fileDownList = mainService.getDownMaxFiles();
		request.setAttribute("fileNewList", fileNewList);
		request.setAttribute("fileDownList", fileDownList);
		return "Myfile";
	}
	
	@RequestMapping("/getBbsByUserid")
	@ResponseBody
	public List<Map<String, String>> getBbsByUserid(HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		int pageno = Integer.parseInt(request.getParameter("pageno"));
		int userid = Integer.parseInt(session.getAttribute("userid").toString());
		List<Map<String, String>> bbsMaps = mainService.getAllBbssByUserid(pageno, userid);
		return bbsMaps;
	}
	
	@RequestMapping("/getFilesByUserid")
	@ResponseBody
	public List<Map<String, String>> getFilesByUserid(HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		int pageno = Integer.parseInt(request.getParameter("pageno"));
		int userid = Integer.parseInt(session.getAttribute("userid").toString());
		List<Map<String, String>> fileMaps = mainService.getAllFilesByUserid(pageno, userid);
		return fileMaps;
	}
	
	@RequestMapping("/toFileCenter")
	public String toFileCenter(HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		if (session.getAttribute("loginname") == null) {
			return "Login";
		}
		List<Files> fileNewList = mainService.getNewFiles();
		List<Files> fileDownList = mainService.getDownMaxFiles();
		request.setAttribute("fileNewList", fileNewList);
		request.setAttribute("fileDownList", fileDownList);
		return "FileCenter";
	}
	
	@RequestMapping("/toPostCard")
	public String toPostCard(HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		if (session.getAttribute("loginname") == null) {
			return "Login";
		}
		List<Files> fileNewList = mainService.getNewFiles();
		List<Files> fileDownList = mainService.getDownMaxFiles();
		request.setAttribute("fileNewList", fileNewList);
		request.setAttribute("fileDownList", fileDownList);
		return "PostCard";
	}
	
	@RequestMapping("/toPost")
	@ResponseBody
	public Map<String, String> toPost(HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		Integer userid = Integer.parseInt(session.getAttribute("userid").toString());
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Integer status = mainService.addBbs(userid, title, content);
		Map<String, String> map = new HashMap<String, String>();
		map.put("status", status.toString());
		return map;
	}
	
	@RequestMapping("/toChangePwd")
	public String toChangePwd(HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		if (session.getAttribute("loginname") == null) {
			return "Login";
		}
		List<Files> fileNewList = mainService.getNewFiles();
		List<Files> fileDownList = mainService.getDownMaxFiles();
		request.setAttribute("fileNewList", fileNewList);
		request.setAttribute("fileDownList", fileDownList);
		return "ChangePwd";
	}
	
	@RequestMapping("/toChange")
	@ResponseBody
	public Map<String, String> toChange(HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		String oldPwd = request.getParameter("oldPwd");
		String newPwd = request.getParameter("newPwd");
		String pwd = session.getAttribute("password").toString();
		int userid = Integer.parseInt(session.getAttribute("userid").toString());
		Map<String, String> map = new HashMap<String, String>();
		if (!oldPwd.equals(pwd)) {
			map.put("status", "0");
			return map;
		}
		Integer status = mainService.changePwd(userid, newPwd);
		if (status == 1) {
			session.setAttribute("password", newPwd);
		}
		map.put("status", status.toString());
		return map;
	}
	
	@RequestMapping("toUserManage")
	public String toUserManage(HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		if (session.getAttribute("loginname") == null) {
			return "Login";
		}
		List<Files> fileNewList = mainService.getNewFiles();
		List<Files> fileDownList = mainService.getDownMaxFiles();
		request.setAttribute("fileNewList", fileNewList);
		request.setAttribute("fileDownList", fileDownList);
		return "UserManage";
	}
	
	@RequestMapping("toGetUser")
	@ResponseBody
	public List<Map<String, String>> toGetUser(HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		int pageno = Integer.parseInt(request.getParameter("pageno"));
		List<Map<String, String>> userList = mainService.getAllUsers(pageno);
		return userList;
	}
	
	@RequestMapping("toAddUser")
	@ResponseBody
	public Integer toAddUser(HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		String loginname = request.getParameter("loginname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		int count = mainService.addUser(loginname, username, password);
		return count;
	}
	
	@RequestMapping("toUploadFile")
	public String toUpLoadFile(HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		if (session.getAttribute("loginname") == null) {
			return "Login";
		}
		List<Files> fileNewList = mainService.getNewFiles();
		List<Files> fileDownList = mainService.getDownMaxFiles();
		request.setAttribute("fileNewList", fileNewList);
		request.setAttribute("fileDownList", fileDownList);
		return "UpLoadFile";
	}
	
	@RequestMapping("toFile")
	public String toFile(HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		if (session.getAttribute("loginname") == null) {
			return "Login";
		}
		int fileId = Integer.parseInt(request.getParameter("fileId"));
		Map<String, String> filemap = mainService.getFileByFileId(fileId);
		List<Files> fileNewList = mainService.getNewFiles();
		List<Files> fileDownList = mainService.getDownMaxFiles();
		request.setAttribute("fileNewList", fileNewList);
		request.setAttribute("fileDownList", fileDownList);
		request.setAttribute("filemap", filemap);
		return "File";
	}
	
	@RequestMapping("message")
	public String toMessage() {
		return "Message";
	}
	
	@RequestMapping("toBbs")
	public String toBbs(HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		if (session.getAttribute("loginname") == null) {
			return "Login";
		}
		int bbsid = Integer.parseInt(request.getParameter("bbsid"));
        Map<String, String> map = mainService.getBbsContent(bbsid);
		List<Files> fileNewList = mainService.getNewFiles();
		List<Files> fileDownList = mainService.getDownMaxFiles();
		request.setAttribute("fileNewList", fileNewList);
		request.setAttribute("fileDownList", fileDownList);
		request.setAttribute("bbsmap", map);
		return "Bbs";
	}
	
	@RequestMapping("getReply")
	@ResponseBody
	public List<Map<String, String>> getReply(HttpServletRequest request,HttpServletResponse response) {
		int pageno = Integer.parseInt(request.getParameter("pageno"));
		int bbsid = Integer.parseInt(request.getParameter("bbsid"));
		return mainService.getReply(pageno, bbsid);
	}
	
	@RequestMapping("toAddReply")
	@ResponseBody
	public Integer toAddReply(HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		int userid = Integer.parseInt(session.getAttribute("userid").toString());
		int bbsid = Integer.parseInt(request.getParameter("bbsid"));
		String content = request.getParameter("content");
		int count = mainService.addReply(bbsid, userid, content);
		return count;
	}
	
	@RequestMapping("toQuit")
	public String toQuit(HttpSession session) {
		session.invalidate();
		return "Login";
	}
	
	@RequestMapping("toDeleteBbs")
	@ResponseBody
	public Integer toDeleteBbs(HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		int bbsid = Integer.parseInt(request.getParameter("bbsid"));
		int count = mainService.deleteBbs(bbsid);
		return count;
	}
	
	@RequestMapping("toGetUserById")
	@ResponseBody
	public Map<String, String> getUserById(HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		int userid = Integer.parseInt(request.getParameter("userid"));
		Map<String, String> map = mainService.getUserById(userid);
		return map;
	}
	
	@RequestMapping("toUpDateUser")
	@ResponseBody
	public Integer upDateUser(HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		int userid = Integer.parseInt(request.getParameter("userid"));
		String loginname = request.getParameter("loginname");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		int type = Integer.parseInt(request.getParameter("type"));
		int count = mainService.upDateUser(userid, loginname, username, password, type);
		return count;
	}
	
	@RequestMapping("toDeleteUser")
	@ResponseBody
	public Integer deleteUser(HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		int userid = Integer.parseInt(request.getParameter("userid"));
		int count = mainService.deleteUser(userid);
		return count;
	}
	
}

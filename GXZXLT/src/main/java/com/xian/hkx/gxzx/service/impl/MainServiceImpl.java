package com.xian.hkx.gxzx.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xian.hkx.gxzx.dao.BbsContentDao;
import com.xian.hkx.gxzx.dao.BbsDao;
import com.xian.hkx.gxzx.dao.FileDao;
import com.xian.hkx.gxzx.dao.ReplyDao;
import com.xian.hkx.gxzx.dao.UserDao;
import com.xian.hkx.gxzx.entities.Bbs;
import com.xian.hkx.gxzx.entities.BbsContent;
import com.xian.hkx.gxzx.entities.Files;
import com.xian.hkx.gxzx.entities.Reply;
import com.xian.hkx.gxzx.entities.User;
import com.xian.hkx.gxzx.service.MainService;

@Service
public class MainServiceImpl implements MainService{
    @Resource
	private FileDao fileDao;
    
    @Resource
    private BbsDao bbsDao;
    
    @Resource
    private UserDao userDao;
    
    @Resource
    private BbsContentDao bbsContentDao;
    
    @Resource
    private ReplyDao replyDao;
    
    private int pagesize = 5;//设置每页的数据量
	
	public List<Files> getAllFiles() {
		
		return null;
	}

	public List<Files> getNewFiles() {
		List<Files> fileLists = fileDao.getAllFiles();
		if (fileLists.size() <= 5) {
			return fileLists;
		}
		List<Files> fileList = new ArrayList<Files>();
		for (int i = 0; i < 5; i++) {
			fileList.add(fileLists.get(i));
		}
		return fileList;
	}

	public List<Files> getDownMaxFiles() {
		List<Files> fileLists = fileDao.getAllFilesByDownCount();
		if (fileLists.size() <= 5) {
			return fileLists;
		}
		List<Files> fileList = new ArrayList<Files>();
		for (int i = 0; i < 5; i++) {
			fileList.add(fileLists.get(i));
		}
		return fileList;
	}

	public List<Map<String, String>> getAllBbss(int pageno) {
		List<Bbs> overHeadBbs = bbsDao.getOverHeadBbss();
//		int pagesize = 5;//设置每页的数据量
		int pagenum = (pageno - 1) * pagesize;
		List<Bbs> bbsLists = bbsDao.getAllBbss(pagenum, pagesize);
		List<Bbs> bbsList = new ArrayList<Bbs>();
		bbsList.addAll(overHeadBbs);
		bbsList.addAll(bbsLists);
		Integer allPages = getCountBbs();
		return getBbsMaps(bbsList, allPages);
	}
	
	public int getCountBbs() {
		int bbsCount = bbsDao.getCountOfAllBbs();
		double pageCount = (double)bbsCount/(double)pagesize;
		return (int)Math.ceil(pageCount);
	}
	
	/**
	 * 根据用户ID获取用户名 
	 * @param userid
	 * @return String
	 */
	public String getUserNameStr(int userid) {
		User user = userDao.getUserById(userid);
		if (user != null) {
			return user.getUsername();
		}
		return " ";
	}

	public List<Map<String, String>> getAllBbssByUserid(int pageno, int userid) {
		int pagenum = (pageno - 1) * pagesize;
		List<Bbs> bbsLists = bbsDao.getAllBbssByUserid(pagenum, pagesize, userid);
		int bbsCount = bbsDao.getCountOfAllBbsByUserid(userid);
		Integer allPages = getPageNumByCounts(bbsCount);
		return getBbsMaps(bbsLists, allPages);
	}
    /**
     * 根据数据量与分页值得出页数
     * @param counts
     * @return int
     */
	public int getPageNumByCounts(int counts) {
		double pageCount = (double)counts/(double)pagesize;
		return (int)Math.ceil(pageCount);
	}
	
	/**
	 *  根据Bbs集合转成指定形式的map集合
	 * @param bbsList
	 * @param allPages
	 * @return List<Map<String,String>>
	 */
	public List<Map<String, String>> getBbsMaps(List<Bbs> bbsList, Integer allPages) {
		if (bbsList.size() != 0) {
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm");
			List<Map<String, String>> bbsMaps = new ArrayList<Map<String, String>>();
			for (Bbs bbs : bbsList) {
				Map<String, String> bbsMap = new HashMap<String, String>();
				bbsMap.put("id", bbs.getId().toString());
				bbsMap.put("username", getUserNameStr(bbs.getUserid()));
				bbsMap.put("title", bbs.getTitle());
				bbsMap.put("replycount", bbs.getReplycount().toString());
				bbsMap.put("createtime", sdf.format(bbs.getCreatetime()));
				bbsMap.put("overhead", bbs.getOverhead().toString());
				bbsMap.put("bbspages", allPages.toString());
				bbsMap.put("content", bbsContentDao.getBbsContent(bbs.getId()).getContent());
				bbsMaps.add(bbsMap);
			}
			return bbsMaps;
		}
		return null;
	}

	public List<Map<String, String>> getAllFilesByUserid(int pageno, int userid) {
		int pagenum = (pageno - 1) * pagesize;
		List<Files> fileLists = fileDao.getAllFilesByUserid(pagenum, pagesize, userid);
		int fileCounts = fileDao.getCountFileByUserid(userid);
		Integer allPages = getPageNumByCounts(fileCounts);
		return getFileMaps(fileLists, allPages);
	}

	public List<Map<String, String>> getAllFiles(int pageno) {
		int pagenum = (pageno - 1) * pagesize;
		List<Files> fileLists = fileDao.getAllFilesByPagenum(pagenum, pagesize);
		int fileCounts = fileDao.getCountFiles();
		Integer allPages = getPageNumByCounts(fileCounts);
		return getFileMaps(fileLists, allPages);
	}
	
	/**
	 * 将File集合转成指定形式的map集合
	 * @param fileLists
	 * @param allPages
	 * @return List<Map<String,String>>
	 */
	public List<Map<String, String>> getFileMaps(List<Files> fileLists, Integer allPages) {
		if (fileLists.size() != 0) {
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm");
			List<Map<String, String>> fileMaps = new ArrayList<Map<String, String>>();
			for (Files file : fileLists) {
				Map<String, String> fileMap = new HashMap<String, String>();
				fileMap.put("id", file.getId().toString());
				fileMap.put("username", getUserNameStr(file.getUserid()));
				fileMap.put("uploadtime", sdf.format(file.getUploadtime()));
				fileMap.put("title", file.getTitle());
				fileMap.put("filedescribe", file.getFiledescribe());
				fileMap.put("loadcount", file.getLoadcount().toString());
				fileMap.put("filepages", allPages.toString());
				fileMaps.add(fileMap);
			}
			return fileMaps;
		}
		return null;
	}

	public int addBbs(int userid, String title, String content) {
		long time = System.currentTimeMillis();
		Date createtime = new Date(time);
		Bbs bbs = new Bbs();
		bbs.setUserid(userid);
		bbs.setTitle(title);
		bbs.setReplycount(0);
		bbs.setOverhead(0);
		bbs.setCreatetime(createtime);
		int bbssuccess = bbsDao.addBbs(bbs);
		if (bbssuccess != 1) {
			return 0;
		}
		int bbsid = bbs.getId();
		BbsContent bbsContent = new BbsContent();
		bbsContent.setBbsid(bbsid);
		bbsContent.setContent(content);
		int consuccess = bbsContentDao.addBbsContent(bbsContent);
		if (consuccess != 1) {
			return 0;
		}
		return 1;
	}

	public int changePwd(int userid, String password) {
		int status = userDao.updatePwdById(userid, password);
		if (status == 1) {
			return 1;
		}
		return 2;
	}

	public List<Map<String, String>> getAllUsers(int pageno) {
		int pagenum = (pageno - 1) * pagesize;
		List<User> userLists = userDao.getAllUserByPageno(pagenum, pagesize);
		int pageCount = userDao.getAllUsersCount();
		Integer pages = getPageNumByCounts(pageCount);
		if (userLists.size() != 0) {
			List<Map<String, String>> userMaps = new ArrayList<Map<String,String>>();
			for (User user : userLists) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("id", user.getId().toString());
				map.put("loginname", user.getLoginname());
				map.put("password", user.getPassword());
				map.put("username", user.getUsername());
				map.put("type", user.getType().toString());
				map.put("userpages", pages.toString());
				userMaps.add(map);
			}
			return userMaps;
		}
		return null;
	}

	public int addUser(String loginname, String username, String password) {
		User userexist = userDao.getUserByLoginname(loginname);
		if (userexist != null) {
			return 3;//该登录名已被使用
		}
		User user = new User();
		user.setLoginname(loginname);
		user.setUsername(username);
		user.setPassword(password);
		user.setType(1);
		user.setActionauthority(1);
		int count = userDao.addUser(user);
		if (count == 1) {
			return 1;//新增成功
		}
		return 0;//新增失败
	}

	public Map<String, String> getFileByFileId(int fileId) {
		Files file = fileDao.getFile(fileId);
		Map<String, String> map = new HashMap<String, String>();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm");
		map.put("id", file.getId().toString());
		map.put("username", getUserNameStr(file.getUserid()));
		map.put("filepath", file.getFilepath());
		map.put("uploadtime", sdf.format(file.getUploadtime()));
		map.put("title", file.getTitle());
		map.put("filedescribe", file.getFiledescribe());
		map.put("loadcount", file.getLoadcount().toString());
		return map;
	}

	public Map<String, String> getBbsContent(int id) {
		Bbs bbs = bbsDao.getBbsById(id);
		BbsContent bbsContent = bbsContentDao.getBbsContent(id);
		if (bbs != null && bbsContent != null) {
			Map<String, String> map = new HashMap<String, String>();
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
			map.put("id", bbs.getId().toString());
			map.put("username", getUserNameStr(bbs.getUserid()));
			map.put("title", bbs.getTitle());
			map.put("replycount", bbs.getReplycount().toString());
			map.put("createtime", sdf.format(bbs.getCreatetime()));
			map.put("overhead", bbs.getOverhead().toString());
			map.put("content", bbsContent.getContent());
			return map;
		}
		return null;
	}

	public List<Map<String, String>> getReply(int pageno, int bbsid) {
		int pagenum = (pageno - 1) * pagesize;
		List<Reply> replyLists = replyDao.getReply(bbsid, pagenum, pagesize);
		if (replyLists.size() != 0) {
			List<Map<String, String>> mapList = new ArrayList<Map<String,String>>();
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm");
			for (Reply reply : replyLists) {
				Map<String, String> map = new HashMap<String, String>();
				map.put("id", reply.getId().toString());
				map.put("bbsid", reply.getBbsid().toString());
				map.put("username", getUserNameStr(reply.getUserid()));
				map.put("content", reply.getContent());
				map.put("replytime", sdf.format(reply.getReplytime()));
				mapList.add(map);
			}
			return mapList;
		}
		return null;
	}

	public int addReply(int bbsid, int userid, String content) {
		long time = System.currentTimeMillis();
		Date replytime = new Date(time);
		Reply reply = new Reply();
		reply.setBbsid(bbsid);
		reply.setUserid(userid);
		reply.setContent(content);
		reply.setReplytime(replytime);
		int count = replyDao.addReply(reply);
		Bbs bbs = bbsDao.getBbsById(bbsid);
		int replycount = bbs.getReplycount();
		replycount += 1;
		bbs.setReplycount(replycount);
		int bbscount = bbsDao.updateBbs(bbs);
		if (count == 1 && bbscount == 1) {
			return 1;
		}
		return 0;
	}

	public int deleteBbs(int bbsid) {
		int bbscount = bbsDao.deleteBbs(bbsid);
		int contentcount = bbsContentDao.deleteContent(bbsid);
		replyDao.deleteReply(bbsid);
		if (bbscount == 1 && contentcount == 1) {
			return 1;
		}
		return 0;
	}

	public Map<String, String> getUserById(int userid) {
		User user = userDao.getUserById(userid);
		Map<String, String> map = new HashMap<String, String>();
		map.put("loginname", user.getLoginname());
		map.put("username", user.getUsername());
		map.put("password", user.getPassword());
		map.put("type", user.getType().toString());
		return map;
	}

	public int upDateUser(int userid, String loginname, String username, String password, int type) {
		User user = new User();
		user.setId(userid);
		user.setLoginname(loginname);
		user.setUsername(username);
		user.setPassword(password);
		user.setType(type);
		user.setActionauthority(1);
		int count = userDao.updateUser(user);
		if (count == 1) {
			return 1;
		}
		return 0;
	}

	public int deleteUser(int userid) {
		int count = userDao.deleteUser(userid);
		if (count == 1) {
			return 1;
		}
		return 0;
	}

}

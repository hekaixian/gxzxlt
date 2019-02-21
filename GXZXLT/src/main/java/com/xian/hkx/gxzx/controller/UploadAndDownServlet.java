package com.xian.hkx.gxzx.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xian.hkx.gxzx.dao.FileDao;
import com.xian.hkx.gxzx.entities.Files;

@Controller
public class UploadAndDownServlet {
	
	@Resource
	private FileDao fileDao;
	
	//���������ϴ����ļ���չ��
	private String Ext_Name = "gif,jpg,jpeg,png,bmp,swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb,doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2";
	
	@RequestMapping("upload")
	@ResponseBody
	public Integer upload(HttpServletRequest request,HttpServletResponse response,HttpSession session) {
		//�����ĵ��������Ϣ
		String loginname = session.getAttribute("loginname").toString();
		Integer userid = Integer.parseInt(session.getAttribute("userid").toString());
		long time = System.currentTimeMillis();
		Date uploadtime = new Date(time);
		Files file = new Files();
		file.setUploadtime(uploadtime);
		file.setUserid(userid);
		file.setLoadcount(0);
		boolean ifFileUpload = false;
		
		// �õ��ϴ��ļ��ı���Ŀ¼�����ϴ��ļ������WEB-INFĿ¼�£����������ֱ�ӷ��ʣ���֤�ϴ��ļ��İ�ȫ
		String savePath = request.getServletContext().getRealPath("WEB-INF/upload/" + loginname);
	    File saveFileDir = new File(savePath);
	    if (!saveFileDir.exists()) {
            // ������ʱĿ¼
		    saveFileDir.mkdirs();
	    }
	    // �ϴ�ʱ������ʱ�ļ�����Ŀ¼
		String tmpPath = request.getServletContext().getRealPath("WEB-INF/tem");
		File tmpFile = new File(tmpPath);
		if (!tmpFile.exists()) {
		   // ������ʱĿ¼
		   tmpFile.mkdirs();
		}
        try {
        	// ʹ��Apache�ļ��ϴ���������ļ��ϴ����裺
        	// 1.����һ��DiskFileItemFactory����
        	DiskFileItemFactory factory = new DiskFileItemFactory();
        	// ���ù����Ļ������Ĵ�С�����ϴ����ļ���С�����������Ĵ�Сʱ���ͻ�����һ����ʱ�ļ���ŵ�ָ������ʱĿ¼����
        	factory.setSizeThreshold(1024 * 10);// ���û������Ĵ�СΪ100KB�������ָ������ôĬ�ϻ������Ĵ�С��10KB
        	// �����ϴ�ʱ���ɵ���ʱ�ļ��ı���Ŀ¼
            factory.setRepository(tmpFile);
        	// 2.����һ���ļ��ϴ�������
        	ServletFileUpload upload = new ServletFileUpload(factory);
        	// ����ϴ��ļ�����������������
        	upload.setHeaderEncoding("UTF-8");
        	// 3.�ж��ύ�����������Ƿ����ϴ���������
        	if (!ServletFileUpload.isMultipartContent(request)) {
        	     // ���մ�ͳ��ʽ��ȡ����
        	     return 1;
        	}
        	// �����ϴ������ļ������ֵ
        	upload.setFileSizeMax(1024 * 1024 * 4);// 4M
        	// �����ϴ��ļ����������ֵ�����Ǳ����ϴ��������ļ����ܺ͵����ֵ
        	upload.setSizeMax(1024 * 1024 * 10);// 10M
        	List<FileItem> items = upload.parseRequest(request);
        	Iterator<FileItem> itr = items.iterator();
        	while (itr.hasNext()) {
        		FileItem item = (FileItem) itr.next();
        		// ���fileitem�з�װ������ͨ������������
        		if (item.isFormField()) {			
        			String name = item.getFieldName();
        		    // �����ͨ����������������������
        		    String value = item.getString("UTF-8");
        	    	// value = new String(value.getBytes("iso8859-1"),"UTF-8");
        		    if ("filedescribe".equals(name)) {
        		    	if (value != null && value.trim().length() != 0) {
        		    		file.setFiledescribe(value);
        		    	} else {
        		    		return 5;//��������Ϊ��
        		    	}
        		    }
        		} else {
        			// �õ��ϴ��ļ����ļ���
        			String fileName = item.getName();
        			if (fileName == null || fileName.trim().length() == 0) {
        			      return 6;//�ļ�����Ϊ��
        			}
        			// ע�⣺��ͬ��������ύ���ļ����ǲ�һ���ģ���Щ������ύ�������ļ����Ǵ���·����
        			// ��: C:\Users\H__D\Desktop\1.txt ����Щ���� �� 1.txt
        			// �����ȡ�����ϴ��ļ����ļ�����·�����֣�ֻ�����ļ�������
        			fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
        			file.setTitle(fileName);
        			// �õ��ϴ��ļ�����չ��
        			String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
        			// �����չ��
        			// �����Ҫ�����ϴ����ļ����ͣ���ô����ͨ���ļ�����չ�����ж��ϴ����ļ������Ƿ�Ϸ�
        			if(!Ext_Name.contains(fileExt)){
        		        return 2;//�ϴ��ļ���չ���ǲ��������չ��
        		    }
        			// ����ļ���С
                    if(item.getSize() == 0) continue;
                    if(item.getSize() > 1024 * 1024 * 4){
                         return 3;//�ϴ��ļ���С�������ƴ�С
                     }
                     // �õ����ļ����ļ���
                     String saveFileName = makeFileName(fileName);
                     //�����ļ�����һ// ��ȡitem�е��ϴ��ļ���������
                     InputStream is = item.getInputStream();
                     //����һ���ļ������
                     FileOutputStream out = new FileOutputStream(savePath + "\\" + saveFileName);
                     //����һ��������
                     byte buffer[] = new byte[1024];
                     //�ж��������е������Ƿ��Ѿ�����ı���
                     int len = 0;
                     while((len = is.read(buffer)) > 0){
                         out.write(buffer, 0, len);
                      }
                     //�ر������
                     out.close();
                     //�ر�������
                     is.close();
                     //ɾ����ʱ�ļ�
                     item.delete();    
                     file.setFilepath(savePath + "\\" + saveFileName);
                     ifFileUpload = true;
        		}
        	}
		} catch (Exception e) {
			return 3;
		} 
        
        if (ifFileUpload) {
        	int count = fileDao.addFile(file);
        	if (count == 1) {
        		return 0;
        	}
        }
		return 1;
	}
	
	@RequestMapping("toDownFile")
	public void toDownFile(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException, ServletException {
		Integer fileId = Integer.parseInt(request.getParameter("fileId"));
		Files files = fileDao.getFile(fileId);
		String filepath = files.getFilepath();
		String fileName = filepath.substring(filepath.lastIndexOf("\\")+1);  
		String fileReallyName = fileName.substring(fileName.indexOf("_") + 1);
        File file = new File(filepath);
        if (!file.exists()) {
        	request.setAttribute("message", "��Ҫ���ص���Դ�ѱ�ɾ������");
        	request.getRequestDispatcher("message").forward(request, response);
        	return;
        }
		// ������Ӧͷ��������������ظ��ļ�
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileReallyName, "UTF-8"));
        FileInputStream in = new FileInputStream(filepath);
        // ���������
       OutputStream out = response.getOutputStream();
        // ����������
        byte buffer[] = new byte[1024];
        int len = 0;
        // ѭ�����������е����ݶ�ȡ������������
        while ((len = in.read(buffer)) > 0) {
                // ��������������ݵ��������ʵ���ļ�����
                out.write(buffer, 0, len);
        }
        // �ر��ļ�������
        in.close();
         // �ر������
        out.close();
        //�����ļ�������
	    int oldloadCount = files.getLoadcount();
        int newloadCount = oldloadCount + 1;
        files.setLoadcount(newloadCount);
        fileDao.updateFile(files);
	}
	
	/**
	 * ����Ψһ�ļ��� 
	 * @param fileName
	 * @return String
	 */
	private String makeFileName(String fileName) {
		// Ϊ��ֹ�ļ����ǵ���������ҪΪ�ϴ��ļ�����һ��Ψһ���ļ���
		return UUID.randomUUID().toString().replaceAll("-", "") + "_" + fileName;
	}



}

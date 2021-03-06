package cn.cuit.lsn.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cuit.lsn.service.DownloadService;


/**
 * 
 * @author 路双宁
 * @date 2017.02.06
 * @version 0.3.0
 *  
 */

@Service("downloadService")
public class DownloadServiceImpl implements DownloadService {

	@Autowired
	private HttpServletRequest request;
	@Autowired 
	private HttpServletResponse response;
	
	public static final int NOT_FOUND = -1;
	public static final int ERROR = 0;
	public static final int OK = 1;
	

	@Override
	public int downloadBook(String bookName) {
		
		//返回的头信息
		response.setContentType("application/force-download");
		response.setCharacterEncoding("utf-8");
		try {
			//文件名经过转码之后不会出现下载时文件名乱码的问题
			response.addHeader("Content-Disposition",
					"attachment;fileName=" 
			+ new String(bookName.getBytes(),"iso-8859-1"));
		} catch (UnsupportedEncodingException e) {
			
			System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<不支持的编码方式：" + e.getMessage());
			e.printStackTrace();
			return ERROR;
		}// 设置文件名
		
		if (bookName != null) {
//			String path = request
//			.getServletContext()
//			.getRealPath("WEB-INF/File/");
			
			String path = "http://www.shuangfile.site/download/";
			
			try {
				InputStream inputStream = 
						new FileInputStream(
								new File(path,bookName));
				
				OutputStream os = response.getOutputStream();
				
				byte[] b = new byte[2048];
				int length;
				while ((length = inputStream.read(b)) > 0) {
					os.write(b, 0, length);
				}
				
				os.close();
				inputStream.close();
				
			} catch (FileNotFoundException e) {
				System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<文件没有找到：" + e.getMessage());
				e.printStackTrace();
				return NOT_FOUND;
			} catch (IOException e) {
				System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<文件IO操作异常" + e.getMessage());
				e.printStackTrace();
				return ERROR;
			}
		}
		return OK;
	}

	@Override
	public void downloadSoftware(String softwareName) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
}

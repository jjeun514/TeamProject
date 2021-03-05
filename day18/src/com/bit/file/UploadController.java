package com.bit.file;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
@WebServlet("/upload2.bit")
public class UploadController extends HttpServlet {

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path=req.getRealPath("upload");		
		MultipartRequest mr;
		mr=new MultipartRequest(req,path);
		Enumeration files=mr.getFileNames();
		while(files.hasMoreElements()) {
			String name=(String)files.nextElement();
			if(name!=null) {
			String org=mr.getOriginalFileName(name);
			System.out.println(name+":"+org);
			}
		}
	}
}

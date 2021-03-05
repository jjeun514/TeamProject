package com.bit.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/down.bit")
public class DownController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String filename=req.getParameter("file");
		String orgname=req.getParameter("org");
		String path=req.getRealPath("/upload");
		
		resp.setContentType("application/octet-stream");
		resp.setHeader("Content-Disposition", "attachment; filename=\""+orgname+"\"");
		InputStream is=null;
		OutputStream os=null; 

		try {
		File file=new File(path+"\\"+filename);
		is=new FileInputStream(file);
		os=resp.getOutputStream();
		
		int su=-1;
		while((su=is.read())!=-1) {
			os.write(su);
		}
		}finally {
		if(is!=null)is.close();
		if(os!=null)os.close();
		}
	
	}
}

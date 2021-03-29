package com.bit.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.model.Dao;
import com.test.model.Dto;

@WebServlet("/home.bit")
public class LoginController extends HttpServlet{
   Logger log=Logger.getGlobal();

   HttpSession session;
   
   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      
         String sysId=req.getParameter("idInput");
         String sysPw=req.getParameter("pwInput");
         Dao dao=new Dao();
         List<Dto> dto=dao.login(sysId, sysPw);
         
         if(dto==null) {
            //java 에서 alert 창
            resp.setContentType("text/html; charset=UTF-8");
            PrintWriter out=resp.getWriter();
            out.println("<script>alert('로그인 정보가 잘못되었습니다.'); location.href='/demo/login.jsp';</script>");
            out.flush();
            //resp.sendRedirect("login.jsp");
         }else {
            req.setAttribute("list", dto);
            
            RequestDispatcher rd;
            rd=req.getRequestDispatcher("home.jsp");
            rd.forward(req, resp);   
            log.info(sysId+"님이 입장하셨습니다.");
      }
   }
   
}
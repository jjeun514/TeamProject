package com.bit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

import com.test.model.Dao;

@WebServlet("/accAdd.bit")
public class AccountController extends HttpServlet {
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//      String sysId=req.getParameter("sysId");
//      String sysPw=req.getParameter("sysId");
//      String PwConform=req.getParameter("PwConform");
//      int empNo=Integer.parseInt(req.getParameter("empNo"));
//      
//      System.out.println(sysId);
//      
//     RequestDispatcher rd=null;
//     rd=req.getRequestDispatcher("home.jsp");
//     rd.forward(req, resp);
   
   
   }

   @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         
      Dao dao=new Dao();
      String sysId=req.getParameter("sysId");
      String sysPw=req.getParameter("sysPw");
      String PwConform=req.getParameter("PwConform");
      int empNo=Integer.parseInt(req.getParameter("empNo"));
      
      dao.accAdd(sysId, sysPw, empNo);
      
      resp.sendRedirect("login.jsp");
   
   }
   
   
}
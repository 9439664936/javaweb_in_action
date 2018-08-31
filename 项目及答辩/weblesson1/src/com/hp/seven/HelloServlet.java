package com.hp.seven;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doGet(req, resp);  // 一定不能要
//		逻辑  视图
		System.out.println("---HelloServlet---");
		
//		PrintWriter pw = resp.getWriter();
//		pw.write("<html><head></head><body><h1>HelloServlet</h1></body></html>");
		req.getRequestDispatcher("hello.jsp").forward(req, resp);
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doPost(req, resp);// 一定不能要
		
	}
	
	
	
	
	
	

}

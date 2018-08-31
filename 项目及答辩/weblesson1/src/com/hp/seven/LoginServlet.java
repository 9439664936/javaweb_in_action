package com.hp.seven;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			System.out.println("---LoginServlet---");
			req.setCharacterEncoding("utf-8");
			resp.setCharacterEncoding("utf-8");
			String name = req.getParameter("user_name");
			String password = req.getParameter("user_password");
			System.out.println(name);
			System.out.println(password);
			
			Connection conn = null;
			try {
				conn = DBHelper.getConn();
				String sql = "select * from student where stu_name = ? and stu_password = ? ";
				ResultSet rs = DBHelper.executeQuery(conn, sql, name,password);
				if(rs.next()){
					HttpSession session = req.getSession();
					session.setAttribute("loinUserName", name);
					
					resp.sendRedirect("UserListServlet");
//					req.getRequestDispatcher("UserListServlet").forward(req, resp);
				}else{
					resp.sendRedirect("login_fail.jsp");
//					req.getRequestDispatcher("login_fail.jsp").forward(req, resp);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doPost(req, resp);
		doGet(req, resp);
	}
	
}

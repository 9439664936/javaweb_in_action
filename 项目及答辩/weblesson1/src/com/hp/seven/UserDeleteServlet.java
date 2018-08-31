package com.hp.seven;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserDeleteServlet")
public class UserDeleteServlet extends HttpServlet {

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				String index = req.getParameter("userIndex");
				Connection conn = DBHelper.getConn();
				String sql ="delete from student where stu_index = ? ";
				int i = DBHelper.executeUpdate(conn, sql, index);
				if(i>0){
					resp.sendRedirect("UserListServlet");   
				}
				DBHelper.closeConn(conn);
			
		}
	
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doGet(req, resp);
		}
	
	
}

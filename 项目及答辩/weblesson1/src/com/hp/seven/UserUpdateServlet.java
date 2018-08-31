package com.hp.seven;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String userIndex = req.getParameter("user_index");
		String userName = req.getParameter("user_name");
		String userPwd = req.getParameter("user_pwd");
		String userAge = req.getParameter("user_age");
		String userSex = req.getParameter("user_sex");
		
		Connection conn = DBHelper.getConn();
		String sql = "update student set  stu_name = ? ,stu_password =? ,stu_age=?,stu_sex=? where stu_index = ? " ;
		int i = DBHelper.executeUpdate(conn, sql, userName,userPwd,userAge,userSex,userIndex);
		if(i>0){
			resp.sendRedirect("UserListServlet");
		}else{
			resp.sendRedirect("user_update.jsp");
		}
		DBHelper.closeConn(conn);
		
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}

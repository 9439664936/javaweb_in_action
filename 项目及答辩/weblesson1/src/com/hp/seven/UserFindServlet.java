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

@WebServlet("/UserFindServlet")
public class UserFindServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				String userIndex = req.getParameter("userIndex");
				
				Connection conn = DBHelper.getConn();
				
				try {
					String sql = " select * from student where stu_index = ? " ;
					ResultSet rs = DBHelper.executeQuery(conn, sql, userIndex);
					UserBean user = new UserBean();
					if(rs.next()){
						user.setUserId(rs.getString("stu_index"));
						user.setUserName(rs.getString("stu_name"));
						user.setUserPassword(rs.getString("stu_password"));
						user.setUserSex(rs.getString("stu_sex"));
						user.setUserAge(rs.getInt("stu_age"));
						
						req.setAttribute("update_user", user);
						req.getRequestDispatcher("user_update.jsp").forward(req, resp);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					DBHelper.closeConn(conn);
				}
	
	
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}

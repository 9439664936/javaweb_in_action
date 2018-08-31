package login;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserDelete")
public class UserDelete extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		
		String userID = req.getParameter("userId");
		System.out.println(userID);
		Connection conn = null;
		conn = DBHelper.getConn();
		String sql = "delete from student where stu_id = ?";
		int n = DBHelper.executeUpdate(conn, sql, userID);
		if(n > 0) {
			resp.sendRedirect("UserServlet");
		}
		DBHelper
		.closeConn(conn);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

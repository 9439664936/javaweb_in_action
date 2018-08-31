package login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UserFind")
public class UserFind extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		
		Connection conn = null;
		String userId = req.getParameter("userId");
		
		System.out.println(userId);
		try {
			conn = DBHelper.getConn();
			String sql = "select * from student where stu_id = ?";
			ResultSet rs = DBHelper.executeQuery(conn, sql, userId);
			UserBean user = new UserBean();
			if(rs.next()) {
				user.setId(rs.getInt("stu_id"));
				user.setName(rs.getString("stu_name"));
				user.setPassword(rs.getString("stu_password"));
				user.setSex(rs.getString("stu_sex"));
				user.setAge(rs.getInt("stu_age"));
				
				req.setAttribute("update_user", user);
				req.getRequestDispatcher("user_update.jsp").forward(req, resp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBHelper.closeConn(conn);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

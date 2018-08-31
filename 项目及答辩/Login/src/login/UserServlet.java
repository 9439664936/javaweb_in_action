package login;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
	
		Connection conn = DBHelper.getConn();
		
		try {
			String sql = "select * from student";
			ResultSet rs = DBHelper.executeQuery(conn, sql);
			List<UserBean> studentList = new ArrayList<UserBean>();
			while(rs.next()) {
				UserBean user = new UserBean();
				user.setId(rs.getInt("stu_id"));
				user.setName(rs.getString("stu_name"));
				user.setPassword(rs.getString("stu_password"));
				user.setSex(rs.getString("stu_sex"));
				user.setAge(rs.getInt("stu_age"));
				studentList.add(user);
			}
			req.setAttribute("user_list", studentList);
			req.getRequestDispatcher("user_list.jsp").forward(req, resp);
			
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

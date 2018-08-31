package login;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserUpdate")
public class UserUpdate extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		
		String id = req.getParameter("user_id");
		String name = req.getParameter("user_name");
		String password = req.getParameter("user_password");
		String sex = req.getParameter("user_sex");
		String age = req.getParameter("user_age");
		
		Connection conn = DBHelper.getConn();
		
		String sql = "update student set stu_name = ?,stu_password = ?,stu_sex = ?,stu_age = ? where stu_id = ?";
		int n = DBHelper.executeUpdate(conn, sql, name, password, sex, age, id);
		if(n > 0) {
			resp.sendRedirect("UserServlet");
		}else {
			resp.sendRedirect("user_update.jsp");;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}

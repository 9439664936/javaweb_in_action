package login;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserInsert")
public class UserInsert extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		
		String name = req.getParameter("user_name");
		String password = req.getParameter("user_password");
		String sex = req.getParameter("user_sex");
		String age = req.getParameter("user_age");
		
		Connection conn = null;
		
		conn = DBHelper.getConn();
		String sql = "insert into student(stu_name,stu_password, stu_sex, stu_age) values(?,?,?,?)";
		int n = DBHelper.executeUpdate(conn, sql, name, password, sex, age);
		if(n > 0) {
			resp.sendRedirect("UserServlet");
			
		}else {
			req.getRequestDispatcher("login_fail.jsp").forward(req, resp);
		}
		DBHelper.closeConn(conn);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}

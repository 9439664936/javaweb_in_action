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
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {

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
		
		Connection conn = null;
		try {
			conn = DBHelper.getConn();
			String sql = "select * from student where stu_name = ? and stu_password = ?";
			ResultSet rs = DBHelper.executeQuery(conn, sql, name, password);
			if(rs.next()) {
//				req.getRequestDispatcher("login_success.jsp").forward(req, resp);
				// resp.sendRedirect("login_success.jsp");
				HttpSession session = req.getSession();
				session.setAttribute("LoginUserName", name);
				
				resp.sendRedirect("UserServlet");
			}else {
				req.getRequestDispatcher("login_fail.jsp").forward(req, resp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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

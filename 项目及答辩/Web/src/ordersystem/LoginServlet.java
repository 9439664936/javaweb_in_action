package ordersystem;

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

import ordersystem.DBHelper;

/**
 * Servlet implementation class Login
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String name =req.getParameter("account");
		String password=req.getParameter("password");
		Connection conn=null;
		try 
		{
			conn=DBHelper.getConn();
			String sql="select * from User where user_name=? and user_password=?";
			ResultSet rs=DBHelper.executeQuery(conn, sql, name,password);
			if(rs.next())
			{   
				HttpSession session = req.getSession();
				session.setAttribute("user_name", name);
				resp.sendRedirect("HomePageServlet");
			}
			else
			{
				req.getRequestDispatcher("login.jsp").forward(req, resp);
			}
		} catch (SQLException e)
		{
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			DBHelper.closeConn(conn);
		}
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	doGet(req,resp);
}
}
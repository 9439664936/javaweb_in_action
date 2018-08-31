package ordersystem;

import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ordersystem.DBHelper;

@WebServlet("/DeleteCartServlet")
public class DeleteCartServlet extends HttpServlet {

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				Connection conn = DBHelper.getConn();
				String sql ="delete from cart";
				int  i= DBHelper.executeUpdate(conn, sql);
					if(i>0)
					{
						resp.sendRedirect("HomePageServlet");
					}	
				DBHelper.closeConn(conn);
		}
	
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			doGet(req, resp);
		}
	
	
}

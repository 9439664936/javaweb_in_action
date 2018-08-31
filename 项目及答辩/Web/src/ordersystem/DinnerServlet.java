package ordersystem;

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

import ordersystem.DBHelper;
import ordersystem.CartBean;

@WebServlet("/DinnerServlet")
public class DinnerServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");		
		Connection conn = DBHelper.getConn();
		try {
			String sql = "select  * from Cart " ;
			ResultSet rs = DBHelper.executeQuery(conn, sql);
			List<CartBean> cart_all =new ArrayList<CartBean>();
			while(rs.next())
			{
				String sql1="select food_price,food_name from food where food_id=?";
				ResultSet rs1=DBHelper.executeQuery(conn, sql1, rs.getInt("food_id"));//用foodid找name，price
				if(rs1.next())
				{
					CartBean cart = new CartBean();
					cart.setfood_quantity(rs.getInt("food_quantity"));
					cart.setfood_single_price(rs1.getInt("food_price"));
					cart.setfood_name(rs1.getString("food_name"));
					cart_all.add(cart);
				}
			}
			req.setAttribute("mycart",cart_all);
			req.getRequestDispatcher("HomePageServlet").forward(req, resp);
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}finally
		{
			DBHelper.closeConn(conn);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException
	{
		doGet(req,resp);
	}
}

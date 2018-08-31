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

@WebServlet("/OrderFindDeliveringServlet")
public class OrderFindDeliveringServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		
		Connection conn = DBHelper.getConn();
		try {
			
			String sql = "select * from orderlist where food_deliver =?";
			ResultSet rs = DBHelper.executeQuery(conn, sql,"否");
			List<OrderBean> orderList =new ArrayList<OrderBean>();
			while(rs.next()){
				OrderBean order = new OrderBean();
				order.setFoodName(rs.getString("food_name"));
				order.setUserName(rs.getString("user_name"));
				order.setUserPhonenum(rs.getString("user_phonenum"));
				order.setUserAddress(rs.getString("user_address"));
				order.setFoodQuantity(rs.getInt("food_quantity"));
				order.setFoodSinglePrice(rs.getInt("food_single_price"));
				order.setFoodSumPrice(rs.getInt("food_sum_price"));
				order.setOrderTime(rs.getString("food_order_time"));
				order.setOrderDeliver(rs.getString("food_deliver"));
				orderList.add(order);
			}
			
			
			req.setAttribute("order",orderList);
			
			req.getRequestDispatcher("order.jsp").forward(req, resp);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
	
}


package ordersystem;

import java.io.IOException;
import java.nio.channels.SeekableByteChannel;
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
@WebServlet("/HomePageServlet")
public class HomePageServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		Connection conn=DBHelper.getConn();
		
		try {
			String sql="select * from food";
		    ResultSet rs=DBHelper.executeQuery(conn, sql);
		    List<FoodBean> foodlist=new ArrayList<FoodBean>();
			while(rs.next()){
				FoodBean food=new FoodBean();
				food.setFoodName(rs.getString("food_name"));
				food.setFoodPrice(rs.getDouble("food_price"));
				food.setFoodVip(rs.getDouble("food_vip"));
				food.setFoodIngredient(rs.getString("food_ingredient"));
				food.setFoodType(rs.getString("food_type"));
				foodlist.add(food);	
			}
			
			req.setAttribute("homepage",foodlist);
			req.getRequestDispatcher("RankServlet").forward(req, resp);
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

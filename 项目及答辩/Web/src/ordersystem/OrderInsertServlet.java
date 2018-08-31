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


@WebServlet("/OrderInsertServlet")
public class OrderInsertServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		
		Connection conn1 = DBHelper.getConn();
		Connection conn2 = DBHelper.getConn();
		
	try {
		int m = 0;
		String sql_1 = "select * from cart";
		ResultSet rs1 = DBHelper.executeQuery(conn1, sql_1);
		while(rs1.next()){
		String foodName=rs1.getString("food_name");
		String userName=rs1.getString("user_name");
		int foodQuantity=rs1.getInt("food_quantity");
		int foodSingle=rs1.getInt("food_single_price");
		int foodSum=foodSingle*foodQuantity;
		
		String sql_2 = "select * from user where user_name=?";
		ResultSet rs2 = DBHelper.executeQuery(conn2, sql_2,userName);

		if(rs2.next()){
			String userPhonenum=rs2.getString("user_phonenumber");
			String userAddress=rs2.getString("user_address");
			int userId=rs2.getInt("user_id");
			
			Connection conn3 = DBHelper.getConn();
			String sql3 = "insert into orderlist(food_name,user_id,user_name,user_phonenum,user_address,food_quantity,food_single_price,food_sum_price) values(?,?,?,?,?,?,?,?)";
			int i = DBHelper.executeUpdate(conn3, sql3, foodName,userId,userName,userPhonenum,userAddress,foodQuantity,foodSingle,foodSum);
			m=i;
			DBHelper.closeConn(conn3);
		}
		
		
		}
		if(m>0){
			Connection conn4 = DBHelper.getConn();
			String sql4 = "delete  from cart";
			DBHelper.executeUpdate(conn4, sql4);
			resp.sendRedirect("OrderServlet");
		}else{
			resp.sendRedirect("HomePageServlet");
		}
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

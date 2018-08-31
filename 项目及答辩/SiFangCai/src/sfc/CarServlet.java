package sfc;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
@WebServlet("/CarServlet")
public class CarServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
			Connection conn=DBHelper.getConn();
			
	try {
			int i=0,j=0 ,k=0;
			req.setCharacterEncoding("UTF-8");
			resp.setCharacterEncoding("UTF-8");
			String user_name=req.getParameter("user_name");
			String food_id=req.getParameter("food_id");
			List<CartBean> cart_all=new ArrayList<CartBean>();
			String sql="select *from food where food_id=?";//用food_id找到food信息
			ResultSet rs=DBHelper.executeQuery(conn, sql, food_id);//保存food所有信息
			String sql2="insert into Cart(user_name,food_name,food_single_price,food_quantity) values (?,?,?,?) ";//插入cart
			String sql4="select* from cart where user_name=? ";
			ResultSet rs1=DBHelper.executeQuery(conn, sql4, user_name);
		if(rs.next())
		{
				String fdname= rs.getString("food_name");
				String sql5 ="select *from Cart where food_name=? ";
				ResultSet rs5=DBHelper.executeQuery(conn, sql5, fdname);
		if(rs5.next())
		{
			//如果菜名重复则更改quantity加一
				String sql7="select food_quantity from Cart where food_name=? ";
				ResultSet rs7=DBHelper.executeQuery(conn, sql7, fdname);
				if(rs7.next())
				{
						String sql6="update Cart set food_quantity=? where food_name=? and user_name=?";
						int g=rs7.getInt("food_quantity");
						int b=g+1;
						k=DBHelper.executeUpdate(conn, sql6, b,fdname,user_name);
						if(k>0)
						{
							while(rs1.next())
								{
									CartBean cart_restauraut=new CartBean();
									cart_restauraut.setuser_name(rs1.getString("user_name"));
									cart_restauraut.setfood_name(rs1.getString("food_name"));
									cart_restauraut.setfood_single_price(rs1.getInt("food_single_price"));
									cart_restauraut.setfood_quantity(rs1.getInt("food_quantity"));
									cart_all.add(cart_restauraut);
								}
						}
				req.setAttribute("Cart", cart_all);
				req.getRequestDispatcher("dinner.jsp").forward(req, resp);
				}
		}
		else {
			//菜名不重复则重新插入
						
						int food_price= rs.getInt("food_price");
						i= DBHelper.executeUpdate(conn, sql2,user_name,fdname,food_price,1);//插入其他
						//插入quantity
				if(i>0)
				{	
					    CartBean cart_restauraut=new CartBean();
					    cart_restauraut.setuser_name(user_name);
					    cart_restauraut.setfood_name(fdname);
					    cart_restauraut.setfood_single_price(food_price);
					    cart_restauraut.setfood_quantity(1);
					    cart_all.add(cart_restauraut);
				}
				req.setAttribute("Cart", cart_all);
				req.getRequestDispatcher("dinner.jsp").forward(req, resp);
			}
		}
		else 	req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
	catch (SQLException e)
	{
		// TODO Auto-generated catch block
				e.printStackTrace();
	}finally
	{
				DBHelper.closeConn(conn);
	}
	
	
	
}
@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req,resp);

}
}

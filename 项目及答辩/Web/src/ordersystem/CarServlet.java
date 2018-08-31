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

import java.util.ArrayList;
import java.util.List;
@WebServlet("/CarServlet")
public class CarServlet extends HttpServlet {
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		int p,k=0;
		Connection conn=DBHelper.getConn();
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String user_name=req.getParameter("user_name");
		String food_id=req.getParameter("food_id");
		System.out.println("cartservlet");
	try {
			String sql1="select * from Cart where user_name=? and food_id=?";
			ResultSet rs1=DBHelper.executeQuery(conn, sql1, user_name,food_id);
		if(rs1.next())
		{//重复
			
				int j=rs1.getInt("food_quantity")+1;
				String sql3="update Cart set food_quantity=? where food_id=? ";
				p=DBHelper.executeUpdate(conn, sql3, j,food_id);
				 if(p>0)
				 {
						resp.sendRedirect("DinnerServlet");		
			}
		}	
		else
		{//不重复
				String sql5="select food_name from food where food_id=? ";
				ResultSet rs5=DBHelper.executeQuery(conn, sql5, food_id);
			if(rs5.next())
			{
				String food_name=rs5.getString("food_name");
				String sql4="insert into Cart(user_name,food_name,food_id,food_quantity) values(?,?,?,?)";
				k=DBHelper.executeUpdate(conn, sql4, user_name,food_name,food_id,1);
			 if(k>0)
			 {
					resp.sendRedirect("DinnerServlet");
			 }
			}
		}
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

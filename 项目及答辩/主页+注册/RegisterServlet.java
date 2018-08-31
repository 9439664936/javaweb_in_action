package ordersystem;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		String UserName=req.getParameter("account");
		String UserPassword=req.getParameter("password");
		String UserTrueName=req.getParameter("name");
		String UserSex=req.getParameter("gender");
		String UserAge=req.getParameter("birthday");
		String UserIDcard=req.getParameter("IDcard");
		String UserAddress=req.getParameter("address");
		String UserPhonenum=req.getParameter("tel");
		String UserEmail=req.getParameter("email");
		String UserPostCode=req.getParameter("postCode");
		Connection conn=DBHelper.getConn();
		String sql="insert into user(user_name,user_password,user_truename,user_sex,user_birthday,user_idcard,user_address,user_phonenumber,user_email,user_postcode) values(?,?,?,?,?,?,?,?,?,?) ";
		int i=DBHelper.executeUpdate(conn, sql, UserName,UserPassword,UserTrueName,UserSex,UserAge,UserIDcard,UserAddress,UserPhonenum,UserEmail,UserPostCode);
		if(i>0){
			//resp.sendRedirect("login.jsp");
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		}
		else
		{
			//resp.sendRedirect("register.jsp");
			req.getRequestDispatcher("register.jsp").forward(req, resp);
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}

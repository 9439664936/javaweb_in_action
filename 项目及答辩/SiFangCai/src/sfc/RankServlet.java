package sfc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/RankServlet")

public class RankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		Connection conn = null;
		try {
			conn = DBHelper.getConn();
			// String sql = "select *,count(*) as sum from test group by name desc";
			String sql = "select * from num";
			ResultSet rs = DBHelper.executeQuery(conn, sql);
			// List<TestBean> testList = new ArrayList<TestBean>();
			List<CountBean> countList = new ArrayList<CountBean>();

			while (rs.next()) {
				boolean flag = false;
				for (int i = 0; i < countList.size(); i++) {
					if (countList.get(i).getName().equals(rs.getString("name"))) {
						int tmp = countList.get(i).getNum() + rs.getInt("n");
						countList.get(i).setNum(tmp);
						flag = true;
						break;
					}
				}
				if (!flag) {
					CountBean countBean = new CountBean();
					countBean.setName(rs.getString("name"));
					countBean.setNum(rs.getInt("n"));
					countList.add(countBean);
				}
			}
			for (CountBean count : countList) {
				System.out.println(count.getName() + "\t" + count.getNum());
			}
			Collections.sort(countList, new Comparator<CountBean>() {
				public int compare(CountBean c1, CountBean c2) {
					if (c1.getNum() < c2.getNum())
						return 1;
					if (c1.getNum() == c2.getNum())
						return 0;
					return -1;
				}
			});
			for (CountBean count : countList) {
				System.out.println(count.getName() + "\t" + count.getNum());
			}
			HttpSession session = req.getSession();
			session.setAttribute("count_list", countList);
			req.getRequestDispatcher("index.jsp").forward(req, resp);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBHelper.closeConn(conn);
		}
	}

	public void init() throws ServletException {
		System.out.println("test");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="ordersystem.*,java.util.*" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<link rel="stylesheet" type="text/css" href="css/menu.css" />
		<link rel="stylesheet" type="text/css" href="css/context.css" />
		<link rel="stylesheet" type="text/css" href="css/bodyAndBottom.css" />
		<title>阿婆私房菜</title>
	</head>
	<%
		List<CountBean> testList = CastList.castList(session.getAttribute("count_list"), CountBean.class); 
	%>
	<body>
		
		<div id="background">
			<!--
            	作者：luchao7285@163.com
            	时间：2017-03-10
            	描述：上层
            -->
			<div id="top">
				<!--
                	作者：luchao7285@163.com
                	时间：2017-03-10
                	描述：上层上块
                -->
				<div id="top_up">
					<ul>
						<li>
							<a href="login.jsp">会员登录</a>
						</li>|
						<li>
							<a href="register.jsp">会员注册</a>
						</li>|
						<li>
							<a href="login.jsp">注销退出</a>
						</li>|
						<li>
							<a href="description.jsp">配送说明</a>
						</li>|
						<li>
							<a href="aboutUs.jsp">关于我们</a>
						</li>
					</ul>
				</div>
				<!--
                	作者：luchao7285@163.com
                	时间：2017-03-10
                	描述：上层下块
                -->
				<div>
					<!--
                	作者：luchao7285@163.com
                	时间：2017-03-10
                	描述：上层下块左
                -->
					<div style="float: left;">
						<img src="img/1257477260.gif" />
					</div>
					<!--
                	作者：luchao7285@163.com
                	时间：2017-03-10
                	描述：上层下块右
                -->
					<div id="top_bottom_right">
						<div id="title">
							亲爱的<%=session.getAttribute("user_name") %>您好! 欢迎光临!
						</div>
						<ul>
							<li>
								<a href=HomePageServlet><b>首页</b></a>
							</li>
							<li>
								<a href="DinnerList"><b>我的餐车</b></a>
							</li>
							<li>
								<a href="OrderServlet"><b>我的订单</b></a>
							</li>
							<li>
								<a href="register.jsp"><b>用户中心</b></a>
							</li>
							<li>
								<a href="description.jsp"><b>配送说明</b></a>
							</li>
							<li>
								<a href="aboutUs.jsp"><b>关于我们</b></a>
							</li>
							<li>
								<a href="login.jsp"><b>注销退出</b></a>
							</li>
						</ul>
					</div>
				</div>
			</div>
			<!--
            	作者：luchao7285@163.com
            	时间：2017-03-10
            	描述：中层
            -->
			<div id="middle_index">
				<!--
                	作者：luchao7285@163.com
                	时间：2017-03-10
                	描述：中层左部
                -->
				<div id="middle_left">
					<!--
                    	作者：luchao7285@163.com
                    	时间：2017-03-10
                    	描述：中层左部内容
                    -->
                    <% List<FoodBean> foodlist=(List<FoodBean>) request.getAttribute("homepage");
                    for(int i=0;i<6;i++){
                    %>
					<div style="width: 320px;height: 200px;float: left;">
						<div class="context_top">
							<div class="context_img">
								<img src="img/<%=i %>.jpg" />
							</div>
							<div class="context_font">
							菜名:
							<b><%=foodlist.get(i).getFoodName() %></b><br/> 
							市场价格: <%=foodlist.get(i).getFoodPrice() %><br/> 
							会员价格:<font><b><%=foodlist.get(i).getFoodVip() %></b></font><br/>
							 配料: <%=foodlist.get(i).getFoodIngredient() %><br/>
							 菜品类型:<%=foodlist.get(i).getFoodType() %>
							</div>
						</div>
						<div class="context_button">
							<form style="display: inline-block;" action="CarServlet">
								<input type="hidden" name="food_id" value="<%=i+1%>">
								<input type="hidden"  name="user_name" value="<%=session.getAttribute("user_name")%>">
									<input type="submit"  style="width:77px; height:26px;  background: url(img/img_dinggou.gif) no-repeat center;cursor:pointer;font-size:0;line-height:0;text-indent:-9999px;" />
								</form>
						</div>
					</div>
					<%} %>
				</div>
				
				<!--
                	作者：luchao7285@163.com
                	时间：2017-03-11
                	描述：中层右部
                -->
				<div id="middle_right">
					<!--
                    	作者：luchao7285@163.com
                    	时间：2017-03-11
                    	描述：餐厅公告栏
                    -->
					<div id="announcement">
						<div id="announcement_title">
							餐厅公告
							<a href="#">更多>></a>
						</div>
						<br/>
						<ul>
							<li>
								<a href="notice.jsp">本店特色《咸菜肉饭》</a>
								<font>2018-7-20</font>
							</li>
							<li>
								<a href="notice.jsp">本店特色《咸菜肉饭》</a>
								<font>2018-7-20</font>
							</li>
						</ul>
					</div>
					<!--
                    	作者：luchao7285@163.com
                    	时间：2017-03-11
                    	描述：我的餐车栏
                    -->
					<div id="diner">
						<div id="diner_title">
							我的餐车
							<a href="DinnerList">更多>></a>
						</div>
						<br/>
						<div id="diner_context_head">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;菜单名称&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;单价&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;数量
						</div>
						<div id="diner_context_foot">
						<%List<CartBean> cart_all=(List<CartBean>)request.getAttribute("mycart");
						if(cart_all != null)
						{for(int i=0;i<cart_all.size();i++){ %>
						<tr>
							<td>	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=cart_all.get(i).getfood_name() %></td>
							<td>	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=cart_all.get(i).getfood_single_price() %></td>
							<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=cart_all.get(i).getfood_quantity() %></td>
					</tr>
					<% }}%>
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;小计：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<font>0.0</font>元&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<font>0</font>份
						</div>
						<div id="diner_context_button">
							<a href="OrderInsertServlet"><img src="img/canche_submit.gif" /></a>
							<a href="DeleteCartServlet"><img src="img/quxiao2.gif" /></a>
						</div>
					</div>
					<!--
                    	作者：luchao7285@163.com
                    	时间：2017-03-11
                    	描述：销售排行栏
                    -->
					<div id="sell">
						<div id="sell_title">
							销售排行榜
							<a href="#">更多>></a>
						</div>
						
						<br/>
						<ul>
							<%for (int i = 0; i < testList.size(); i++) {%>
						<li><a href="#"><%=testList.get(i).getName()%></a><font>已销售<%=testList.get(i).getNum()%>次</font></li>
						<%}%>
						</ul>
					</div>
				</div>
			</div>
			<!--
        	作者：luchao7285@163.com
        	时间：2017-03-11
        	描述：下层
        	-->
			<div id="bottom">
				<ul>
					<li>
						<a href="aboutUs.jsp">关于我们</a>
					</li>|
					<li>
						<a href="description.jsp">配送说明</a>
					</li>|
				</ul>
				Copyright(C)2015-2020
			</div>
		</div>
	</body>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*,ordersystem.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta charset="utf-8" />
		<link rel="stylesheet" type="text/css" href="css/menu.css" />
		<link rel="stylesheet" type="text/css" href="css/bodyAndBottom.css" />
		<link rel="stylesheet" type="text/css" href="css/order.css" />
		<title>我的订单</title>
		<script type="text/javascript" src="jquery.js"></script>
	</head>

	<body>
		<!--
        	作者：luchao7285@163.com
        	时间：2017-03-10
        	描述：背景层
        -->
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
								<a href="HomePageServlet"><b>首页</b></a>
							</li>
							<li>
								<a href="DinnerServlet"><b>我的餐车</b></a>
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
            <%


	List<OrderBean> orderList  = (List<OrderBean>)  request.getAttribute("order");
	out.print(orderList.size());
%>
	
			<div id="middle_order">
				
					<table border="2" cellspacing="0" cellpadding="0" bordercolor="orangered">
						<form action="OrderFindServlet" method="post">
							<tr id="app">
								<td width="200px" align="right">按菜品名称查询</td>
								<td width="300px" align="left"><input type="text" name="foodName" />
									<input type="submit"  style="width:53px; height:21px;  background: url(img/search5.gif) no-repeat center;cursor:pointer;font-size:0;line-height:0;text-indent:-9999px;"/>	
								</td>
							</tr>
						</form>
						
						<tr>
							<td colspan="2">
								<form style="display: inline-block;" action="OrderServlet" method="post"><input type="submit" value="我的所有订单"/></form>
								<form style="display: inline-block;" action="OrderFindDeliveringServlet"><input type="submit" value="未派送订单"/></form>
								<form style="display: inline-block;" action="OrderFindDeliveredServlet"><input type="submit" value="已派送订单"/></form>
							</td>
						</tr>
					</table>
				
					<br/>
					<table border="2" cellspacing="0" cellpadding="0" bordercolor="orangered">
						<tr>
							<td colspan="9"><b>订单查询结果信息列表</b></td>
						</tr>
						<tr id="list_title">
							<td>菜品名称</td>
							<td>真实姓名</td>
							<td>订购电话</td>
							<td>派送地址</td>
							<td>订购数量</td>
							<td>单价(元)</td>
							<td>合计(元)</td>
							<td style="width: 160px;">订购时间</td>
							<td>是否派送</td>
						</tr>
	
						<% 
			for(int i=0;i<orderList.size();i++){
				%>
				<tr>
					
					<td><%=orderList.get(i).getFoodName() %></td>
					<td><%=orderList.get(i).getUserName() %></td>
					<td><%=orderList.get(i).getUserPhonenum() %></td>
					<td><%=orderList.get(i).getUserAddress() %></td>
					<td><%=orderList.get(i).getFoodQuantity() %></td>
					<td><%=orderList.get(i).getFoodSinglePrice() %></td>
					<td><%=orderList.get(i).getFoodSumPrice() %></td>
					<td><%=orderList.get(i).getOrderTime() %></td>
					<td><%=orderList.get(i).getOrderDeliver() %></td>
					
				
				</tr>
				
				<%
			}
		
		%>
					</table>
			</div>
			
			<!--
        	作者：luchao7285@163.com
        	时间：2017-03-11
        	描述：下层
        	-->
			<div id="bottom" style="margin-top: 50px;">
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
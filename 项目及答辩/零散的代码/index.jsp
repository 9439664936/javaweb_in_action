<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.*,ordersystem.*, java.sql.Connection,java.sql.ResultSet"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<link rel="stylesheet" type="text/css" href="css/menu.css" />
		<link rel="stylesheet" type="text/css" href="css/context.css" />
		<link rel="stylesheet" type="text/css" href="css/bodyAndBottom.css" />
		<title>阿婆私房菜</title>
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
							<a href="userCenter.html">会员注册</a>
						</li>|
						<li>
							<a href="Login">注销退出
							</a>
						</li>|
						<li>
							<a href="description.html">配送说明</a>
						</li>|
						<li>
							<a href="aboutUs.html">关于我们</a>
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
					<div id="top_bottom_right">
					<% if(!(session.getAttribute("user_name")==null)){%>
					<%=session.getAttribute("user_name") %>,欢迎您。<% }%>
						<div id="title">
						</div>
						<ul>
							<li>
								<a href="index.jsp"><b>首页</b></a>
							</li>
							<li>
								<a href="diner.html"><b>我的餐车</b></a>
							</li>
							<li>
								<a href="order.html"><b>我的订单</b></a>
							</li>
							<li>
								<a href="userCenter.html"><b>用户中心</b></a>
							</li>
							<li>
								<a href="description.html"><b>配送说明</b></a>
							</li>
							<li>
								<a href="aboutUs.html"><b>关于我们</b></a>
							</li>
							<li>
								<a href="#"><b>注销退出</b></a>
							</li>
						</ul>
					</div>
				</div>
			</div>
			<!--
            	作者：luchao7285@163.com
            	时间：2017-03-10
            	描述：中层"C:/Users/Administrator/Desktop/apsfc html静态页面/apsfc/index.html"
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
                    
                   <%for(int i = 1;i<7;i++) {%>
						<div class="context">
							<div class="context_top">
								<div class="context_img">
									<img src="img/1253519531.jpg" />
								</div>
								<div class="context_font">
									菜名: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <b>糖醋排骨</b><br/> 市场价格: 26.0<br/> 会员价格:
									<font><b>24.0</b></font><br/> 配料: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 排骨、糖、醋<br/> <br/> <br/> 菜品类型: 炒菜
								</div>
							</div>
							<div class="context_button">
								<form style="display: inline-block;" action="CarServlet">
								<input type="hidden" name="food_id" value="<%=i%>">
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
								<a href="notice.html">本店特色《咸菜肉饭》</a>
								<font>2015-02-28</font>
							</li>
							<li>
								<a href="notice.html">本店特色《咸菜肉饭》</a>
								<font>2015-02-28</font>
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
							<a href="CarServlet">更多>></a>
						</div>
						<br/>
						<div id="diner_context_head">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;菜单名称&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;单价&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;数量
						</div>
						<div id="diner_context_foot">
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;小计：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<font>0.0</font>元&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<font>0</font>份
						</div>
						<div id="diner_context_button">
							<a href="#"><img src="img/canche_submit.gif" /></a>
							<a href="LoginServlet"><img src="img/quxiao2.gif"/></a>
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
							<li>
								<a href="show.html">糖醋排骨</a>
								<font>已销售4次</font>
							</li>
							<li>
								<a href="show.html">糖醋排骨</a>
								<font>已销售4次</font>
							</li>
							<li>
								<a href="show.html">糖醋排骨</a>
								<font>已销售4次</font>
							</li>
							<li>
								<a href="show.html">糖醋排骨</a>
								<font>已销售4次</font>
							</li>
							<li>
								<a href="show.html">糖醋排骨</a>
								<font>已销售4次</font>
							</li>
							<li>
								<a href="show.html">糖醋排骨</a>
								<font>已销售4次</font>
							</li>
							<li>
								<a href="show.html">糖醋排骨</a>
								<font>已销售4次</font>
							</li>
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
						<a href="aboutUs.html">关于我们</a>
					</li>|
					<li>
						<a href="description.html">配送说明</a>
					</li>|
				</ul>
				Copyright(C)2015-2020
			</div>
		</div>
	</body>

</html>
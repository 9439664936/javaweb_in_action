<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<link rel="stylesheet" type="text/css" href="css/menu.css" />
		<link rel="stylesheet" type="text/css" href="css/bodyAndBottom.css" />
		<link rel="stylesheet" type="text/css" href="css/login.css" />
		<title>用户登陆</title>
	</head>
<script type="text/javascript">
function checked(){
	var name = document.getElementById("account").value;
	if(name==""){
		alert("账号不能为空！");
		return false;
	}
	var name = document.getElementById("password").value;
	if(name==""){
		alert("密码不能为空！");
		return false;
	}
	
	return true;
}

</script>
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
							<a href="Login">注销退出</a>
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
					<!--
                	作者：luchao7285@163.com
                	时间：2017-03-10
                	描述：上层下块右
                -->
					<div id="top_bottom_right">
						<div id="title">
						</div>
						<ul>
							<li>
								<a href="HomePageServlet"><b>首页</b></a>
							</li>
							<li>
								<a href="CarServlet"><b>我的餐车</b></a>
							</li>
							<li>
								<a href="order.html"><b>我的订单</b></a>
							</li>
							<li>
								<a href="register.jsp"><b>用户中心</b></a>
							</li>
							<li>
								<a href="description.html"><b>配送说明</b></a>
							</li>
							<li>
								<a href="aboutUs.html"><b>关于我们</b></a>
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
			<div id="middle_login">
				<!--
                	作者：luchao7285@163.com
                	时间：2017-03-11
                	描述：登陆框背板
                -->
				<div id="login_background">
					<!--
                    	作者：luchao7285@163.com
                    	时间：2017-03-11
                    	描述：登陆框
                    -->
					<div id="login_input">
						<% if(!(session.getAttribute("user_name")==null)){
					session.invalidate() ; }%>
						<form method="post" action="LoginServlet" onsubmit='return checked()'>
							<div class="input">账号： <input type="text" id="account" name="account" /></div>
							<div class="input">密码： <input type="password" id="password" name="password" /></div>
							<div align="center"><input type="submit" values="提交"  />
							<a href="register.jsp"><img src="img/zhuce.gif" /></a>
							</div>
						</form>
					</div>
					<!--
                    	作者：luchao7285@163.com
                    	时间：2017-03-11
                    	描述：登陆提示
                    -->
					<div id="login_title">
						<ul>
							<li>如果您已经是会员，请在左侧登录</li>
							<li>如果您还没有注册会员，
								<a href="register.jsp" id="register">点这里注册新会员</a>
							</li>
							<li>如果您忘记了密码，
								<a href="#" id="resetpassword">点这里重设一个密码</a>
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
			<div id="bottom" style="margin-top: 50px;">
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
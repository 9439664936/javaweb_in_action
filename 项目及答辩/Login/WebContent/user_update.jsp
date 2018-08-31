<%@page import="login.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		UserBean user = (UserBean) request.getAttribute("update_user");
	%>
	<form action="UserUpdate" method="post">
		<input name="user_id" value="<%=user.getId() %>" type="hidden" />
		<table>
			<tr>
				<td>用户：</td>
				<td><input name="user_name" type="text" value="<%=user.getName() %>" /></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input name="user_password" type="password" value="<%=user.getPassword() %>" /></td>
			</tr>
			<tr>
				<td>性别：</td>
				<td><input name="user_sex" type="radio" value="男"
					<%
						if ("男".equals(user.getSex())) {
							%> checked="checked"<%
						}%> />男 
					<input name="user_sex" type="radio" value="女"
					<%
						if ("女".equals(user.getSex())) {
							%> checked="checked"<%
						}%> />女</td>
			</tr>
			<tr>
				<td>年龄：</td>
				<td><input name="user_age" type="number"
					value="<%=user.getAge()%>" /></td>
			</tr>
			<tr>
				<td align="center" colspan="2"><input type="reset" />&nbsp;&nbsp;
					<input type="submit" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
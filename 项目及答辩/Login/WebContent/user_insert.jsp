<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="UserInsert" method="post">
		<table>
			<tr>
				<td>姓名：</td>
				<td><input name="user_name" type="text" /></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input name="user_password" type="password" /></td>
			</tr>

			<tr>
				<td>性别：</td>
				<td><input name="user_sex" type="radio" value="男"
					checked="checked" />男 <input name="user_sex" type="radio"
					value="女" />女</td>
			</tr>
			<tr>
				<td>年龄：</td>
				<td><input name="user_age" type="number" /></td>
			</tr>
			<tr>
				<td><input type="submit" /></td>
				<td align="center"><input type="reset" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
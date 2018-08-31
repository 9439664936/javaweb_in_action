<%@page import="login.CastList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="login.UserBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<script type="text/javascript">
			function deleteUser(userId) {
				if(confirm("确认要删除吗？")) {
					window.location.href = "UserDelete?userId=" + userId;
				}
			}
		</script>
		
		<style>
			table{
				border-collapse: collapse;
			}
			table,th,td{
				border: 1px solid black;
				text-align: center;
			}
		</style>
	</head>

	<body>
		<%
		//List<UserBean> studentList =  (List<UserBean>) request.getAttribute("user_list");
		List<UserBean> studentList = CastList.castList(request.getAttribute("user_list"), UserBean.class);
		out.print(studentList.size());
	%>
		<h1><%=session.getAttribute("LoginUserName")%>，欢迎您！
	</h1>
		<table>
			<tr>
				<th width="120px">id</th>
				<th width="120px">姓名</th>
				<th width="120px">密码</th>
				<th width="120px">性别</th>
				<th width="120px">年龄</th>
				<th width="120px">修改</th>
				<th width="120px">删改</th>
			</tr>
			<%
			for (int i = 0; i < studentList.size(); i++) {
		%>
			<tr>
				<td>
					<%=studentList.get(i).getId()%>
				</td>
				<td>
					<%=studentList.get(i).getName()%>
				</td>
				<td>
					<%=studentList.get(i).getPassword()%>
				</td>
				<td>
					<%=studentList.get(i).getSex()%>
				</td>
				<td>
					<%=studentList.get(i).getAge()%>
				</td>
				<td>
					<a href="UserFind?userId=<%=studentList.get(i).getId()%>">修改</a>
				</td>
				<td>
					<a href="#" onclick="deleteUser('<%=studentList.get(i).getId() %>')">删除</a>
				</td>
			</tr>
			<%
			}
		%>

		</table>
		<h1>
		<a href="user_insert.jsp">新增</a>
	</h1>
	</body>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*,com.hp.seven.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%


	List<UserBean> studentList  = (List<UserBean>)  request.getAttribute("user_list");
	out.print(studentList.size());
%>

<script type="text/javascript">
	function deleteUser(userId){
		if(confirm("请问确认要删除吗？")){
			window.location.href = "UserDeleteServlet?userIndex="+userId;
		}
		
	}
	


</script>

</head>
<body>

<!-- 
	作用域：
	//
	
		request、session
		
 -->



<h1><%=session.getAttribute("loinUserName") %>,欢迎您。</h1>
<table border="1px" width="800px" align="center">
<tr>
	<th width="110px">ID</th>
	<th width="110px">姓名</th>
	<th width="110px">密码</th>
	<th width="110px">性别</th>
	<th width="110px">年龄</th>
	<th width="110px">修改</th>
	<th width="110px">删除</th>
</tr>
	<% 
		for(int i=0;i<studentList.size();i++){
			%>
			<tr>
				<td><%=studentList.get(i).getUserId() %></td>
				<td><%=studentList.get(i).getUserName() %></td>
				<td><%=studentList.get(i).getUserPassword() %></td>
				<td><%=studentList.get(i).getUserSex() %></td>
				<td><%=studentList.get(i).getUserAge() %></td>
				<td ><a href="UserFindServlet?userIndex=<%=studentList.get(i).getUserId() %>">修改</a></td>
				<td ><a href="#"  onclick="deleteUser('<%=studentList.get(i).getUserId() %>')">删除</a></td>
			</tr>
			
			<%
		}
	
	%>

</table>

<h1 align="center"><a href="user_insert.jsp">新增</a></h1>


</body>
</html>
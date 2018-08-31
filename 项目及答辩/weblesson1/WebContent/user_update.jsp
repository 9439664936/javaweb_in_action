<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.hp.seven.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	UserBean user = (UserBean) request.getAttribute("update_user");
%>
	<form action="UserUpdateServlet" method="post">
	
	<input name="user_index" value="<%=user.getUserId() %>" type="hidden"/>  
	
		用户 ： <input name="user_name" value="<%=user.getUserName() %>" />  <br/><br/>
		
		密码 ： <input name="user_pwd" type="password" value="<%=user.getUserPassword() %>"   />  <br/><br/>
		
		年龄 ： <input name="user_age" type="number" value="<%=user.getUserAge() %>"  />  <br/><br/>
		
		性别 ： <input name="user_sex" value="男" type="radio"
		<%
			if("男".equals(user.getUserSex())){
				%>checked="checked"<%
			}
		%> /> 男    
		 
		  <input name="user_sex" value="女" type="radio"
		 <%
			if("女".equals(user.getUserSex())){
				%>checked="checked"<%
			}
			%> /> 女   <br/><br/>
		
		<input type="reset" /> 
		 <input type="submit" />
	
	
	
	</form>
</body>
</html>
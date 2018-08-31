<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
	JSP : java server page.
	JSP 内置对象
 -->
 
 <%
 		int i = 1 ;
 		System.out.println("hello ....  "+i);
 		//out.print("hello ....  "+i);
 
 %>
 
 
 <%=i %>
 
 	<%
 		for(int a=1;a<7;a++){
 		%>
 		<h<%=a %>>hello  <%=a %>  jsp  <%=a %> file</h<%=a %>>
 		<% 
 	}
 %>
 

</body>
</html>
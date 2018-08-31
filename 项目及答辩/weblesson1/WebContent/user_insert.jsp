<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

	function check(){
		var name = document.getElementById("user_name").value;
		if(name == ""){
			alert("姓名不能为空！");
			return false ;
		}
		
		var name = document.getElementById("user_pwd").value;
		if(name == ""){
			alert("密码不能为空！");
			return false ;
		}
		
		var name = document.getElementById("user_age").value;
		if(name == ""){
			alert("年龄不能为空！");
			return false ;
		}
		
		return true; 
		
	}

</script>


</head>
<body>

	<form action="UserInsertServlet" method="post"  onsubmit='return check()'  >
	
		用户 ： <input id="user_name" name="user_name" />  <br/><br/>
		
		密码 ： <input id="user_pwd" name="user_pwd" type="password"/>  <br/><br/>
		
		年龄 ： <input id="user_age" name="user_age" type="number"/>  <br/><br/>
		
		性别 ： <input name="user_sex" value="男" type="radio" checked="checked"/> 男     <input name="user_sex" value="女" type="radio"/> 女   <br/><br/>
		
		<input type="reset" /> 
		 <input type="submit" />
	
	
	
	</form>



</body>
</html>
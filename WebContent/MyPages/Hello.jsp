<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	JSP表达式输出：<%="hello world"%>
	<br />
	<%!String str = "hello world";//这里的声明是全部变量%>
	<%
		//String str = "hello world";//这里的声明是局部变量
		out.println(str);
	%>
</body>
</html>
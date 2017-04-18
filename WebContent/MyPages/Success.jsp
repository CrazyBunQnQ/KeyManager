<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆成功</title>
<link rel="shortcut icon" href="<%= request.getContextPath() %>/MyPages/img/ico.ico" type="image/x-icon">
<link rel="icon" href="<%= request.getContextPath() %>/MyPages/img/ico.ico" type="image/x-icon">
<style type="text/css">
body {
	color: #000;
	font-size: 14px;
	margin: 20px auto;
}

#message {
	text-align: center;
}
</style>
</head>
<body>
	<div id="message">
		登录成功。<br /> 您提交的信息为：<br /> 用户名：<%=request.getParameter("uname")%><br />
		密 码：<%=request.getParameter("upwd")%><br /> <a
			href="<%=request.getContextPath()%>/MyPages/Login.jsp">返回登录页面</a>
	</div>
</body>
</html>
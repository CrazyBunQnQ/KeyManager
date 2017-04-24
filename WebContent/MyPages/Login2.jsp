<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>请登录</title>
</head>
<body>
	<%-- request.getContextPath() 用来获取站点的根路径 --%>
	<form action="<%=request.getContextPath()%>/loginServlet"
		method="post">
		userName:<input type="text" name="uname" /><br /> password:<input
			type="password" name="upwd" /><br /> <input type="submit"
			value="Login" /> <input type="reset" value="Reset" />
	</form>
	<%
		Date date = new Date();
	out.write("当前时间是：" + date);
	%>
	<% for (int i = 1; i< 7; i++) { %>
	<h<% out.write(i + ""); %>>
	标题<% out.write(i+""); %>
	<h<% out.write(i + ""); %>>
	<% } %>
	
	<%--脚本表达式 --%>
	<%= date.toLocaleString() %>
	<%-- 脚本声明 --%>
	<%!
		private String name;
		static {
			
		}
		public static void main(String[] args) {
			
		}
		public void run() {
			
		}
	%>
	
	<% 
		PrintWriter resOut = response.getWriter();
		resOut.write("我的位置在哪里");
	%>
	<!--  缓存8kb，输出顺序 -->
	out.write()顺序1)
	<% resOut.write("resOut.write(顺序2)"); %>
	<%="out.write(顺序3)" %>
	<% out.write("out.write(顺序4)"); %>
</body>
</html>
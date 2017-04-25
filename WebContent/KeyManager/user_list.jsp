<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.crazybunqnq.entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UserManage</title>
</head>
<body>
	<% List<User> list = new ArrayList<User>(); %>
	<table>
		<tr>
			<td>id</td>
			<td>用户名</td>
			<td>激活码</td>
			<td>剩余时间</td>
			<td>操作</td>
		</tr>
		<% for (User u : list) { %>
		<tr>
			<td><%= u.getId() %></td>
			<td><%= u.getName() %></td>
			<td></td>
			<td></td>
			<td>编辑，删除</td>
		</tr>
		<% } %>
	</table>
</body>
</html>
<%@page import="java.util.List"%>
<%@page import="com.crazybunqnq.entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>管理员管理</title>

		<script type="text/javascript">
			function isNick() {
				var checked = document.getElementById("isnick").checked;
				document.getElementById("isnick").value = checked ? "isnick" : "isname";
			}
		</script>
	</head>

	<body>
		<form action="<%=request.getContextPath()%>/Search?type=manager" method="post">
			<table>
				<tr>
					<td><input type="checkbox" id="isnick" name="isnick" value="isnick" onclick="isNick()" />按照昵称查询</td>
					<td><input type="search" id="name" name="name" placeholder="输入用户名" /></td>
					<td><input type="date" id="start" name="start" /></td>
					<td><input type="date" id="end" name="end" /></td>
					<td><input type="submit" onclick="return check()" value="查询" /></td>
				</tr>
			</table>
		</form>
		<%
		List<User> list = (List<User>)request.getAttribute("list");
		if (list != null) {
	%>
		<table>
			<tr>
				<td>编号</td>
				<td>管理员</td>
				<td>权限</td>
				<td>创建时间</td>
				<td>操作</td>
			</tr>
			<%
			for (User u : list) { 
		%>
			<tr>
				<td>
					<%= u.getId() %>
				</td>
				<td>
					<%= u.getName() %>
				</td>
				<td>
					<%= u.getLimit() %>
				</td>
				<td>
					<%= u.getCreateTime() %>
				</td>
				<td>编辑，删除</td>
			</tr>
			<% } %>
		</table>
		<% } %>
	</body>

</html>
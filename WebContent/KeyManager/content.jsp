<%@page import="com.crazybunqnq.entity.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<title>CrazyCompany</title>
<style>
.biao {
	margin-left: 50px;
	margin-right: 50px;
	border: #5E5E5E;
	border-bottom:;
}

.btn {
	width: 60px;
}
</style>
<link href="css/style.css" rel="stylesheet" />
</head>

<body bgcolor="#272822">
	<div class="biao">
		<table border="0" cellpadding="10" cellspacing="0" width="600">
			<tr>
				<td align="right">ID:</td>
				<td><input type="text" style="width: 60px;" /></td>
				<td align="right">Join Time</td>
				<td><input type="date" style="width: 120px;" /></td>
				<td align="right"><input type="button" value="Query"
					class="btn" /></td>
			</tr>
			<tr>
				<td align="right">Name:</td>
				<td><input type="text" style="width: 100px;" /></td>
				<td align="right">Department:</td>
				<td><input type="text" /></td>
				<td align="right"><input type="button" value="Add" class="btn" /></td>
			</tr>
		</table>
	</div>
	<div align="center" class="biao">
		<table border="1" cellspacing="0" cellpadding="10" width="100%"
			align="center">
			<tr align="center">
				<td width="50"><label for="select0">All</label><input
					type="checkbox" name="names" id="select0" /></td>
				<td width="60">ID</td>
				<td width="100">Name</td>
				<td width="50">Gender</td>
				<td width="120">Join Time</td>
				<td>Department</td>
				<td width="60">Salary</td>
				<td width="100">Operation</td>
			</tr>
			<tr align="center" id="row1">
				<td><input type="checkbox" name="names" id="select1" /></td>
				<td>F00001</td>
				<td>BaoJunJie</td>
				<td>Male</td>
				<td>2017å¹´02æ14æ¥</td>
				<td>IT</td>
				<td>99999</td>
				<td></td>
			</tr>
			<tr align="center" hidden id="row2">
				<td><input type="checkbox" name="names" id="select2" /></td>
				<td>F00001</td>
				<td>BaoJunJie</td>
				<td>Male</td>
				<td>2017å¹´02æ14æ¥</td>
				<td>IT</td>
				<td>99999</td>
				<td></td>
			</tr>
			<tr align="center" hidden id="row3">
				<td><input type="checkbox" name="names" id="select3" /></td>
				<td>F00001</td>
				<td>BaoJunJie</td>
				<td>Male</td>
				<td>2017å¹´02æ14æ¥</td>
				<td>IT</td>
				<td>99999</td>
				<td></td>
			</tr>
			<tr align="center" hidden id="row4">
				<td><input type="checkbox" name="names" id="select4" /></td>
				<td>F00001</td>
				<td>BaoJunJie</td>
				<td>Male</td>
				<td>2017å¹´02æ14æ¥</td>
				<td>IT</td>
				<td>99999</td>
				<td></td>
			</tr>
			<tr align="center" hidden id="row5">
				<td><input type="checkbox" name="names" id="select5" /></td>
				<td>F00001</td>
				<td>BaoJunJie</td>
				<td>Male</td>
				<td>2017å¹´02æ14æ¥</td>
				<td>IT</td>
				<td>99999</td>
				<td></td>
			</tr>
			<tr align="center" hidden id="row6">
				<td><input type="checkbox" name="names" id="select6" /></td>
				<td>F00001</td>
				<td>BaoJunJie</td>
				<td>Male</td>
				<td>2017å¹´02æ14æ¥</td>
				<td>IT</td>
				<td>99999</td>
				<td></td>
			</tr>
			<tr align="center" hidden id="row7">
				<td><input type="checkbox" name="names" id="select7" /></td>
				<td>F00001</td>
				<td>BaoJunJie</td>
				<td>Male</td>
				<td>2017å¹´02æ14æ¥</td>
				<td>IT</td>
				<td>99999</td>
				<td></td>
			</tr>
			<tr align="center" hidden id="row8">
				<td><input type="checkbox" name="names" id="select8" /></td>
				<td>F00001</td>
				<td>BaoJunJie</td>
				<td>Male</td>
				<td>2017å¹´02æ14æ¥</td>
				<td>IT</td>
				<td>99999</td>
				<td></td>
			</tr>
			<tr align="center" hidden id="row9">
				<td><input type="checkbox" name="names" id="select9" /></td>
				<td>F00001</td>
				<td>BaoJunJie</td>
				<td>Male</td>
				<td>2017å¹´02æ14æ¥</td>
				<td>IT</td>
				<td>99999</td>
				<td></td>
			</tr>
			<tr align="center" hidden id="row10">
				<td><input type="checkbox" name="names" id="select10" /></td>
				<td>F00001</td>
				<td>BaoJunJie</td>
				<td>Male</td>
				<td>2017å¹´02æ14æ¥</td>
				<td>IT</td>
				<td>99999</td>
				<td></td>
			</tr>
		</table>
		<table width="100%" border="0" cellpadding="10" cellspacing="0">
			<tr>
				<td align="right">ä¸ä¸é¡µ</td>
				<td width="15%" align="center"><u>1</u> 2 3 4 5</td>
				<td>ä¸ä¸é¡µ</td>
			</tr>
		</table>
	</div>

	<!-- 1.获取所有的数据 -->
	<% 
			request.getAttribute("list");
			List<User> list = (List<User>)request.getAttribute("");
		%>
	<!-- 2.显式数据 -->
	<table>
		<tr>
			<td>id</td>
			<td>姓名</td>
			<td>密码</td>
			<td>权限</td>
			<td>操作</td>
		</tr>
		<% for (User u : list) { %>
		<tr>
			<td><%= u.getId() %></td>
			<td><%= u.getName() %></td>
			<td><%= u.getPwd() %></td>
			<td><%= u.getLimit() %></td>
			<td>删除，编辑</td>
		</tr>
		<% } %>
	</table>
</body>

</html>
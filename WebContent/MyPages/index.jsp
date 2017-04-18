<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册码管理系统</title>
<link rel="shortcut icon"
	href="<%=request.getContextPath()%>/MyPages/img/ico.ico"
	type="image/x-icon">
<link rel="icon" href="<%=request.getContextPath()%>/MyPages/ico.ico"
	type="image/x-icon">
</head>
<body>
	<div align="right">
		<a href="<%=request.getContextPath()%>/MyPages/CDKeyManager.jsp"
			style="margin-right: 50px">注册码管理系统</a>
		<%
			String flag = "";
			Object obj = session.getAttribute("flag");

			if (obj != null) {
				flag = obj.toString();
			}
			if (flag.equals("login_success")) {
		%>
		管理员，您好！<a href="<%=request.getContextPath()%>/LogoutServlet"
			style="margin-left: 10px">退出</a>
		<%
			} else {
		%>
		<a href="<%=request.getContextPath()%>/MyPages/Login.jsp">登录</a>
		<%
			}
		%>
	</div>
	<br />
	<table width="100%" height="600px"
		style="background-color: #2f3640; color: #a6b0b9">
		<tr>
			<td colspan="1" width="150px">
				<ul>
					<li style="margin-top: 20px; margin-bottom: 20px">账号管理</li>
					<li style="margin-top: 20px; margin-bottom: 20px">注册码管理</li>
				</ul>
			</td>
			<td rowspan="1" style="background-color: #eeeeee; color: #292929">
				<%
					if (flag.equals("login_success")) {
				%>
				<table width="98%" border="1" cellspacing="0" cellpadding="5"
					bordercolor="silver" align="center">
					<tr bgcolor="#E8E8E8">
						<td colspan="2"></td>
						<td align="right">查找用户</td>
						<td><input type="text" id="keyword" /></td>
					</tr>
					<tr>
						<td>用户名</td>
						<td>设备号</td>
						<td>到期时间</td>
						<td>操作</td>
					</tr>
					<tr>
						<td>密 码：</td>
						<td>密 码：</td>
						<td>密 码：</td>
						<td></td>
					</tr>
				</table> <%
 	} else {
 %>
				<div align="center" style="margin: 20px;">
					欢迎来到包子的注册码管理系统！<br />您还未登录，请先登录。
				</div> <%
 	}
 %>
			</td>
		</tr>
	</table>
	<script type="text/javascript">
        document.getElementById('keyword').oninput = function() {
            var keyWord = this.value;
            var xhr = new XMLHttpRequest();
            xhr.open('POST', '<%=request.getContextPath()%>/SearchServlet?type=user&keyword=' + encodeURIComponent(keyWord), true);
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4 && xhr.status == 200) {
					handleResult(xhr.responseText);
				}
			}
			xhr.send();
		}

		function handleResult(ret) {
		    var result = eval('(' + ret + ')');
		    var data = result.data
		    alert(data.length);
		    var json = data.a1
		    alert(json.id);
			ret = JSON.parse(ret);
			ret

			if (ret.length) {
				var lis = [];
			}
		}
	</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>请登录</title>
<link rel="shortcut icon" href="<%= request.getContextPath() %>/MyPages/img/ico.ico" type="image/x-icon">
<link rel="icon" href="<%= request.getContextPath() %>/MyPages/img/ico.ico" type="image/x-icon">
<style type="text/css">
body {
	color: #000;
	font-size: 14px;
	margin: 20px auto;
}
</style>
<script type="text/javascript">
	function check(form) {
		if (document.forms.loginForm.uname.value == "") {//获取值
			alert("请输入用户名！");
			document.forms.loginForm.uname.focus();//焦点重新置入用户名
			return false;
		} else if (document.forms.loginForm.upwd.value.length == 0) {//获取值的长度
			alert("请输入密码！");
			document.forms.loginForm.upwd.focus();
			return false;//终止submit的提交
		}
	}
</script>
</head>
<body>
	<%-- request.getContextPath() 用来获取站点的根路径 --%>
	<form action="<%=request.getContextPath()%>/CheckServlet" method="post"
		name="loginForm">
		<%
			if (request.getAttribute("return_uri") != null) {
		%>
		<input type="hidden" name="return_uri"
			value="<%=request.getAttribute("return_uri")%>" />
		<%
			}
		%>

		<table border="1" cellspacing="0" cellpadding="5" bordercolor="silver"
			align="center">
			<tr>
				<td colspan="2" align="center" bgcolor="#E8E8E8">用户登录</td>
			</tr>
			<tr>
				<td>用户名：</td>
				<td><input type="text" name="uname" /></td>
			</tr>
			<tr>
				<td>密 码：</td>
				<td><input type="password" name="upwd" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					name="submit" onclick="return check(this);" /> <input type="reset"
					name="rest" /></td>
			</tr>
		</table>
	</form>
</body>
</html>
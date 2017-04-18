<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新赛道</title>
<style type="text/css">
body {
	color: #000;
	font-size: 14px;
	margin: 20px auto;
}
</style>
</head>
<body>
<%-- request.getContextPath() 用来获取站点的根路径 --%>
	<form action="<%=request.getContextPath()%>/PhotoEditor" method="post"
		name="pictureForm">
		

		<table border="1" cellspacing="0" cellpadding="5" bordercolor="silver"
			align="center">
			<tr>
				<td colspan="2" align="center" bgcolor="#E8E8E8">图片合成</td>
			</tr>
			<!-- tr>
				<td>图片名称：</td>
				<td><input type="text" name="photo_name" /></td>
			</tr-->
			<tr>
				<td>您的姓名：</td>
				<td><input type="text" name="str1" /></td>
			</tr>
			<tr>
				<td>Ta的姓名：</td>
				<td><input type="text" name="str2" /></td>
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
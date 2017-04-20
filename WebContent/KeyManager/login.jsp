<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Sign In</title>
		<link rel="shortcut icon" href="<%= request.getContextPath() %>/KeyManager/img/ico.ico" type="image/x-icon">
		<link rel="icon" href="<%= request.getContextPath() %>/KeyManager/img/ico.ico" type="image/x-icon">
		<style type="text/css">
			.title {
				height: 120px;
				line-height: 120px;
				color: #111111;
				font-size: 36px;
			}
			
			.button {
				width: 100%;
				height: 30px;
			}
		</style>
		<link href="<%=request.getContextPath()%>/KeyManager/css/loading_circle.css" rel="stylesheet" />
		<link rel="stylesheet" href="<%=request.getContextPath()%>/KeyManager/css/style.css" />

		<script type="text/javascript" src="<%=request.getContextPath()%>/KeyManager/js/captcha.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/KeyManager/js/form.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/KeyManager/js/index.js"></script>
		<script type="text/javascript">
			var result;
			var vcode; //生成的验证码
			var imgDataURL;

			function checkCaptcha(v) {
				var flag = (v.toLowerCase() === vcode);
				if(flag) {
					document.getElementById("captchaFlag").style.color = "#0000DD";
					document.getElementById("captchaFlag").innerHTML = "√";
				} else {
					document.getElementById("captchaFlag").style.color = "#DD0000";
					document.getElementById("captchaFlag").innerHTML = "×";
				}
			}

			function changeImg() {
				result = createCaptcha();
				vcode = result.code; //生成的验证码
				imgDataURL = result.dataURL; //生成的 base64 图片
				document.getElementById("captchaImg").src = imgDataURL;
			}

			function check() {
				if(document.getElementById("uname").value === "") { //用户名是否为空
					alert("请输入用户名！")
					document.getElementById("uname").focus(); //获取焦点
					return false;
				} else if(document.getElementById("upwd").value.length === 0) { //密码的长度是否为0
					alert("请输入密码！");
					document.getElementById("upwd").focus();
					return false;
				} else if(document.getElementById("captcha").value != vcode) {
					alert("验证码错误！");
					document.getElementById("captcha").focus();
					changeImg();
					return false;
				}
			}

			function goRegister() {
				var width = 400;
				var height = 600;
				var left = (screen.availWidth - width) / 2;
				var top = (screen.availHeight - height) / 2;
				var myWindow = window.open("<%=request.getContextPath()%>/KeyManager/register.html", "", "width=500,height=600,top=" + top + ",left=" + left);
			}
		</script>
	</head>

	<body background="<%=request.getContextPath()%>/KeyManager/img/bg.jpg" onload="changeImg()">
		<div class="preloader">
			<div class="sk-spinner sk-spinner-wordpress">
				<span class="sk-inner-circle"></span>
			</div>
		</div>

		<div align="center" class="title">KeyManager</div>
		<div class="info" align="center">
			<table border="0" cellspacing="0" cellpadding="0" width="100%" height="220">
				<tr>
					<td width="50%"></td>
					<td width="30%">
						<form action="<%=request.getContextPath()%>/CheckLogin" method="post" name="loginForm" style="height: 100%;">
							<table border="1" bordercolor="#666666" cellpadding="9" cellspacing="0" width="100%" height="100%">
								<tr height="25%">
									<td>UserName:</td>
									<td colspan="2" align="center"><input type="text" id="uname" name="uname" placeholder="UserName Or E-Mail" class="text" /></td>
								</tr>
								<tr height="25%">
									<td>PassWord:</td>
									<td colspan="2" align="center"><input type="password" id="upwd" name="upwd" placeholder="Password" class="text" /></td>
								</tr>
								<tr height="25%">
									<td>SecurityCode:</td>
									<td align="center"><input id="captcha" type="text" value="" onblur="checkCaptcha(this.value)" class="text" /></td>
									<td align="center"><img id="captchaImg" alt="验证码" src="" onclick="changeImg()" width="90" height="30"></td>
								</tr>
								<tr height="25%">
									<td colspan="3" align="center">
										<table border="0" cellspacing="0" cellpadding="4" width="100%" height="100%">
											<tr>
												<td width="33%" align="center">
													<input type="submit" id="login" onclick="return check()" value="Sign in" class="button" />
												</td>
												<td align="center">
													<input type="reset" value="Reset" class="button" />
												</td>
												<td width="33%" align="center">
													<input type="button" value="Sign up" onclick="goRegister()" class="button" />
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</form>
					</td>
					<td>
						<table border="0" cellpadding="10" cellspacing="0" width="100%" height="100%" align="left">
							<tr height="25%">
								<td><b id="unameFlag"></b></td>
							</tr>
							<tr height="25%">
								<td><b id="upwdFlag"></b></td>
							</tr>
							<tr height="25%">
								<td><b id="captchaFlag"></b></td>
							</tr>
							<tr>
								<td></td>
							</tr>
						</table>
					</td>
				</tr>
			</table>

		</div>

		<script src="<%=request.getContextPath()%>/KeyManager/js/jquery.js"></script>
		<script src="<%=request.getContextPath()%>/KeyManager/js/custom.js"></script>
	</body>

</html>
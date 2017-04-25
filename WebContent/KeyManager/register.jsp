<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
			
		<title>Sign Up</title>
		
		<link rel="shortcut icon" href="<%= request.getContextPath() %>/KeyManager/img/ico.ico" type="image/x-icon">
		<link rel="icon" href="<%= request.getContextPath() %>/KeyManager/img/ico.ico" type="image/x-icon">
		
		<link rel="stylesheet" href="css/style.css" />

		<script type="text/javascript" src="<%=request.getContextPath()%>/KeyManager/js/captcha.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/KeyManager/js/form.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath()%>/KeyManager/js/index.js"></script>
		<script type="text/javascript">
			function check() {
				if(
					$("unameFlag").style.color === "#DD0000" ||
					$("upwdFlag").style.color === "#DD0000" ||
					$("upwd2Flag").style.color === "#DD0000" ||
					$("nickFlag").style.color === "#DD0000" ||
					$("sexFlag").style.color === "#DD0000" ||
					$("ageFlag").style.color === "#DD0000" ||
					$("phoneFlag").style.color === "#DD0000"
				) {
					return false;
				}
			}
		</script>
	</head>

	<body onload="changeImg()">
		<div style="width: 100%; height: 100%;">
			<table border="0" cellspacing="0" cellpadding="0" width="100%" height="100%">
				<tr>
					<td width="20%"></td>
					<td width="60%">
						<form action="<%=request.getContextPath()%>/Register" method="post">
							<table border="0" cellspacing="0" cellpadding="5" width="100%" height="100%">
								<tr height="50">
									<td colspan="2" align="center" style="font-size: 30px; font-family:'微软雅黑'; line-height: 40px;">Sign Up</td>
								</tr>
								<tr height="30">
									<td align="center" colspan="2">
										<label id="tip" style="color: red;font-size: 13px;"></label>
									</td>
								</tr>
								<tr height="44">
									<td colspan="2">
										<input id="uname" name="uname" onblur="checkName(this.value)" type="text" class="text" placeholder="UserName Or E-Mail" />
									</td>
								</tr>
								<tr height="44">
									<td colspan="2">
										<input id="upwd" name="upwd" onblur="checkPwd(this.value)" type="password" class="text" placeholder="Password" />
									</td>
								</tr>
								<tr height="44">
									<td colspan="2">
										<input id="upwd2" onblur="checkTwoPwd(this.value)" type="password" class="text" placeholder="Confirm Password" />
									</td>
								</tr>
								<tr height="44">
									<td colspan="2">
										<input id="nick" name="nick" onblur="checkNick(this.value)" type="text" class="text" placeholder="Nick Name" />
									</td>
								</tr>
								<tr height="44">
									<td colspan="2">
										<input id="sex" name="sex" onblur="checkSex(this.value)" type="text" class="text" placeholder="sex" />
									</td>
								</tr>
								<tr height="44">
									<td colspan="2">
										<input id="age" name="age" onblur="checkAge(this.value)" type="text" class="text" placeholder="Age" />
									</td>
								</tr>
								<tr height="44">
									<td colspan="2">
										<input id="phone" name="phone" onblur="checkPhone(this.value)" type="text" class="text" placeholder="Mobile Phone Number" />
									</td>
								</tr>
								<tr height="44">
									<td colspan="2">
										<input id="wechat" name="wechat" onblur="checkWeChat(this.value)" type="text" class="text" placeholder="WeChat Number" />
									</td>
								</tr>
								<tr height="44">
									<td colspan="2">
										<input id="qq" name="qq" onblur="checkQQ(this.value)" type="text" class="text" placeholder="QQ Number" />
									</td>
								</tr>
								<tr height="44">
									<td width="35%">
										<img id="captchaImg" src="" alt="验证码" onclick="changeImg()" />
									</td>
									<td style="padding-right: 16px;">
										<input id="captcha" onchange="checkCaptcha(this.value)" type="text" class="text" placeholder="Captcha" />
									</td>
								</tr>
								<tr height="44">
									<td colspan="2" align="center" style="padding-top: 0px; padding-bottom: 0px; padding-right: 15px;">
										<input type="submit" class="button" value="Sign Up" onclick="return check()" />
									</td>
								</tr>
							</table>
						</form>
					</td>
					<td width="20%">
						<table border="0" cellspacing="0" cellpadding="0" align="left">
							<tr height="80">
								<td>
								</td>
							</tr>
							<tr height="44">
								<td>
									<b id="unameFlag"></b>
								</td>
							</tr>
							<tr height="44">
								<td>
									<b id="upwdFlag"></b>
								</td>
							</tr>
							<tr height="44">
								<td>
									<b id="upwd2Flag"></b>
								</td>
							</tr>
							<tr height="44">
								<td>
									<b id="nickFlag"></b>
								</td>
							</tr>
							<tr height="44">
								<td>
									<b id="sexFlag"></b>
								</td>
							</tr>
							<tr height="44">
								<td>
									<b id="ageFlag"></b>
								</td>
							</tr>
							<tr height="44">
								<td>
									<b id="phoneFlag"></b>
								</td>
							</tr>
							<tr height="44">
								<td>
								</td>
							</tr>
							<tr height="44">
								<td>
								</td>
							</tr>
							<tr height="44">
								<td>
									<b id="captchaFlag"></b>
								</td>
							</tr>
							<tr height="44">
								<td>
								</td>
							</tr>
						</table>
					</td>
				</tr>
			</table>
		</div>
	</body>

</html>
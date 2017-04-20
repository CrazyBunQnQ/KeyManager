var result;
var vcode; //生成的验证码
var imgDataURL;

function showTips(v) {
	$("tip").innerHTML = v;
}

function changeImg() {
	result = createCaptcha();
	vcode = result.code; //生成的验证码
	imgDataURL = result.dataURL; //生成的 base64 图片
	$("captchaImg").src = imgDataURL;
}

function checkCaptcha(v) {
	if(v === "") {
		return;
	}
	var flag = (v.toLowerCase() === vcode);
	if(flag) {
		document.getElementById("captchaFlag").style.color = "#0000DD";
		document.getElementById("captchaFlag").innerHTML = "√";
	} else {
		document.getElementById("captchaFlag").style.color = "#DD0000";
		document.getElementById("captchaFlag").innerHTML = "×";
		showTips("验证码输入错误");
	}
}

function checkName(v) {
	if(v === "") {
		return;
	}
	var flag = v.match(/^[0-9A-Za-z_]{4,20}$/);
	if(flag) {
		$("unameFlag").style.color = "#0000DD";
		$("unameFlag").innerHTML = "√";
	} else {
		$("unameFlag").style.color = "#DD0000";
		$("unameFlag").innerHTML = "×";
		showTips("用户名为 4~20 位数字、字母或下划线");
	}
}

function checkPwd(v) {
	if(v === "") {
		return;
	}
	var flag = v.match(/^[0-9A-Za-z_]{6,32}$/);
	if(flag) {
		$("upwdFlag").style.color = "#0000DD";
		$("upwdFlag").innerHTML = "√";
	} else {
		$("upwdFlag").style.color = "#DD0000";
		$("upwdFlag").innerHTML = "×";
		showTips("密码为 6~32 位数字、字母或下划线");
	}
}

function checkTwoPwd(v) {
	if(v === "") {
		return;
	}
	var flag = (v === $("upwd").value);
	if(flag) {
		$("upwd2Flag").style.color = "#0000DD";
		$("upwd2Flag").innerHTML = "√";
	} else {
		$("upwd2Flag").style.color = "#DD0000";
		$("upwd2Flag").innerHTML = "×";
		showTips("两次输入的密码不一致");
	}
}

function checkNick(v) {
	if(v === "") {
		return;
	}
	var flag = v.match(/^[.]{6,16}$/);
	if(flag) {
		$("nickFlag").style.color = "#0000DD";
		$("nickFlag").innerHTML = "√";
	} else {
		$("nickFlag").style.color = "#DD0000";
		$("nickFlag").innerHTML = "×";
		showTips("昵称为 6~16 位字符");
	}
}

function checkSex(v) {
	if(v === "") {
		return;
	}
	showTips(v);
	var flag = v.match(/^(([FfMmWwBbGg男女公母])|([Mm]ale)|([Ff]emale)|([Mm]an)|([Ww]oman)|([Bb]oy)|([Gg]irl))$/);
	if(flag) {
		$("sexFlag").style.color = "#0000DD";
		$("sexFlag").innerHTML = "√";
	} else {
		$("sexFlag").style.color = "#DD0000";
		$("sexFlag").innerHTML = "×";
		showTips("性别输入有误");
	}
}

function checkAge(v) {
	if(v === "") {
		return;
	}
	showTips(parseInt(v));
	var flag = isNaN(v) ? false : (v > 199 ? false : (v < 12 ? false : v.match(/^[0]*[1-9]\d{0,2}$/)));
	if(flag) {
		$("ageFlag").style.color = "#0000DD";
		$("ageFlag").innerHTML = "√";
	} else {
		$("ageFlag").style.color = "#DD0000";
		$("ageFlag").innerHTML = "×";
		showTips("年龄输入有误");
	}
}

function checkPhone(v) {
	if(v === "") {
		return;
	}
	showTips(v);
	var flag = v.match(/^((0{0,1}(13[0-9]|15[7-9]|153|156|18[7-9])[0-9]{8})|((0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?))$/);
	if(flag) {
		$("nickFlag").style.color = "#0000DD";
		$("nickFlag").innerHTML = "√";
	} else {
		$("nickFlag").style.color = "#DD0000";
		$("nickFlag").innerHTML = "×";
		showTips("电话输入有误");
	}
}
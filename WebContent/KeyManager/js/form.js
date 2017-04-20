var result;
var vcode; //生成的验证码
var imgDataURL;

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
	}
}

function checkName(v) {
	if(v === "") {
		return;
	}
	showTips(v);
	var flag = v.match(/^[0-9A-Za-z_]{4,20}$/);
	if(flag) {
		$("unameFlag").style.color = "#0000DD";
		$("unameFlag").innerHTML = "√";
	} else {
		$("unameFlag").style.color = "#DD0000";
		$("unameFlag").innerHTML = "×";
	}
}

function checkPwd(v) {
	if(v === "") {
		return;
	}
	showTips(v);
	var flag = v.match(/^[0-9A-Za-z_]{6,32}$/);
	if(flag) {
		$("upwdFlag").style.color = "#0000DD";
		$("upwdFlag").innerHTML = "√";
	} else {
		$("upwdFlag").style.color = "#DD0000";
		$("upwdFlag").innerHTML = "×";
	}
}

function checkTwoPwd(v) {
	if(v === "") {
		return;
	}
	showTips(v);
	var flag = (v === $("upwd").value);
	if(flag) {
		$("upwd2Flag").style.color = "#0000DD";
		$("upwd2Flag").innerHTML = "√";
	} else {
		$("upwd2Flag").style.color = "#DD0000";
		$("upwd2Flag").innerHTML = "×";
	}
}

function checkNick(v) {
	if(v === "") {
		return;
	}
	showTips(v);
	var flag = v.match(/^[0-9A-Za-z_]{6,20}$/);
	if(flag) {
		$("nickFlag").style.color = "#0000DD";
		$("nickFlag").innerHTML = "√";
	} else {
		$("nickFlag").style.color = "#DD0000";
		$("nickFlag").innerHTML = "×";
	}
}

function checkSex(v) {
	if(v === "") {
		return;
	}
	showTips(v);
	var flag = v.match(/^(([FfMmWwBbGg男女])|([Mm]ale)|([Ff]emale)|([Mm]an)|([Ww]oman)|([Bb]oy)|([Gg]irl))$/);
	if(flag) {
		$("sexFlag").style.color = "#0000DD";
		$("sexFlag").innerHTML = "√";
	} else {
		$("sexFlag").style.color = "#DD0000";
		$("sexFlag").innerHTML = "×";
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
	}
}

function checkWeChat(v) {
	if(v === "") {
		return;
	}
	showTips(v);
	var flag = v.match(/^[0-9A-Za-z_]{6,20}$/);
	if(flag) {
		$("nickFlag").style.color = "#0000DD";
		$("nickFlag").innerHTML = "√";
	} else {
		$("nickFlag").style.color = "#DD0000";
		$("nickFlag").innerHTML = "×";
	}
}

function checkQQ(v) {
	if(v === "") {
		return;
	}
	showTips(v);
	var flag = v.match(/^[0-9A-Za-z_]{6,20}$/);
	if(flag) {
		$("nickFlag").style.color = "#0000DD";
		$("nickFlag").innerHTML = "√";
	} else {
		$("nickFlag").style.color = "#DD0000";
		$("nickFlag").innerHTML = "×";
	}
}
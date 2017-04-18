package com.crazybunqnq.enums;

import java.awt.Color;
import java.awt.Font;

import com.crazybunqnq.entity.ImgStringSetting;

public enum Images {
	Test("测试", 3, new ImgStringSetting(new Font("宋体", Font.PLAIN, 36), 200, 200), new ImgStringSetting(new Font("微软雅黑", Font.PLAIN, 36), 200, 300, Color.YELLOW), new ImgStringSetting(new Font("黑体", Font.BOLD, 36), 200, 400, Color.GREEN)),
	XinNian("新年", 2, new ImgStringSetting(new Font("微软雅黑", Font.PLAIN, 36), 200, 200), new ImgStringSetting(new Font("微软雅黑", Font.PLAIN, 36), 200, 300, Color.BLUE)), 
	ChunJie("春节", 2, new ImgStringSetting(new Font("宋体", Font.PLAIN, 36), 200, 200), new ImgStringSetting(new Font("宋体", Font.PLAIN, 36), 200, 300, Color.RED)), 
	YuRenJie("愚人节", 3, new ImgStringSetting(new Font("宋体", Font.PLAIN, 36), 200, 200), new ImgStringSetting(new Font("宋体", Font.PLAIN, 36), 200, 300, Color.YELLOW), new ImgStringSetting(new Font("宋体", Font.PLAIN, 36), 200, 400, Color.GREEN));

	private String imgName;
	private int strCount;
	private ImgStringSetting firstStringSetting;
	private ImgStringSetting secondStringSetting;
	private ImgStringSetting thirdStringSetting;

	private Images(String imgName, int strCount, ImgStringSetting firstString) {
		this.imgName = imgName;
		this.strCount = strCount;
		this.firstStringSetting = firstString;
		this.secondStringSetting = null;
		this.thirdStringSetting = null;
	}

	private Images(String imgName, int strCount, ImgStringSetting firstString, ImgStringSetting secondString) {
		this.imgName = imgName;
		this.strCount = strCount;
		this.firstStringSetting = firstString;
		this.secondStringSetting = secondString;
		this.thirdStringSetting = null;
	}

	private Images(String imgName, int strCount, ImgStringSetting firstString, ImgStringSetting secondString, ImgStringSetting thirdString) {
		this.imgName = imgName;
		this.strCount = strCount;
		this.firstStringSetting = firstString;
		this.secondStringSetting = secondString;
		this.thirdStringSetting = thirdString;
	}

	public String getImgName() {
		return imgName;
	}
	
	public int getStrCount() {
		return strCount;
	}

	public ImgStringSetting getFirstSetting() {
		return firstStringSetting;
	}

	public ImgStringSetting getSecondSetting() {
		return secondStringSetting;
	}

	public ImgStringSetting getThirdSetting() {
		return thirdStringSetting;
	}

}

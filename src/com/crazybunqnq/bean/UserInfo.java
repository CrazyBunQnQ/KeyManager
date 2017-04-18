package com.crazybunqnq.bean;

import java.io.Serializable;

/**
 * 用户信息类
 * 
 * @author CrazyBunQnQ
 *
 */
public class UserInfo implements Serializable {
	private static final long serialVersionUID = -5413034404883669633L;
	private String name;
	private String pwd;
	private String nickName;
	private String sex;
	private int age;
	private String phoneNumber;
	private String WeChat;
	private String QQ;

	public UserInfo() {

	}

	/**
	 * 构造器
	 * 
	 * @param name
	 *            用户名
	 * @param pwd
	 *            密码
	 * @param nickName
	 *            昵称
	 * @param sex
	 *            性别
	 * @param age
	 *            年龄
	 * @param phoneNumber
	 *            练习电话
	 * @param WeChat
	 *            微信
	 * @param QQ
	 *            QQ
	 */
	public UserInfo(String name, String pwd, String nickName, String sex, int age, String phoneNumber, String WeChat,
			String QQ) {
		super();
		this.name = name;
		this.pwd = pwd;
		this.nickName = nickName;
		this.sex = sex;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.WeChat = WeChat;
		this.QQ = QQ;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getWeChat() {
		return WeChat;
	}

	public void setWeChat(String WeChat) {
		this.WeChat = WeChat;
	}

	public String getQQ() {
		return QQ;
	}

	public void setQQ(String QQ) {
		this.QQ = QQ;
	}

	@Override
	public String toString() {
		return "UserInfo [name=" + name + ", pwd=" + pwd + ", realName=" + nickName + ", sex=" + sex + ", age=" + age
				+ ", phoneNumber=" + phoneNumber + ", WeChat=" + WeChat + ", QQ=" + QQ + "]";
	}
}

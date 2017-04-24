package com.crazybunqnq.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息类
 * 
 * @author CrazyBunQnQ
 *
 */
public class User implements Serializable {
	private static final long serialVersionUID = -5413034404883669633L;
	/**
	 * 用户唯一标识
	 */
	private Long id;
	/**
	 * 用户名
	 */
	private String name;
	/**
	 * 密码
	 */
	private String pwd;
	/**
	 * 权限 0-7
	 * 
	 * 0：普通用户
	 */
	private int limit;
	/**
	 * 昵称
	 */
	private String nickName;
	/**
	 * 性别
	 */
	private String sex;
	/**
	 * 年龄
	 */
	private int age;
	/**
	 * 电话号码
	 */
	private String phoneNumber;
	/**
	 * 微信号
	 */
	private String WeChat;
	/**
	 * QQ 号
	 */
	private String QQ;
	/**
	 * 创建时间
	 */
	private Date createTime;

	public User() {

	}
	
	/**
	 * 构造器
	 */
	public User(Long id, String name, String pwd, Integer limit, String nickName, String sex, Integer age, String phoneNumber,
			String weChat, String qQ, Date createTime) {
		super();
		this.id = id <= 0? 0: id;
		this.name = name;
		this.pwd = pwd;
		this.limit = limit;
		this.nickName = nickName;
		this.sex = sex;
		this.age = age;
		this.phoneNumber = phoneNumber;
		WeChat = weChat;
		QQ = qQ;
		this.createTime = createTime;
	}

	public long getId() {
		return id;
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

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
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

	public int getPhoneNumber() {
		// TODO 字符串转数字：+86改为00
		return 1;
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

	public Date getCreateTime() {
		return createTime;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", pwd=" + pwd + ", limit=" + limit + ", nickName=" + nickName
				+ ", sex=" + sex + ", age=" + age + ", phoneNumber=" + phoneNumber + ", WeChat=" + WeChat + ", QQ=" + QQ
				+ ", createTime=" + createTime + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((QQ == null) ? 0 : QQ.hashCode());
		result = prime * result + ((WeChat == null) ? 0 : WeChat.hashCode());
		result = prime * result + age;
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + limit;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((nickName == null) ? 0 : nickName.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((pwd == null) ? 0 : pwd.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (QQ == null) {
			if (other.QQ != null)
				return false;
		} else if (!QQ.equals(other.QQ))
			return false;
		if (WeChat == null) {
			if (other.WeChat != null)
				return false;
		} else if (!WeChat.equals(other.WeChat))
			return false;
		if (age != other.age)
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (id != other.id)
			return false;
		if (limit != other.limit)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nickName == null) {
			if (other.nickName != null)
				return false;
		} else if (!nickName.equals(other.nickName))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (pwd == null) {
			if (other.pwd != null)
				return false;
		} else if (!pwd.equals(other.pwd))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		return true;
	}
}

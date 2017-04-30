package com.crazybunqnq.entity;

import java.io.Serializable;

public class CDKey extends IdEntity implements Serializable {

	private static final long serialVersionUID = -6314930523394564879L;
	private String cdkey;
	private String deviceID;
	private int days;
	private Long userId;

	public String getCDKey() {
		return cdkey;
	}

	public void setCDKey(String cdkey) {
		this.cdkey = cdkey;
	}

	public String getDeviceID() {
		return deviceID;
	}

	public void setDeviceID(String deviceID) {
		this.deviceID = deviceID;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public int getDays() {
		return days;
	}
	
	public void setDays(int days) {
		this.days = days;
	}

	@Override
	public String toString() {
		return "CDKey [cdkey=" + cdkey + ", deviceID=" + deviceID + ", days=" + days + ", userId=" + userId + ", id=" + id + "]";
	}
}

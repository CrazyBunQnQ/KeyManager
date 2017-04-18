package com.crazybunqnq.dao;

import com.crazybunqnq.bean.UserInfo;

public interface UserInfoDAO {
public UserInfo findUserInfoByUserName(String name);
public UserInfo findUserInfoById(int id);

}

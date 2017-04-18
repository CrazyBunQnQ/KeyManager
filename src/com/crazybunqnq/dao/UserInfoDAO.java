package com.crazybunqnq.dao;

import com.crazybunqnq.entity.UserInfo;

public interface UserInfoDAO {
public UserInfo findUserInfoByUserName(String name);
public UserInfo findUserInfoById(int id);

}

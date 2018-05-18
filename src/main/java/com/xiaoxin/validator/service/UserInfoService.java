package com.xiaoxin.validator.service;

import com.xiaoxin.model.UserInfo;

/**
 * @Auther zhangyongxin
 * @date 2018/5/18 下午8:07
 */
public interface UserInfoService {

    UserInfo queryUserInfo(int id);

    int addUserInfo(UserInfo userInfo);
}

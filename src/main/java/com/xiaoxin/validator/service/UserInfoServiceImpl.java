package com.xiaoxin.validator.service;

import com.xiaoxin.dao.UserInfoMapper;
import com.xiaoxin.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Auther zhangyongxin
 * @date 2018/5/18 下午8:08
 */
@Service
public class UserInfoServiceImpl implements UserInfoService{
    @Autowired(required = false)
    private UserInfoMapper userInfoMapper;
    @Override
    public UserInfo queryUserInfo(int id) {
        return userInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int addUserInfo(UserInfo userInfo) {
        userInfoMapper.insert(userInfo);
        int id = userInfo.getId();
        return id;
    }
}

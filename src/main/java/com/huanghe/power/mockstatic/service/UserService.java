package com.huanghe.power.mockstatic.service;

import com.huanghe.power.common.User;
import com.huanghe.power.mockstatic.dao.UserDao;

/**
 * @Author huanghe
 * @Date 2020/1/15 19:42
 * @Description
 */
public class UserService {


    /**
     * 查询用户数
     */
    public int queryUserCount(){
        return UserDao.getCount();
    }


    /**
     * 插入用户
     * @param user
     */
    public void saveUser(User user){
        UserDao.insertUser(user);
    }
}

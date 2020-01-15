package com.huanghe.power.helloworld.service;

import com.huanghe.power.common.User;
import com.huanghe.power.helloworld.dao.UserDao;

/**
 * @Author huanghe
 * @Date 2020/1/15 19:42
 * @Description
 */
public class UserService {

    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * 查询用户数
     */
    public int queryUserCount(){
        return userDao.getCount();
    }


    /**
     * 插入用户
     * @param user
     */
    public void insertUser(User user){
        userDao.insertUser(user);
    }
}

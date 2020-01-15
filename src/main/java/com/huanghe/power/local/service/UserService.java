package com.huanghe.power.local.service;

import com.huanghe.power.common.User;
import com.huanghe.power.local.dao.UserDao;

/**
 * @Author huanghe
 * @Date 2020/1/15 19:42
 * @Description mock局部变量
 */
public class UserService {


    /**
     * 查询用户数
     */
    public int queryUserCount(){
        UserDao userDao = new UserDao();
        return userDao.getCount();
    }


    /**
     * 插入用户
     * @param user
     */
    public void saveUser(User user){
        UserDao userDao = new UserDao();
        userDao.insertUser(user);
    }
}

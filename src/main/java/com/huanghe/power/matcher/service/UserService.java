package com.huanghe.power.matcher.service;

import com.huanghe.power.common.User;
import com.huanghe.power.matcher.dao.UserDao;

/**
 * @Author huanghe
 * @Date 2020/1/15 19:42
 * @Description mock局部变量
 */
public class UserService {


    public String find(String name) {
        UserDao userDao = new UserDao();
        return userDao.queryByName(name);
    }
}

package com.huanghe.power.construction;

/**
 * @Author huanghe
 * @Date 2020/1/15 22:54
 * @Description
 */
public class UserService {

    public void save(String name, String password) {

        UserDao userDao = new UserDao(name, password);
        userDao.insert();
    }
}

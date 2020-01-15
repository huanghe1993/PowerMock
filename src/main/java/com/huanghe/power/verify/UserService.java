package com.huanghe.power.verify;


import com.huanghe.power.common.User;

/**
 * @Author huanghe
 * @Date 2020/1/15 22:33
 * @Description
 */
public class UserService {

    public void savaOrUpdate(User user){
        UserDao userDao = new UserDao();

        if (userDao.getCount(user) > 0) {
            userDao.updateUser(user);
        } else {
            userDao.insertUser(user);
        }
    }
}

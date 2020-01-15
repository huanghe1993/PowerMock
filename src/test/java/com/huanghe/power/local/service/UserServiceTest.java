package com.huanghe.power.local.service;

import com.huanghe.power.common.User;
import com.huanghe.power.helloworld.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.powermock.api.mockito.PowerMockito.doNothing;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.whenNew;

/**
 * 使用 @RunWith(PowerMockRunner.class) 可以把userDao注入到函数体中
 * 做测试的时候需要改变的是UserService的对象
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({UserService.class})
public class UserServiceTest {

    @Test
    public void queryUserCount() {

        try{
            UserService userService = new UserService();

            // mock一个userDao对象
            UserDao userDao = mock(UserDao.class);
            // 当使用new UserDao创建对象时候，返回mock出来的对象
            whenNew(UserDao.class).withNoArguments().thenReturn(userDao);

            PowerMockito.doReturn(10).when(userDao).getCount();

            int count = userService.queryUserCount();

            assertEquals(10,count);

        }catch (Throwable e){
            fail();
        }
    }

    @Test
    public void saveUser() {

        try{
            UserService userService = new UserService();

            UserDao userDao = mock(UserDao.class);
            whenNew(UserDao.class).withAnyArguments().thenReturn(userDao);

            User user = new User();
            doNothing().when(userDao).insertUser(user);

            userService.saveUser(user);

            Mockito.verify(userDao,Mockito.timeout(1)).insertUser(user);

        }catch (Throwable e){

            fail();

        }
    }
}
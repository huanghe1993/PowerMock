package com.huanghe.power.mockfinal.service;


import com.huanghe.power.mockfinal.dao.UserDao;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;
@RunWith(PowerMockRunner.class)
@PrepareForTest({UserService.class,UserDao.class})
public class UserServiceTest {

    @Mock
    private UserDao userDao;

    /**
     * 使用 Mockito无法mock final修饰的
     */
    @Ignore
    @Test
    public void testQueryUserCountWithMockito() {
        MockitoAnnotations.initMocks(this);
        UserService userService = new UserService(userDao);
        Mockito.when(userDao.getCount()).thenReturn(10);
        assertEquals(10,userService.queryUserCount());
    }

    @Test
    public void testQueryUserCountWithPowerMock() {
        UserDao dao = PowerMockito.mock(UserDao.class);
        PowerMockito.when(dao.getCount()).thenReturn(10);
        UserService userService = new UserService(dao);

        assertEquals(10,userService.queryUserCount());
    }
}
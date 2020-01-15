package com.huanghe.power.helloworld.service;

import com.huanghe.power.common.User;
import com.huanghe.power.helloworld.dao.UserDao;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class UserServiceTest {

    private UserService userService;

    @Mock
    private UserDao userDao;


    /**
     * 使用PowerMock进行测试,有返回值
     * 语法：when ...do...
     */
    @Test
    public void testQueryUserCountWithPowerMock(){
        UserDao uDao = PowerMockito.mock(UserDao.class);
        PowerMockito.when(uDao.getCount()).thenReturn(10);
        UserService userService = new UserService(uDao);
        int result = userService.queryUserCount();
        assertEquals(10,result);

    }


    /**
     * 使用PowerMock进行测试,无返回值
     * 语法：when ...do...
     */
    @Test
    public void testInsertUserCountWithPowerMock(){
        UserDao uDao = PowerMockito.mock(UserDao.class);

        User user = new User();
        // 执行无法值的方法什么都不做
        PowerMockito.doNothing().when(uDao).insertUser(user);

        UserService userService = new UserService(uDao);
        userService.insertUser(user);

        // 判断UserDao的insert方法是否被调用
        Mockito.verify(uDao).insertUser(user);
    }



    /**
     * 使用Mockito测试
     */
    @Ignore
    @Test
    public void testQueryUserCountWithMockito() {

        MockitoAnnotations.initMocks(this);

        UserService userService = new UserService(userDao);
        // 录制mock对象的行为
        Mockito.when(userDao.getCount()).thenReturn(10);

        assertEquals(10, userService.queryUserCount());
    }

    @Ignore
    @Before
    public void setup(){
        userService = new UserService(new UserDao());
    }

    @Ignore
    @Test
    public void queryUserCountWithJunit() {
        try {
            userService.queryUserCount();
            fail("should not process to here");
        } catch (Exception e) {
            assertTrue(e instanceof UnsupportedOperationException);
        }
    }

    @Test
    public void insertUserWithJunit() {
        try {
            userService.insertUser(new User());
            fail("should not process to here");
        } catch (Exception e) {
            assertTrue(e instanceof UnsupportedOperationException);
        }

    }
}
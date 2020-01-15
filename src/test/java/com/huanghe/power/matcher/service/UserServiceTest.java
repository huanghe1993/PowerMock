package com.huanghe.power.matcher.service;

import com.huanghe.power.matcher.dao.UserDao;
import jdk.nashorn.internal.runtime.regexp.joni.constants.Arguments;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;

@RunWith(PowerMockRunner.class)
@PrepareForTest({UserService.class})
public class UserServiceTest {

    @Test
    public void find() throws Exception {
        UserDao userDaoMock = PowerMockito.mock(UserDao.class);
        PowerMockito.whenNew(UserDao.class).withAnyArguments().thenReturn(userDaoMock);

        //录制userDao的行为
        PowerMockito.when(userDaoMock.queryByName("river")).thenReturn("huanghe");
        String river = new UserService().find("river");
        assertEquals("huanghe", river);

        //录制userDao的行为2
        PowerMockito.when(userDaoMock.queryByName("River")).thenReturn("huanghe");
        String river2 = new UserService().find("River");
        assertEquals("huanghe", river2);
    }


    @Test
    public void testFindWithAnswer() throws Exception {
        UserDao userDaoMock = PowerMockito.mock(UserDao.class);
        PowerMockito.whenNew(UserDao.class).withAnyArguments().thenReturn(userDaoMock);

        //录制userDao的行为
        PowerMockito.when(userDaoMock.queryByName(any())).then(invocation -> {
            String arg = (String)invocation.getArguments()[0];
            switch (arg) {
                case "river":
                    return "I am river";
                case "ZMM":
                    return "I am ZMM";
                default:
                    throw new RuntimeException("NOt Support:" + arg);
            }
        });
        UserService service = new UserService();
        String river = service.find("river");
        assertEquals("I am river", river);

        try {
            String anyVlaue = service.find("Anyvalue");
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof RuntimeException);
        }

    }


    static class MyArgumentsMatcher extends ArgumentMatcher<String> {

        @Override
        public boolean matches(Object o) {
            String arg = (String) o;
            switch (arg) {
                case "river":
                case "River":
                    return true;
                default:
                    return false;
            }
        }
    }
}
package com.huanghe.power.verify;

import com.huanghe.power.common.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({UserService.class})
public class UserServiceTest {

    @Test
    public void savaOrUpdate() throws Exception{

        User userMock = PowerMockito.mock(User.class);

        UserDao userDaoMock = PowerMockito.mock(UserDao.class);

        // 录制new User的Mock
        PowerMockito.whenNew(UserDao.class).withNoArguments().thenReturn(userDaoMock);

        // 录制UserDao的方法
        PowerMockito.when(userDaoMock.getCount(userMock)).thenReturn(0);

        new UserService().savaOrUpdate(userMock);

        // 断言insert会执行一次，update不会执行
        Mockito.verify(userDaoMock,Mockito.timeout(1)).insertUser(userMock);
        Mockito.verify(userDaoMock,Mockito.never()).updateUser(userMock);

    }
}
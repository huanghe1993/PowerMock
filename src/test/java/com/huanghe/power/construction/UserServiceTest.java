package com.huanghe.power.construction;

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
    public void save() throws Exception {

        UserDao userDaoMock = PowerMockito.mock(UserDao.class);

        String name = "Rier";
        String password = "123";

        // 录制创建UserDao对象的Mock
        PowerMockito.whenNew(UserDao.class).withArguments(name, password).thenReturn(userDaoMock);

        // 录制UserDao的insert方法,无返回值
        PowerMockito.doAnswer(invocation -> 123).when(userDaoMock).insert();

        new UserService().save(name, password);

        Mockito.verify(userDaoMock).insert();

    }


}
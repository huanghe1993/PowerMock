package com.huanghe.power.spy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest({UserService.class})
public class UserServiceTest {

    @Test
    public void testFoo() {
        UserService userServiceMock = PowerMockito.mock(UserService.class);

//        // 不会输出日志信息
//        userServiceMock.foo();
    }

    @Test
    public void spyFoo(){

        UserService userServiceMock = PowerMockito.spy(new UserService());

        String arg = "foo";

        PowerMockito.doNothing().when(userServiceMock).foo(arg);

        // 符合断言就不会打印console log
//        userServiceMock.foo(arg);

        // 不符合断言就会走真实的内容，会打印console log
        userServiceMock.foo("river");

    }

    @Test
    public void testCheck() throws Exception {

        UserService userServiceMock = PowerMockito.spy(new UserService());


        // spy的方式mock的是私有的方法
        // 当调用river返回的是true,当调用其他返回的是异常;当服务录制的行为，采取mock的方式执行，如果是不符，则按照真实的执行
        PowerMockito.doReturn(true).when(userServiceMock,"checkExist","river");


        // 不符合断言就会走真实的内容，会打印console log
        assertTrue(userServiceMock.exist("river"));

    }
}
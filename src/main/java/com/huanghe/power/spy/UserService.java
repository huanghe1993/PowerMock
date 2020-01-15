package com.huanghe.power.spy;

/**
 * @Author huanghe
 * @Date 2020/1/15 23:36
 * @Description  Spy()创建的对象会真实的执行，创建的每一个方法。mock出来的对象是不会去执行里面的每一个方法的
 */
public class UserService {

    public void foo(String arg){
        log();
    }

    private void log(){
        System.out.println("I am console log!");
    }

    public boolean exist(String name){
        return checkExist(name);
    }

    private boolean checkExist(String name){
        System.out.println("chech!");
        throw new UnsupportedOperationException();
    }
}

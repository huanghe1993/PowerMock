package com.huanghe.power.construction;

/**
 * @Author huanghe
 * @Date 2020/1/15 22:55
 * @Description
 */
public class UserDao {

    private String name;

    private String password;

    public UserDao(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public void insert(){
        System.out.println("执行！");
        throw new UnsupportedOperationException();
    }
}

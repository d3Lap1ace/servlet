package com.javaee.service;

import com.javaee.pojo.SysUser;

/**
 * @classname javawedTest
 * @Auther d3Lap1ace
 * @Time 30/4/2024 23:11 周二
 * @description
 * @Version 1.0
 * From the Laplace Demon
 */
public interface UserService {

    SysUser login(String username, String userPwd);

    boolean register(String username,String userPwd);

    boolean check(String username);

}

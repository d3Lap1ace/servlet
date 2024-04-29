package com.javaee.service;

import com.javaee.pojo.SysUser;

/**
 * @classname javawedTest
 * @Auther d3Lap1ace
 * @Time 28/4/2024 19:27 周日
 * @description
 * @Version 1.0
 * From the Laplace Demon
 */
public interface UserService {
    SysUser login(String username, String password);

    boolean register(String username,String password);
}

package com.lewis.servlet.server;

/**
 * @classname javawedTest
 * @Auther d3Lap1ace
 * @Time 28/4/2024 14:14 周日
 * @description
 * @Version 1.0
 * From the Laplace Demon
 */
public interface UserService {
    int login(String username,String userPwd);

    boolean register(String username,String userPwd);

    boolean check(String username);
}

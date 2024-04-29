package com.javaee.service;

/**
 * @classname javawedTest
 * @Auther d3Lap1ace
 * @Time 28/4/2024 18:11 周日
 * @description
 * @Version 1.0
 * From the Laplace Demon
 */
public interface UserService {
    int login(String username,String password);

    boolean register(String username,String password);
}

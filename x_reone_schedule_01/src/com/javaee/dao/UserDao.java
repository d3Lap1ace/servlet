package com.javaee.dao;

import com.javaee.pojo.SysUser;

/**
 * @classname javawedTest
 * @Auther d3Lap1ace
 * @Time 30/4/2024 23:15 周二
 * @description
 * @Version 1.0
 * From the Laplace Demon
 */
public interface UserDao {
    SysUser queryByUserName(String username);

    int insertSysUser(String username, String userPwd);

    int queryUserNameCount(String username);
}

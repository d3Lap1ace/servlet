package com.javaee.servlet.dao;

import com.javaee.servlet.pojo.SysUser;

/**
 * @classname javawedTest
 * @Auther d3Lap1ace
 * @Time 1/5/2024 10:34 周三
 * @description
 * @Version 1.0
 * From the Laplace Demon
 */
public interface UserDao {
    public SysUser queryByUserName(String username);
    public int insertSysUser(String username,String userPwd);
    public int querUserNameCount(String username);
}

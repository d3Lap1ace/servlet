package com.javaee.dao;

import com.javaee.pojo.SysUser;

/**
 * @classname javawedTest
 * @Auther d3Lap1ace
 * @Time 28/4/2024 17:56 周日
 * @description
 * @Version 1.0
 * From the Laplace Demon
 */
public interface UserDao {
    //DQL(select => 返回查询结果 => 实体类对象 或者 实体类集合)
    SysUser queryByUsername(String username);

    //DML(insert updata delete =>jdbc =>int row 影响行数)
    int insertSysUser(String username,String password);
}

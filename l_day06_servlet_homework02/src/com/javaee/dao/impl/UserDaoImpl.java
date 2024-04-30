package com.javaee.dao.impl;

import com.javaee.dao.UserDao;
import com.javaee.pojo.SysUser;
import com.javaee.utils.BaseDao;

import java.util.List;

/**
 * @classname javawedTest
 * @Auther d3Lap1ace
 * @Time 28/4/2024 19:21 周日
 * @description
 * @Version 1.0
 * From the Laplace Demon
 */


public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public SysUser queryByUserName(String username) {
        String sql = "select uid , username , user_pwd userPwd from sys_user where username = ? ;";
        List<SysUser> baseQuery = baseQuery(SysUser.class, sql, username);
        return baseQuery.get(0);
    }

    @Override
    public int insertSysUser(String username, String userPwd) {
        String sql = "insert into sys_user (username,user_pwd) values(?,?)";
        int rows = baseUpdate(sql, username, userPwd);
        return rows;
    }

    @Override
    public int queryUserNameCount(String username) {
        String sql = "select count(*) from sys_user where username = ? ;";
        return  baseQueryObject(Long.class,sql,username).intValue();
    }
}

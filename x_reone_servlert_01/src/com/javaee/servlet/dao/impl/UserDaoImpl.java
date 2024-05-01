package com.javaee.servlet.dao.impl;

import com.javaee.servlet.dao.UserDao;
import com.javaee.servlet.pojo.SysUser;
import com.javaee.servlet.utils.BaseDao;

import java.util.List;

/**
 * @classname javawedTest
 * @Auther d3Lap1ace
 * @Time 1/5/2024 10:34 周三
 * @description
 * @Version 1.0
 * From the Laplace Demon
 */


public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public SysUser queryByUserName(String username) {
        String sql = "select uid , username , user_pwd userPwd from sys_user where username = ? ;";
        List<SysUser> sysUserList = baseQuery(SysUser.class, sql, username);
        return sysUserList.size()>0?sysUserList.get(0):null;
    }

    @Override
    public int insertSysUser(String username, String userPwd) {
        String sql ="insert into sys_user (username,user_pwd) values(?,?)";
        int rows = baseUpdate(sql, username, userPwd);
        return rows;
    }

    @Override
    public int querUserNameCount(String username) {
        String sql = "select count(*) from sys_user where username = ? ;";
        return  baseQueryObject(Long.class,sql,username).intValue();
    }
}

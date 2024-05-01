package com.javaee.dao.impl;

import com.javaee.dao.UserDao;
import com.javaee.pojo.SysUser;
import com.javaee.utils.BaseDao;

import java.util.List;

/**
 * @classname javawedTest
 * @Auther d3Lap1ace
 * @Time 30/4/2024 23:15 周二
 * @description
 * @Version 1.0
 * From the Laplace Demon
 */


public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public SysUser queryByUserName(String username) {
        String sql = "select uid , username, user_pwd userPwd from sys_user where username = ?;";
        List<SysUser> sysUserList = baseQuery(SysUser.class,sql,username);
        return sysUserList.size() > 0 ? sysUserList.get(0) : null;
    }

    @Override
    public int insertSysUser(String username, String userPwd) {
        //1.编写sql语句
        String sql ="insert into sys_user (username,user_pwd) values(?,?)";
        //2.执行即可
        int rows = baseUpdate(sql, username, userPwd);
        return rows;
    }

    @Override
    public int queryUserNameCount(String username) {
        String sql = "select count(*) from sys_user where username = ? ;";
        return  baseQueryObject(Long.class,sql,username).intValue();
    }


}

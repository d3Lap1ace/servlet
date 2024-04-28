package com.javaee.dao.impl;

import com.javaee.dao.UserDao;
import com.javaee.pojo.SysUser;
import com.javaee.utils.BaseDao;
import java.util.List;

/**
 * @classname javawedTest
 * @Auther d3Lap1ace
 * @Time 28/4/2024 18:03 周日
 * @description
 * @Version 1.0
 * From the Laplace Demon
 */


public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public SysUser queryByUsername(String username) {
        //编写sql语句
        String sql = "select uid , username , user_pwd userPwd from sys_user where username = ? ;";
        //执行
        List<SysUser> sysUserList = baseQuery(SysUser.class, sql, username);
        return sysUserList.get(0);
    }

    @Override
    public int insertSysUser(String username, String password) {
        String sql = "insert into sys_user (username,user_pwd) values(?,?)";
        int rows =  baseUpdate(sql,username,password);
        return rows;
    }
}

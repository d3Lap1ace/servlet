package com.lewis.servlet.server.impl;

import com.lewis.servlet.dao.UserDao;
import com.lewis.servlet.dao.impl.UserDaoImpl;
import com.lewis.servlet.pojo.SysUser;
import com.lewis.servlet.server.UserService;
import com.lewis.servlet.utils.MD5Util;

/**
 * @classname javawedTest
 * @Auther d3Lap1ace
 * @Time 28/4/2024 14:16 周日
 * @description
 * @Version 1.0
 * From the Laplace Demon
 */


public class UserServiceImpl implements UserService {
    @Override
    public int login(String username, String userPwd) {
        userPwd = MD5Util.encrypt(userPwd);

        UserDaoImpl userDao = new UserDaoImpl();
        SysUser sysUser = userDao.queryByUserName(username);

        if(sysUser == null){
            return 1;
        }
        if(!sysUser.getUserPwd().equals(userPwd)){
            return 2;
        }
        return 0;
    }

    @Override
    public boolean register(String username, String userPwd) {
        userPwd = MD5Util.encrypt(userPwd);
        UserDao userDao = new UserDaoImpl();
        int rows = userDao.insertSysUser(username, userPwd);
        return rows >0;
    }

    @Override
    public boolean check(String username) {
        UserDao userDao = new UserDaoImpl();
        int count = userDao.queryUserNameCount(username);
        return count == 0;
    }
}

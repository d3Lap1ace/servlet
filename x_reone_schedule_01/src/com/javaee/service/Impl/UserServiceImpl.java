package com.javaee.service.Impl;

import com.javaee.dao.UserDao;
import com.javaee.dao.impl.UserDaoImpl;
import com.javaee.pojo.SysUser;
import com.javaee.service.UserService;
import com.javaee.utils.BaseDao;
import com.javaee.utils.MD5Util;

/**
 * @classname javawedTest
 * @Auther d3Lap1ace
 * @Time 30/4/2024 23:12 周二
 * @description
 * @Version 1.0
 * From the Laplace Demon
 */


public class UserServiceImpl extends BaseDao implements UserService {
    @Override
    public SysUser login(String username, String userPwd) {
        UserDao userDao = new UserDaoImpl();
        SysUser sysUser = userDao.queryByUserName(username);
        return sysUser;
    }
    @Override
    public boolean register(String username, String userPwd) {
        //1.接收和处理参数
        userPwd = MD5Util.encrypt(userPwd);
        //2.调用dao方法
        UserDao userDao = new UserDaoImpl();
        int rows = userDao.insertSysUser(username, userPwd);
        //3.处理结果
        return rows > 0;
    }

    @Override
    public boolean check(String username) {
        UserDao userDao = new UserDaoImpl();
        int count = userDao.queryUserNameCount(username);
        return count==0;
    }
}

package com.javaee.service.lmpl;

import com.javaee.dao.UserDao;
import com.javaee.dao.impl.UserDaoImpl;
import com.javaee.pojo.SysUser;
import com.javaee.service.UserService;
import com.javaee.utils.MD5Util;

/**
 * @classname javawedTest
 * @Auther d3Lap1ace
 * @Time 28/4/2024 19:29 周日
 * @description
 * @Version 1.0
 * From the Laplace Demon
 */


public class UserServiceimpl implements UserService {
    @Override
    public int login(String username, String password) {
        password = MD5Util.encrypt(password);
        UserDaoImpl userDao = new UserDaoImpl();
        SysUser sysUser = userDao.queryByUserName(username);
        if(sysUser == null){
            return 1;
        }
        if(!(sysUser.getUserPwd().equals(password))){
            return 2;
        }
        return 0;
    }

    @Override
    public boolean register(String username, String password) {
        password = MD5Util.encrypt(password);
        UserDao userDao = new UserDaoImpl();
        int rows = userDao.insertSysUser(username, password);
        return rows >0;
    }
}

package com.javaee.service.impl;

import com.javaee.dao.impl.UserDaoImpl;
import com.javaee.pojo.SysUser;
import com.javaee.service.UserService;
import com.javaee.utils.MD5Util;


/**
 * @classname javawedTest
 * @Auther d3Lap1ace
 * @Time 28/4/2024 18:13 周日
 * @description
 * @Version 1.0
 * From the Laplace Demon
 */


public class UserServiceImpl implements UserService {
    @Override
    public int login(String username, String password) {
        //登录业务的实现  用户输入用户名-> 查询数据库是否存在

        password = MD5Util.encrypt(password);                       // 接收参数  加密
        UserDaoImpl userDao = new UserDaoImpl();                    // new用户对象
        SysUser sysUser = userDao.queryByUsername(username);        // 查询
        if(sysUser == null){                                        // 判断用户是否为空
            return 1;
        }
        if(!(sysUser.getUserPwd().equals(password))){               // 判断用户是否输入错误
            return 2;
        }
        return 0;

    }

    @Override
    public boolean register(String username, String password) {
        password = MD5Util.encrypt(password);                       // md5加密
        UserDaoImpl userDao = new UserDaoImpl();                    // new用户
        int rows = userDao.insertSysUser(username, password);       // 执行用户插入语句
        return rows > 0;                                            // 返回结果
    }
}

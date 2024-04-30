package com.javaEE.service.impl;

import com.javaEE.dao.UserDao;
import com.javaEE.dao.impl.UserDaoImpl;
import com.javaEE.pojo.SysUser;
import com.javaEE.service.UserService;
import com.javaEE.utils.MD5Util;

/**
 * projectName: com.atguigu.service.impl
 *
 * @author: 赵伟风
 * description:
 */
public class UserServiceImpl implements UserService {

    @Override
    public SysUser login(String username, String userPwd) {
//        userPwd = MD5Util.encrypt(userPwd);
        //2.调用dao的方法
        UserDao userDao = new UserDaoImpl();
        SysUser sysUser = userDao.queryByUserName(username);
        //3. 结果数据库
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

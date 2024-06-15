package com.lewis.servlet.service.impl;
import com.lewis.servlet.dao.UserDao;
import com.lewis.servlet.dao.impl.UserDaoImpl;
import com.lewis.servlet.pojo.SysUser;
import com.lewis.servlet.service.SysUserService;
import com.lewis.servlet.utils.MD5Util;


public class SysUserServiceImpl implements SysUserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public int regist(SysUser sysUser) {
        sysUser.setUserPwd(MD5Util.encrypt(sysUser.getUserPwd()));
        return userDao.addSysUser(sysUser);
    }

    @Override
    public SysUser findByUsername(String username) {
        return userDao.findByUsername(username);
    }


}
package com.lewis.servlet.service;

import com.lewis.servlet.pojo.SysUser;

public interface SysUserService {
    int regist(SysUser sysUser);


    SysUser findByUsername(String username);
}
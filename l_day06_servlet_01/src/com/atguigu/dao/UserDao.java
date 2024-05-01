package com.atguigu.dao;

import com.atguigu.pojo.SysUser;

/**
 * projectName:
 *
 * @author:
 * description:
 */
public interface UserDao {

    //登录 查询(账号) |  注册 插入
    SysUser queryByUserName(String username);

    int insertSysUser(String username,String userPwd);

    int queryUserNameCount(String username);


}

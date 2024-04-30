package com.javaEE.dao;

import com.javaEE.pojo.SysUser;

/**
 * projectName: com.atguigu.dao
 *
 * @author: 赵伟风
 * description:
 */
public interface UserDao {

    //登录 查询(账号) |  注册 插入
    SysUser queryByUserName(String username);

    int insertSysUser(String username,String userPwd);

    int queryUserNameCount(String username);
}

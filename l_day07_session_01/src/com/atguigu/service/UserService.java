package com.atguigu.service;

import com.atguigu.pojo.SysUser;

/**
 * projectName: com.atguigu.service
 *
 * @author: 赵伟风
 * description:
 */
public interface UserService {

    //有两个业务 登录 (账号和密码查询) | 注册 0 1 账号错误  2 密码错误
    SysUser login(String username, String userPwd);

    boolean register(String username,String userPwd);

}

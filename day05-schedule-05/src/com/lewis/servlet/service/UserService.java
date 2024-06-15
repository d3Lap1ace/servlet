package com.lewis.servlet.service;

import com.lewis.servlet.pojo.SysUser;

/**
 * projectName: com.lewis.servlet.service
 *
 * @author: 赵伟风
 * description:
 */
public interface UserService {

    //有两个业务 登录 (账号和密码查询) | 注册 0 1 账号错误  2 密码错误
    SysUser login(String username, String userPwd);

    boolean register(String username,String userPwd);

    boolean check(String username);

}

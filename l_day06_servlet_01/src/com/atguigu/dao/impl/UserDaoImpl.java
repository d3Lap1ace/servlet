package com.atguigu.dao.impl;

import com.atguigu.dao.UserDao;
import com.atguigu.pojo.SysUser;
import com.atguigu.utils.BaseDao;

import java.util.List;

/**
 * projectName: com.atguigu.dao.impl
 *
 * @author: 赵伟风
 * description:
 */
public class UserDaoImpl extends BaseDao implements UserDao{
    @Override
    public SysUser queryByUserName(String username) {

        //1.编写sql语句
        String sql = "select uid , username , user_pwd userPwd from sys_user where username = ? ;";
        //2.执行即可
        List<SysUser> sysUserList = baseQuery(SysUser.class, sql, username);
        return sysUserList.get(0);
    }

    @Override
    public int insertSysUser(String username, String userPwd) {
        //1.编写sql语句
        String sql ="insert into sys_user (username,user_pwd) values(?,?)";
        //2.执行即可
        int rows = baseUpdate(sql, username, userPwd);
        return rows;
    }
}

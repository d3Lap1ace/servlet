package com.lewis.servlet.dao.impl;

import com.lewis.servlet.dao.UserDao;
import com.lewis.servlet.pojo.SysUser;
import com.lewis.servlet.utils.BaseDao;

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
        return sysUserList.size()>0?sysUserList.get(0):null;
    }

    @Override
    public int insertSysUser(String username, String userPwd) {
        //1.编写sql语句
        String sql ="insert into sys_user (username,user_pwd) values(?,?)";
        //2.执行即可
        int rows = baseUpdate(sql, username, userPwd);
        return rows;
    }

    @Override
    public int queryUserNameCount(String username) {
        String sql = "select count(*) from sys_user where username = ? ;";
        return  baseQueryObject(Long.class,sql,username).intValue();
    }

    @Override
    public int addSysUser(SysUser sysUser) {
        String sql ="insert into sys_user values(DEFAULT,?,?)";
        return baseUpdate(sql,sysUser.getUsername(),sysUser.getUserPwd());
    }

    @Override
    public SysUser findByUsername(String username) {
        String sql ="select uid,username, user_pwd userPwd from sys_user where username = ?";
        List<SysUser> userList = baseQuery(SysUser.class, sql, username);
        return  null != userList&& userList.size()>0? userList.get(0):null;
    }
}

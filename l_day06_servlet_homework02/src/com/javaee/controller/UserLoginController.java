package com.javaee.controller;

import com.javaee.pojo.SysUser;
import com.javaee.service.UserService;
import com.javaee.service.lmpl.UserServiceimpl;
import com.javaee.utils.MD5Util;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @classname javawedTest
 * @Auther d3Lap1ace
 * @Time 28/4/2024 19:40 周日
 * @description
 * @Version 1.0
 * From the Laplace Demon
 */

@WebServlet("/login")
public class UserLoginController extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        String username = req.getParameter("username");
        String userPwd = req.getParameter("userPwd");

        UserService userService = new UserServiceimpl();
        SysUser sysUser = userService.login(username, userPwd);


        if(sysUser == null){
            req.getRequestDispatcher("/loginUsernameError.html").forward(req,resp);
        }
        //1.参数接收和处理
        userPwd = MD5Util.encrypt(userPwd);
        if (!sysUser.getUserPwd().equals(userPwd)){
            req.getRequestDispatcher("/loginUserPwdError.html").forward(req,resp);
            return;
        }

        //保存下用户信息
        //传入账号和密码 username password 登录成功证明,他俩是对的! 把他们俩存起来是不是就可以啦!!
        req.getSession().setAttribute("user",sysUser);
        //todo 查询学习计划的controller
        req.getRequestDispatcher("/show").forward(req,resp);
    }
}
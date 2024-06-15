package com.lewis.servlet.controller;
import com.lewis.servlet.pojo.SysUser;
import com.lewis.servlet.service.SysUserService;
import com.lewis.servlet.service.impl.SysUserServiceImpl;
import com.lewis.servlet.utils.MD5Util;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/")
public class SysUserController extends BaseController{
    private SysUserService sysUserService = new SysUserServiceImpl();

    public void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 客户端提交的参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");


        // 将参数放入一个sysUser对象中,再调用方法完成注册功能
        SysUser sysUser = new SysUser(null, username, password);
        int rows = sysUserService.regist(sysUser);
        if(rows > 0) {
            resp.sendRedirect("/html/registSuccess.html");
        }else
            resp.sendRedirect("/html/registFail.html");
    }

    public void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        SysUser loginUser =sysUserService.findByUsername(username);

        if(loginUser == null) {
            resp.sendRedirect("/html/loginUsernameError.html");
        }else if(!MD5Util.encrypt(password).equals(loginUser.getUserPwd()))
            resp.sendRedirect("/html/loginUserPwdError.html");
        else
            resp.sendRedirect("/html/showSchedule.html");
    }
}
package com.javaee.controller;

import com.javaee.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @classname javawedTest
 * @Auther d3Lap1ace
 * @Time 28/4/2024 18:29 周日
 * @description 用户注册
 * @Version 1.0
 * From the Laplace Demon
 */

@WebServlet("/login")
public class UserLoginController extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String username = req.getParameter("username");
        String passPwd = req.getParameter("userPwd");

        UserServiceImpl userService = new UserServiceImpl();
        int flag = userService.login(username,passPwd);

        if (flag == 0){
            req.getRequestDispatcher("/html/showSchedule.html").forward(req,resp);
        }else if (flag == 1){
            req.getRequestDispatcher("/html/loginUsernameError.html").forward(req,resp);
        }else if (flag == 2){
            req.getRequestDispatcher("/html/loginUserPwdError.html").forward(req,resp);
        }
    }
}
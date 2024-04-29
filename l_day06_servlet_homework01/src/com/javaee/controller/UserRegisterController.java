package com.javaee.controller;

import com.javaee.service.UserService;
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
 * @Time 28/4/2024 18:36 周日
 * @description 用户注册
 * @Version 1.0
 * From the Laplace Demon
 */

@WebServlet("/register")
public class UserRegisterController extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String username = req.getParameter("username");
        String passPwd = req.getParameter("userPwd");

        UserService userService = new UserServiceImpl();
        boolean is = userService.register(username, passPwd);
        if (is){
            //成功
            req.getRequestDispatcher("/html/registSuccess.html").forward(req,resp);
        }else{
            //失败
            req.getRequestDispatcher("/html/registFail.html").forward(req,resp);
        }
    }
}
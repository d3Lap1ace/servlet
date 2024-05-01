package com.javaee.controller;

import com.javaee.service.Impl.UserServiceImpl;
import com.javaee.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @classname javawedTest
 * @Auther d3Lap1ace
 * @Time 30/4/2024 23:34 周二
 * @description
 * @Version 1.0
 * From the Laplace Demon
 */

@WebServlet("/register")
public class UserRegisterController extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String userPwd = req.getParameter("userPwd");

        UserService userService = new UserServiceImpl();
        boolean is = userService.register(username, userPwd);
        if(is){
            req.getRequestDispatcher("/registSuccess.html").forward(req,resp);
        }else{
            req.getRequestDispatcher("/registFail.html").forward(req,resp);
        }
    }
}
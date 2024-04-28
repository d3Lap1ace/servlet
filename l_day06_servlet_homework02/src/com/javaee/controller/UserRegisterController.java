package com.javaee.controller;

import com.javaee.service.UserService;
import com.javaee.service.lmpl.UserServiceimpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @classname javawedTest
 * @Auther d3Lap1ace
 * @Time 28/4/2024 19:36 周日
 * @description
 * @Version 1.0
 * From the Laplace Demon
 */

@WebServlet("/register")
public class UserRegisterController extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html:charset=utf-8");

        String username = req.getParameter("username");
        String userPwd = req.getParameter("userPwd");

        UserService userService = new UserServiceimpl();
        boolean is = userService.register(username, userPwd);


        if (is){
            //成功
            req.getRequestDispatcher("/registSuccess.html").forward(req,resp);
        }else{
            //失败
            req.getRequestDispatcher("/registFail.html").forward(req,resp);
        }
    }
}
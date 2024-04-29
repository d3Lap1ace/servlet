package com.atguigu.servlet;

import com.atguigu.server.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @classname javawedTest
 * @Auther d3Lap1ace
 * @Time 28/4/2024 14:06 周日
 * @description 用户登录控制层controller
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
        String userPwd = req.getParameter("userPwd");

        UserServiceImpl userService = new UserServiceImpl();
        int flag = userService.login(username,userPwd);

        if(flag == 0){
            req.getRequestDispatcher("/showSchedule.html").forward(req,resp);
        } else if (flag == 1) {
            req.getRequestDispatcher("/loginUsernameErrorr.html").forward(req,resp);
        } else if (flag == 2) {
            req.getRequestDispatcher("/loginUserPwdError.html").forward(req,resp);
        }

    }
}
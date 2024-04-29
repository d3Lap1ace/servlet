package com.atguigu.servlet;

import com.atguigu.server.UserService;
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
 * @Time 28/4/2024 14:11 周日
 * @description 用户注册cotroller
 * @Version 1.0
 * From the Laplace Demon
 */

@WebServlet("/register")
public class UserRegisterController extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 设置编码格式 request  response
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        //2. 获取请求参数 (username userPwd)
        String username = req.getParameter("username");
        String userPwd = req.getParameter("userPwd");

        //3. 调用业务方法
        UserService userService = new UserServiceImpl();
        boolean is = userService.register(username, userPwd);

        //4. 响应结果( 字符串 | 字节文件 | html[转发|重定向])
        if (is){
            //成功
            req.getRequestDispatcher("/registSuccess.html").forward(req,resp);
        }else{
            //失败
            req.getRequestDispatcher("/registFail.html").forward(req,resp);
        }
    }
}
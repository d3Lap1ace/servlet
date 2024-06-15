package com.lewis.servlet.servlet;

import com.lewis.servlet.service.UserService;
import com.lewis.servlet.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


/**
 * projectName: java0311-web
 *
 * @author: 赵伟风
 * time: 2024/4/28 11:47 周日
 * description: 用户注册controller
 */
@WebServlet("/register")
public class UserRegisterController extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

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

package com.atguigu.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


/**
 * projectName: java0311-web
 *
 * @author: 赵伟风
 * time: 2024/4/30 9:16 周二
 * description: 接收ajax的请求,响应ajax的数据
 */
@WebServlet("/controller/ajax2")
public class Ajax2Controller extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String age = req.getParameter("age");
        System.out.println(name + "::" + age);
        //字符输出流
        resp.getWriter().print("hello ajax!!");
    }
}

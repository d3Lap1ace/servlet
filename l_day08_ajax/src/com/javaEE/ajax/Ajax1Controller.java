package com.javaEE.ajax;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @classname javawedTest
 * @Auther d3Lap1ace
 * @Time 30/4/2024 11:35 周二
 * @description 接收ajax的请求, 响应ajax的数据
 * @Version 1.0
 * From the Laplace Demon
 */

@WebServlet("/controller/ajax1")
public class Ajax1Controller extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String age = req.getParameter("age");

        System.out.println(name + "::"+ age);

        resp.getWriter().print("hello ajax!!");

    }
}
package com.atguigu.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @classname javawedTest
 * @Auther d3Lap1ace
 * @Time 28/4/2024 20:32 周日
 * @description
 * @Version 1.0
 * From the Laplace Demon
 */

@WebServlet("/cookie/delete")
public class DeleteCookieController extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("account", "root"); // 生成一瓜cookie
        cookie.setMaxAge(0);                                        // 设置最大周期
        resp.addCookie(cookie);                                     //添加cookie到头文件
        resp.getWriter().print("cookie fasibg");
    }
}
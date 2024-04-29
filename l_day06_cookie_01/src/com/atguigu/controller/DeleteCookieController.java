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
        Cookie cookie = new Cookie("account", "root");
        cookie.setMaxAge(0);
        resp.addCookie(cookie);
        resp.getWriter().print("cookie remove success!!!!!");
    }
}
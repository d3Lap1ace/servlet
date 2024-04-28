package com.javaEE.controller;

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
 * @Time 28/4/2024 20:28 周日
 * @description 存储cookie
 * @Version 1.0
 * From the Laplace Demon
 */

@WebServlet("/qqq/save")
public class SaveCookieController extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 创建一个cookie对象
        Cookie cookie = new Cookie("account","root");
        cookie.setMaxAge(7*24*60*60); //最大年龄 单位是  秒
        // request对象:  /项目的跟地址 : day06
        cookie.setPath(req.getContextPath());

        Cookie cookie1 = new Cookie("time", "117");
        cookie1.setPath(req.getContextPath());

        //使用响应头携带回去
        resp.addCookie(cookie1);
        resp.addCookie(cookie);

    }
}
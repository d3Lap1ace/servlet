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
 * @Time 28/4/2024 20:21 周日
 * @description 获取当前会话的cookie
 * @Version 1.0
 * From the Laplace Demon
 */

@WebServlet("/cookie/show")
public class ShowCookieController extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 使用请求对象获取cookie
        Cookie[] cookies = req.getCookies();
        if(cookies==null||cookies.length==0){
            resp.getWriter().println("this session no cookie data!!");
            return;
        }
        String account = null;
        String time = null;
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("time")){
                time = cookie.getValue();
            }
            if(cookie.getName().equals("account")){
                account = cookie.getValue();
            }
        }
        resp.getWriter().println("this seesion cookie data:"+account+"::"+time);
    }
}
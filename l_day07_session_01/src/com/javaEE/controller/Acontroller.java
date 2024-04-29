package com.javaEE.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @classname javawedTest
 * @Auther d3Lap1ace
 * @Time 29/4/2024 18:34 周一
 * @description 发起数据传递
 * @Version 1.0
 * From the Laplace Demon
 */

@WebServlet("/a")
public class Acontroller extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("key","request data!"); //设置请求属性
        req.getSession().setAttribute("key","session data!!");  //设置会话请求
        req.getServletContext().setAttribute("key","application data!!!"); //设置应用请求
        resp.sendRedirect(req.getContextPath()+"/b");

    }
}
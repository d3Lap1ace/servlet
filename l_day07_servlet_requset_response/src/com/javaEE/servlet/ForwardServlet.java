package com.javaEE.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @classname javawedTest
 * @Auther d3Lap1ace
 * @Time 29/4/2024 19:06 周一
 * @description 转发实现
 * @Version 1.0
 * From the Laplace Demon
 */

@WebServlet("/forward")
public class ForwardServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ForwardServlet.service");
        req.getRequestDispatcher("/html/login.html").forward(req,resp);
    }
}
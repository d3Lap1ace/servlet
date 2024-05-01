package com.javaEE.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * @classname javawedTest
 * @Auther d3Lap1ace
 * @Time 29/4/2024 18:51 周一
 * @description 删除会话请求
 * @Version 1.0
 * From the Laplace Demon
 */

@WebServlet("/session/delete")
public class DeleteSessionController extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        ServletContext servletContext2 = getServletContext();
        ServletContext servletContext = req.getServletContext();
        ServletContext servletContext1 = session.getServletContext();

        System.out.println(servletContext1 == servletContext);  //true

        resp.getWriter().print("session dalete!!!");
    }
}
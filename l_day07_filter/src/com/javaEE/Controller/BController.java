package com.javaEE.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @classname javawedTest
 * @Auther d3Lap1ace
 * @Time 29/4/2024 20:20 周一
 * @description a模拟动态资源
 * @Version 1.0
 * From the Laplace Demon
 */

@WebServlet("/controller/b")
public class BController extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Bcotroller.service");
        resp.getWriter().print("Bcotroller.service");
    }
}
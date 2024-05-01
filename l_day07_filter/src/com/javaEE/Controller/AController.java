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
 * @Time 29/4/2024 20:22 周一
 * @description b模拟动态资源
 * @Version 1.0
 * From the Laplace Demon
 */

@WebServlet("/controller/a")
public class AController extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Acontroller.service");
        resp.getWriter().print("Acontroller.service");
    }
}
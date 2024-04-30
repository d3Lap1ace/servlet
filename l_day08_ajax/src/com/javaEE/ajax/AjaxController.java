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
 * @Time 30/4/2024 09:30 周二
 * @description ajaxTest
 * @Version 1.0
 * From the Laplace Demon
 */

@WebServlet("/controller/ajax")
public class AjaxController extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("AjaxController.service");
        resp.getWriter().print("hello ajax");
    }
}
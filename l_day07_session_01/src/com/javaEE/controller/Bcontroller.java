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
 * @Time 29/4/2024 18:41 周一
 * @description 接收传递的数据
 * @Version 1.0
 * From the Laplace Demon
 */

@WebServlet("/b")
public class Bcontroller extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object key = req.getAttribute("key");
        System.out.println("key = " + key);
        Object key1 = req.getSession().getAttribute("key");
        System.out.println("key1 = " + key1);
        Object key2 = req.getServletContext().getAttribute("key");
        System.out.println("key2 = " + key2);
    }
}
package com.javaEE.controller;

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
 * @Time 29/4/2024 18:43 周一
 * @description 获取session请求
 * @Version 1.0
 * From the Laplace Demon
 */

@WebServlet("/session/show")
public class SessionShowController extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset = utf-8"); //编码格式
        HttpSession session = req.getSession();             // 获得会话请求
        String id = session.getId();                    // 获取id
        System.out.println("id = " + id);
        boolean aNew = session.isNew();                    // 新?
        System.out.println("aNew = " + aNew);
        Object name = session.getAttribute("name");     // 内容
        System.out.println("name = " + name);
        resp.getWriter().print("session data show!!"+name);
    }
}
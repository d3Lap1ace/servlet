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
 * @Time 29/4/2024 18:47 周一
 * @description 保存会话请求
 * @Version 1.0
 * From the Laplace Demon
 */

@WebServlet("/session/save")
public class SessionSaveController extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取session对象
        /*
           步骤1: 检查request是否携带jsessionid的cookie
           步骤2: 如果不存在,创建新的session,也会创建cookie,自动的将cookie加到响应头
           步骤3: 如果存在, 不创建新的session,返回原来的session对象
         */
        HttpSession session = req.getSession();
        session.setMaxInactiveInterval(5*60);
        String id = session.getId();
        System.out.println("id = " + id);
        boolean aNew = session.isNew();
        System.out.println(aNew?"新开的箱子":"打开原有的箱子");
        //2.存储数据即可
        session.setAttribute("name","二狗子");
        resp.getWriter().print("session data save success!!");

    }
}
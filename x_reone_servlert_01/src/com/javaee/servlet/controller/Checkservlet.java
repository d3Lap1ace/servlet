package com.javaee.servlet.controller;

import jakarta.servlet.*;

import java.io.IOException;

/**
 * @classname javawedTest
 * @Auther d3Lap1ace
 * @Time 30/4/2024 20:36 周二
 * @description
 * @Version 1.0
 * From the Laplace Demon
 */


public class Checkservlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        String chaos = servletRequest.getParameter("chaos");
        if("chaos".equals(chaos)){
            servletResponse.getWriter().print("no");
        }else
            servletResponse.getWriter().print("yes");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}

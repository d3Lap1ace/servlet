package com.javaweb;

import jakarta.servlet.*;

import java.io.IOException;

/**
*    @classname ChackServlet
*    @description 
*    @Auther d3Lap1ace
*    @Time 2024/04/25  15:下午3:26
*    @Version 1.0
*                        From the Laplace Demon 
*/
public class CheckServlet implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        String username = servletRequest.getParameter("username");
        if("aiguigu".equals(username)){
            servletResponse.getWriter().println("no");
        }else
            servletResponse.getWriter().println("yes");
    }
}

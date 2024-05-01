package com.javaee.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @classname javawedTest
 * @Auther d3Lap1ace
 * @Time 30/4/2024 23:04 周二
 * @description
 * @Version 1.0
 * From the Laplace Demon
 */

@WebFilter({"/showSchedule.jsp","/schedule/show"})
public class LoginProtectFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;

        Object user = req.getSession().getAttribute("user");

        if(user == null){
            resp.sendRedirect(req.getContextPath()+"/login.html");
        }else {
            filterChain.doFilter(servletRequest,resp);
        }
    }
}

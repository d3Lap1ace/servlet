package com.javaee.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @classname javawedTest
 * @Auther d3Lap1ace
 * @Time 30/4/2024 13:23 周二
 * @description 登录保护过滤器
 * @Version 1.0
 * From the Laplace Demon
 */

@WebFilter({"/showSchedule.jsp","/day06/show"})
public class LoginProtectFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resq = (HttpServletResponse) servletResponse;
        Object user = req.getSession().getAttribute("user");

        if(user == null){
            resq.sendRedirect(req.getContextPath()+"/login.html");
        }else {
            filterChain.doFilter(servletRequest,resq);
        }
    }
}
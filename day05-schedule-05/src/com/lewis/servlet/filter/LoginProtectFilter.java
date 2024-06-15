package com.lewis.servlet.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * projectName: com.lewis.servlet.filter
 *
 * @author: 赵伟风
 * description:
 */
@WebFilter({"/showSchedule.jsp","/schedule/*"})
public class LoginProtectFilter implements Filter {


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //1.检查有没有登录 session
        HttpServletRequest rep = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        Object user = rep.getSession().getAttribute("user");
        //2.放行 | 拦截
        if (user==null){
            //拦截
            resp.sendRedirect(rep.getContextPath()+"/login.html");
        }else{
            filterChain.doFilter(servletRequest,resp);
        }
    }
}

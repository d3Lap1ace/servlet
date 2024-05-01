package com.javaEE.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;

/**
 * @classname javawedTest
 * @Auther d3Lap1ace
 * @Time 29/4/2024 20:28 周一
 * @description
 * @Version 1.0
 * From the Laplace Demon
 *
 *
 *
 *  *  todo: 过滤链
 *  *      一个资源可能被多个过滤器过滤!这些过滤器形成一个过滤链!
 *  *      客户端 -> filter1 -> and ->filter2 -> and -> filtern -> 资源
 *  *      站在单个filter做的是还是一样,拦截(转发或者重定向) 放行
 *  *      只有你放行了.才会调用下一个过滤器或者链尾的资源
 *  *  考虑: 哪个在链头部!!
 *  *       web.xml > 注解
 *  *       web.xml -> filter-mapping先后顺序决定优先级
 *  *       注解 -> 类的字母的ascii编码排序
 */

@WebServlet({"/html/info.html","/html/show.html","/controller/*"})
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("MyFilter.init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyFilter.doFilter");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("MyFilter.destroy");
    }
}

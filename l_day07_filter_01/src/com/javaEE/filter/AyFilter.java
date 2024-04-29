package com.javaEE.filter;

import jakarta.servlet.*;

import java.io.IOException;
import java.util.logging.LogRecord;

/**
 * @classname javawedTest
 * @Auther d3Lap1ace
 * @Time 29/4/2024 20:24 周一
 * @description
 * @Version 1.0
 * From the Laplace Demon
 * 步骤1: 实现Filter接口
 *  * 步骤2: 实现过滤方法
 *  * 步骤3: 配置过滤地址
 *  *
 *  *  <filter>
 * *         <filter-name>myFilter</filter-name>
 * *         <filter-class>com.atguigu.filter.MyFilter</filter-class>
 * *     </filter>
 * *     <filter-mapping>
 * *         <filter-name>myFilter</filter-name>
 * *         <url-pattern>/html/info.html</url-pattern>
 * *         <url-pattern>/html/show.html</url-pattern>
 * *         <url-pattern>/controller/*</url-pattern>
 * *         <url-pattern>/*</url-pattern>
 * *     </filter-mapping>
 *  *
 *  *
 *  *  todo: 过滤链
 *  *      一个资源可能被多个过滤器过滤!这些过滤器形成一个过滤链!
 *  *      客户端 -> filter1 -> and ->filter2 -> and -> filtern -> 资源
 *  *      站在单个filter做的是还是一样,拦截(转发或者重定向) 放行
 *  *      只有你放行了.才会调用下一个过滤器或者链尾的资源
 *  *  考虑: 哪个在链头部!!
 *  *       web.xml > 注解
 *  *       web.xml -> filter-mapping先后顺序决定优先级
 *  *       注解 -> 类的字母的ascii编码排序
 *
 */

//@WebFilter({"/html/info.html","/html/show.html","/controller/*"})
public class AyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("MyFilter.init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("AyFilter.doFilter");
        /*
           检查业务 -> 放行   filterChain.doFilter(servletRequest, servletResponse); //放行 | 拦截 转发或者重定向
         */
        // servletRequest.getRequestDispatcher("/html/error.html").forward(servletRequest,servletResponse);
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("MyFilter.destroy");
    }
}

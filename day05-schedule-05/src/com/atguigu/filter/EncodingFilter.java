package com.atguigu.filter;

import jakarta.servlet.*;

import java.io.IOException;

/**
 * projectName: com.atguigu.filter
 *
 * @author: 赵伟风
 * description: 编码格式过滤器,早于其他的过滤器 web.xml
 */
public class EncodingFilter  implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=utf-8");
        filterChain.doFilter(servletRequest,servletResponse);
    }
}

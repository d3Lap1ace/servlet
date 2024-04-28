package com.java.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;


/**
 * @classname HttpRequesServlet
 * @description 接收前端传递的参数
 * @Auther d3Lap1ace
 * @Time 2024/04/27  11:11:26
 * @Version 1.0
 * From the Laplace Demon
 *
 *
 *
 *
 */
@WebServlet("/requset")
public class HttpRequesServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String method = req.getMethod();
        System.out.println("method = " + method);

        StringBuffer url = req.getRequestURL();
        System.out.println("url = " + url);

        String uri = req.getRequestURI();
        System.out.println("uri = " + uri);

        String contextPath = req.getContextPath();
        System.out.println("contextPath = " + contextPath);


        String protocol = req.getProtocol();
        System.out.println("protocol = " + protocol);

        Enumeration<String> headers = req.getHeaders("user-agent");
        System.out.println("headers = " + headers);

        String header = req.getHeader("user-agent");
        System.out.println("header = " + header);


        String key = req.getParameter("key");
        System.out.println("key = " + key);


        String[] keys = req.getParameterValues("key");
        System.out.println("keys = " + Arrays.toString(keys));



    }
}

// TODO: 27/4/2024 sd
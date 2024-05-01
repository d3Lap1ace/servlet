package com.javaee.reqAndresp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

/**
 * @classname javawedTest
 * @Auther d3Lap1ace
 * @Time 30/4/2024 21:01 周二
 * @description req的api使用
 * @Version 1.0
 * From the Laplace Demon
 */

@WebServlet("/request")
public class Requset extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求行
        String method = req.getMethod();
        System.out.println("method = " + method);

        //获取url
        StringBuffer requestURL = req.getRequestURL();
        System.out.println("requestURL = " + requestURL);

        //获取端口号后的地址
        String requestURI = req.getRequestURI();
        System.out.println("requestURI = " + requestURI);

        //获取项目的跟地址
        String contextPath = req.getContextPath();
        System.out.println("contextPath = " + contextPath);

        //获取网络协议
        String protocol = req.getProtocol();
        System.out.println("protocol = " + protocol);

        //获取请求头的参数
        String header = req.getHeader("user-agent");
        System.out.println("header = " + header);
        //获取多个请求头的参数
        Enumeration<String> headers = req.getHeaders("user-agent");
        while (headers.hasMoreElements()){
            String s = headers.nextElement();
            System.out.println("s = " + s);
        }
        //todo: tomcat 10+版本已经解决全部的请求参数乱码问题! 请求url参数和请求体的字符参数 编码格式默认设置为utf-8
        //todo: tomcat 8 + 默认将请求体的字符串参数设置为utf-8 将url地址默认的编码格式iso-8859-1(单字符的编码格式 abcdef 博大精深)  (apache)
        //String key = req.getParameter("key");

        req.setCharacterEncoding("utf-8");

        String key1 = req.getParameter("key1");
        System.out.println("key1 = " + key1);
        //key=value | key=1 | key2  form 多选框  爱好
        String[] keys = req.getParameterValues("key");
        System.out.println(" = " + Arrays.toString(keys));

        //一次获取所有的参数 参数-> map的键 [key key1] 参数的值 -> map的值 [因为一个key可能有多个值]
        Map<String, String[]> parameterMap = req.getParameterMap();
        System.out.println("--------------------");
        for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
            System.out.println(entry.getKey() + "::" + Arrays.toString(entry.getValue()));
        }


        //todo: 前端利用请求体,传递json字符串或者文件类型的时候如何获取
        //1. 获取请求体的数据内容流 [字节输入流] 2. 流转成json字符串  3.利用第三方技术将json字符串转成java实体对象
        //ServletInputStream inputStream = req.getInputStream(); //请求体字节输入流
        //BufferedReader reader = req.getReader(); //请求体的字符输入流

    }
}
package com.javaEE.servlet;

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
 * @Time 29/4/2024 19:07 周一
 * @description 接收前端传递参数
 * @Version 1.0
 * From the Laplace Demon
 *
 * TODO: request对象获取前端传递的http请求数据
 *  *       请求行: get url http1.1
 *  *       请求头: key:value
 *  *       请求空行
 *  *       请求体: 参数 [媒体独立]
 *  *              string
 *  *              流
 *  * TODO: request -> get
 */

@WebServlet("/request")
public class HttpRequestServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //requset获取请求行的数据
        String method = req.getMethod();
        System.out.println("method = " + method);

        //todo: 传递的参数,再获取地址的时候是不会读取到的!
        StringBuffer requestURL = req.getRequestURL(); //获取uri
        System.out.println("requestURL = " + requestURL);

        //获取端口号后面的地址
        String requestURI = req.getRequestURI();
        System.out.println("requestURI = " + requestURI);

        //获取项目的跟地址
        String contextPath = req.getContextPath();
        System.out.println("contextPath = " + contextPath);

        String protocol = req.getProtocol();
        System.out.println("protocol = " + protocol);

        //request获取头的参数
        String header = req.getHeader("user-agent");
        System.out.println("header = " + header);

        //一个头有多个值
        Enumeration<String> headers = req.getHeaders("user-agent");
        while (headers.hasMoreElements()){
            String value = headers.nextElement();
            System.out.println("value = " + value);
        }

        //request获取请求体或者url后面传递的的数据
        //todo: 不管你装到请求体还是url后面字符串参数,获取的方式都是一样的! [传递字符串参数 key=value&key=value] key=value&key1=value1
        //todo: tomcat 10+版本已经解决全部的请求参数乱码问题! 请求url参数和请求体的字符参数 编码格式默认设置为utf-8
        //todo: tomcat 8 + 默认将请求体的字符串参数设置为utf-8 将url地址默认的编码格式iso-8859-1(单字符的编码格式 abcdef 博大精深)  (apache)
        //String key = req.getParameter("key");

        req.getCharacterEncoding();
        String key = req.getParameter("key");
        String[] keys = req.getParameterValues("key");
        System.out.println("keys = " + Arrays.toString(keys));

        Map<String, String[]> parameterMap = req.getParameterMap();
        System.out.println("--------------------------------");
        for (Map.Entry<String, String[]> stringEntry : parameterMap.entrySet()) {
            System.out.println(stringEntry.getKey()+"::"+stringEntry.getValue());
        }

        //todo: 前端利用请求体,传递json字符串或者文件类型的时候如何获取
        //1. 获取请求体的数据内容流 [字节输入流] 2. 流转成json字符串  3.利用第三方技术将json字符串转成java实体对象
        //ServletInputStream inputStream = req.getInputStream(); //请求体字节输入流
        //BufferedReader reader = req.getReader(); //请求体的字符输入流


    }
}
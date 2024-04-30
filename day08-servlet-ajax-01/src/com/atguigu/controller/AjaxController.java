package com.atguigu.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;
import java.util.Set;


/**
 * projectName: java0311-web
 *
 * @author: 赵伟风
 * time: 2024/4/30 9:16 周二
 * description: 接收ajax的请求,响应ajax的数据
 */
@WebServlet("/controller/ajax")
public class AjaxController extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //字符输出流
        resp.getWriter().print("hello ajax!!");
    }
}

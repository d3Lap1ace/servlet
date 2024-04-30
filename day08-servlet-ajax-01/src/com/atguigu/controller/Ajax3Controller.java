package com.atguigu.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;


/**
 * projectName: java0311-web
 *
 * @author: 赵伟风
 * time: 2024/4/30 9:16 周二
 * description: 接收ajax的请求,响应ajax的数据
 *
 *           query | json           query -> request.getParameter(key)
 *   前端                     后台  json -> 导入第三方依赖 -> json字符串映射到java的实体类
 *             json                java对象->第三方依赖->json字符串
 *                                 json字符串 -> java对象
 *                                 java对象->json字符串
 *
 *  总结:
 *     1. ajax使用 [五步]
 *         1.1 创建ajax对象 XMLHttpRequest
 *         1.2 设置状态监听 ajax.onreadstatechange = function() -> readState=4 && status == 200  ajax.responseText;
 *         1.3 设置请求参数 ajax.open(method,url)
 *         1.4 post方式需要设置响应体的格式  ajax.setRequestHeader
 *         1.5 发送请求或者传递post的参数 ajax.send(data)
 *     2. ajax发送参数
 *         get: query key=value -> open(method,url?key=value)
 *         post: query json ->  open(method,url?key=value) | send(key=value | json字符串)
 *     3. 后台接收和响应参数的问题
 *        接收:
 *          query: key=value  request.getParameter(key)
 *          json: 1. 接收请求体的字符串 request.getReader()  2.定义一个json对应的实体类
 *               3. 利用第三方工具jackson  实体类对象 =  ObjectMapper.readValue(json字符串,实体类.class)
 *        响应:
 *           String jsonResult = objectMapper.writeValueAsString(Java数据);
 *          response.getWriter(json字符串)
 */
@WebServlet("/controller/ajax3")
public class Ajax3Controller extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

       //接收json: 1.准备实体类 2.导入三个json处理包 3.工具转化即可  String name = "a" + "c";
        BufferedReader reader = req.getReader();
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ( (line = reader.readLine())!=null ){
            sb.append(line);
        }
        String jsonStr = sb.toString();

        //ObjectMapper json ->  java  || java -> json
        ObjectMapper objectMapper = new ObjectMapper();
        /**
         * 参数1: json字符串
         * 参数2: java对应的class
         */
        Student student = objectMapper.readValue(jsonStr, Student.class);//json字符串 转成java对象

        System.out.println("Ajax3Controller.service");
        //业务调用
        /**
         * 参数: 就是要转成json的java数据  : map list [] 对象
         * 对象-> {name:value}
         * List<对象> -> [{}]
         */
        String jsonResult = objectMapper.writeValueAsString(student);
        //字符输出流
        resp.getWriter().print(jsonResult);
    }
}

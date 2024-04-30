package com.javaEE.ajax;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @classname javawedTest
 * @Auther d3Lap1ace
 * @Time 30/4/2024 11:38 周二
 * @description
 * @Version 1.0
 * From the Laplace Demon
 */

@WebServlet("/controller/ajax3")
public class Ajax3Controller extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接收json
        BufferedReader reader = req.getReader();
        StringBuilder sb = new StringBuilder();
        String line = null;
        while((line = reader.readLine())!= null){
            sb.append(line);
        }
        //
        ObjectMapper objectMapper = new ObjectMapper();

    }
}
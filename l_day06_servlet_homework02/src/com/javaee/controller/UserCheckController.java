package com.javaee.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javaee.result.Result;
import com.javaee.result.ResultCodeEnum;
import com.javaee.service.UserService;
import com.javaee.service.lmpl.UserServiceimpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @classname javawedTest
 * @Auther d3Lap1ace
 * @Time 30/4/2024 13:31 周二
 * @description
 * @Version 1.0
 * From the Laplace Demon
 */

@WebServlet("/check")
public class UserCheckController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");

        UserService userService = new UserServiceimpl();
        boolean check = userService.check(username);

        Result result = null;
        if(check){
            result = Result.build(null, ResultCodeEnum.SUCCESS);
        }else {
            result = Result.build(null,ResultCodeEnum.USERNAME_ERROR);
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(result);
        resp.getWriter().print(json);
    }
}
package com.atguigu.servlet;

import com.atguigu.result.Result;
import com.atguigu.result.ResultCodeEnum;
import com.atguigu.service.UserService;
import com.atguigu.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * projectName: com.atguigu.servlet
 *
 * @author: 赵伟风
 * description:
 */

@WebServlet("/check")
public class UserCheckController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.接收请求参数
        String username = req.getParameter("username");
        //2.调用业务逻辑
        UserService userService = new UserServiceImpl();
        boolean check = userService.check(username);
        //3.响应数据
        Result result = null;
        if (check){
            //result
            result = Result.build(null,ResultCodeEnum.SUCCESS);
        }else{
            //result
            result = Result.build(null,ResultCodeEnum.USERNAME_USED);
        }
        //result -> json -> resp
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(result);
        resp.getWriter().print(json);
    }
}

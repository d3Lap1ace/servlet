package com.javaSE.servletTest;

import com.javaSE.utils.JDBCUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * @classname ServletTest
 * @description homework
 * @Auther d3Lap1ace
 * @Time 2024/04/27  18:18:47
 * @Version 1.0
 * From the Laplace Demon
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1. 设置编码格式 request  response
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //2. 获取请求参数 (username userPwd)
        String username = req.getParameter("username");
        String password = req.getParameter("userPwd");
        //3. 数据库的crud
        Connection connection = JDBCUtil.getConnection();
        String sql = "select uid,username,user_pwd from sys_user where username = ?;";

        int flag = 0;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setObject(1,username);
            ResultSet resultSet = statement.executeQuery();
            boolean next = resultSet.next();
            if(next){
                String userPwd = resultSet.getString("user_pwd");
                if(!password.equals(userPwd)){
                    flag = 2;
                }
            }else {
                flag = 1;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        //4. 响应结果( 字符串 | 字节文件 | html[转发|重定向])
        if(flag == 0){
            req.getRequestDispatcher("/html/showSchedule.html").forward(req,resp);
        }else if(flag == 1){
            req.getRequestDispatcher("/html/loginUsernameError.html").forward(req,resp);
        }else if(flag == 2){
            req.getRequestDispatcher("/html/loginUserPwdError.html").forward(req,resp);
        }
    }
}
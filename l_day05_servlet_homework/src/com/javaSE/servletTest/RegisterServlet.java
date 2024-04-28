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
import java.sql.SQLException;


/**
 * @classname RegisterServlet
 * @description homework
 * @Auther d3Lap1ace
 * @Time 2024/04/27  19:19:12
 * @Version 1.0
 * From the Laplace Demon
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 设置编码格式 request  response 
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //2. 获取请求参数 (username userPwd)
        String username = req.getParameter("username");
        String userPwd = req.getParameter("userPwd");

        //3. 数据库的crud
        Connection connection = JDBCUtil.getConnection();
        String sql = "insert into sys_user (username,user_pwd) values(?,?)";


        PreparedStatement statement = null;
        int rows = 0;
        try {
            statement = connection.prepareStatement(sql);
            statement.setObject(1,username);
            statement.setObject(2,userPwd);
            rows = statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //4. 响应结果( 字符串 | 字节文件 | html[转发|重定向])
        if(rows >0){
            req.getRequestDispatcher("/html/registSuccess.html").forward(req,resp);
        }else {
            req.getRequestDispatcher("/html/registFail.html").forward(req,resp);
        }
    }
}
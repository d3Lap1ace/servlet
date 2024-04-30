package com.javaEE.servlet;

import com.javaEE.pojo.SysUser;
import com.javaEE.service.UserService;
import com.javaEE.service.impl.UserServiceImpl;
import com.javaEE.utils.MD5Util;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


/**
 * projectName: java0311-web
 *
 * @author: 赵伟风
 * time: 2024/4/28 11:46 周日
 * description: 用户登录控制层controller
 */
@WebServlet("/login")
public class UserLoginController extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //2. 获取请求参数 (username userPwd)
        String username = req.getParameter("username");
        String password = req.getParameter("userPwd");

        //3. 业务方法调用
        UserService userService = new UserServiceImpl();
        SysUser sysUser = userService.login(username, password);

        //4. 响应结果( 字符串 | 字节文件 | html[转发|重定向])
        if (sysUser == null){
            req.getRequestDispatcher("/loginUsernameError.html").forward(req,resp);
            return;
        }

        //1.参数接收和处理
        password = MD5Util.encrypt(password);
        if (!sysUser.getUserPwd().equals(password)){
            req.getRequestDispatcher("/loginUserPwdError.html").forward(req,resp);
            return;
        }
        //保存下用户信息
        //传入账号和密码 username password 登录成功证明,他俩是对的! 把他们俩存起来是不是就可以啦!!
        req.getSession().setAttribute("user",sysUser);
        //todo 查询学习计划的controller
        req.getRequestDispatcher("/schedule/show").forward(req,resp);

    }
}

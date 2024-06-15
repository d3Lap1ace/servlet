package com.atguigu.servlet;

import com.atguigu.pojo.SysUser;
import com.atguigu.service.ScheduleService;
import com.atguigu.service.impl.ScheduleServiceImpl;
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
@WebServlet("/schedule/add")
public class ScheduleAddController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.接收参数
        String title = req.getParameter("title");
        //todo 修改登录拦截器 @WebFilter({"/showSchedule.jsp","/schedule/*"})
        SysUser user = (SysUser) req.getSession().getAttribute("user");
        //2.调用业务
        ScheduleService scheduleService = new ScheduleServiceImpl();
        //uid
        scheduleService.addSchedule(title,user.getUid());
        //3.响应结果
        resp.sendRedirect(req.getContextPath()+"/schedule/show");
    }
}

package com.atguigu.servlet;

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

@WebServlet("/schedule/del")
public class ScheduleDelController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //1.接收请求参数
        Integer sid = Integer.parseInt(req.getParameter("sid"));
        //2.调用业务逻辑
        ScheduleService scheduleService = new ScheduleServiceImpl();
        scheduleService.delSchedule(sid);
        //3.响应数据
        resp.sendRedirect(req.getContextPath()+"/schedule/show");
    }
}












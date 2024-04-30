package com.atguigu.servlet;

import com.atguigu.service.impl.ScheduleServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @classname javawedTest
 * @Auther d3Lap1ace
 * @Time 30/4/2024 16:40 周二
 * @description
 * @Version 1.0
 * From the Laplace Demon
 */

@WebServlet("/schedule/del")
public class ScheduleDelController extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收请求参数
        Integer sid = Integer.parseInt(req.getParameter("sid"));
        // 调用业务逻辑
        ScheduleServiceImpl scheduleService = new ScheduleServiceImpl();
        scheduleService.delSchedule(sid);
        resp.sendRedirect(req.getContextPath()+"/schedule/show");
    }
}
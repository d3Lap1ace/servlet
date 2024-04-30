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
 * @Time 30/4/2024 16:46 周二
 * @description
 * @Version 1.0
 * From the Laplace Demon
 */

@WebServlet("/schedule/update")
public class ScheduleUpdateController extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        String uid = req.getParameter("uid");
        Integer completed = Integer.parseInt(req.getParameter("completed"));

        ScheduleServiceImpl scheduleService = new ScheduleServiceImpl();
        scheduleService.updateSchedule(uid,title,completed);

        resp.sendRedirect(req.getContextPath()+"/schedule/show");
    }
}
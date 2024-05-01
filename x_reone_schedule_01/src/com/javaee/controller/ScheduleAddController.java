package com.javaee.controller;

import com.javaee.pojo.SysUser;
import com.javaee.service.Impl.ScheduleServiceImpl;
import com.javaee.service.ScheduleService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * @classname javawedTest
 * @Auther d3Lap1ace
 * @Time 1/5/2024 10:45 周三
 * @description
 * @Version 1.0
 * From the Laplace Demon
 */

@WebServlet("/add")
public class ScheduleAddController extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        SysUser user = (SysUser)req.getSession().getAttribute("user");
        ScheduleService scheduleService = new ScheduleServiceImpl();
        scheduleService.addSchedule(title,user.getUid());
        resp.sendRedirect(req.getContextPath()+"/schedule/show");
    }
}
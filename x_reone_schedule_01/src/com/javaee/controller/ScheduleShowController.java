package com.javaee.controller;

import com.javaee.pojo.SysSchedule;
import com.javaee.pojo.SysUser;
import com.javaee.service.Impl.ScheduleServiceImpl;
import com.javaee.service.ScheduleService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

/**
 * @classname javawedTest
 * @Auther d3Lap1ace
 * @Time 1/5/2024 10:50 周三
 * @description
 * @Version 1.0
 * From the Laplace Demon
 */

@WebServlet("/show")
public class ScheduleShowController extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SysUser sysUser = (SysUser) req.getSession().getAttribute("user");
        String page = req.getParameter("page");
        String size = req.getParameter("size");

        ScheduleService scheduleService = new ScheduleServiceImpl();
        List<SysSchedule> sysSchedules = scheduleService.showList(sysUser.getUid(),page,size);



    }
}
package com.javaee.controller;

import com.javaee.pojo.SysSchedule;
import com.javaee.pojo.SysUser;
import com.javaee.service.ScheduleService;
import com.javaee.service.lmpl.ScheduleServiceimpl;
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
 * @Time 29/4/2024 13:08 周一
 * @description
 * @Version 1.0
 * From the Laplace Demon
 */

@WebServlet("/show")
public class ScheduleShowController extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 设置编码格式 request  response
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        //2. 获取请求参数
        SysUser sysUser = (SysUser) req.getSession().getAttribute("user");
        //3. 调用业务层
        ScheduleService scheduleService = new ScheduleServiceimpl();
        List<SysSchedule> sysSchedules = scheduleService.showList(sysUser.getUid());
        //4. 响应结果( 字符串 | 字节文件 | html[转发|重定向])
        req.setAttribute("sysSchedules",sysSchedules);
        req.getRequestDispatcher("/showSchedule.jsp").forward(req,resp);
    }

}

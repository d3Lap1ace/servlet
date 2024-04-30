package com.atguigu.servlet;

import com.atguigu.pojo.SysSchedule;
import com.atguigu.pojo.SysUser;
import com.atguigu.service.ScheduleService;
import com.atguigu.service.impl.ScheduleServiceImpl;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;


/**
 * projectName: java0311-web
 *
 * @author: 赵伟风
 * time: 2024/4/29 11:05 周一
 * description: 展示学习计划
 */
@WebServlet("/schedule/show")
public class ScheduleShowController extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //2. 获取请求参数
        SysUser sysUser = (SysUser) req.getSession().getAttribute("user");
        //3. 调用业务层
        ScheduleService scheduleService = new ScheduleServiceImpl();
        List<SysSchedule> sysSchedules = scheduleService.showList(sysUser.getUid());
        //4. 响应结果( 字符串 | 字节文件 | html[转发|重定向])
        req.setAttribute("sysSchedules",sysSchedules);
        req.getRequestDispatcher("/showSchedule.jsp").forward(req,resp);
    }
}

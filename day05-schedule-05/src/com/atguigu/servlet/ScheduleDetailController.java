package com.atguigu.servlet;

import com.atguigu.pojo.SysSchedule;
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
@WebServlet("/schedule/detail")
public class ScheduleDetailController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.接收参数
        String sid = req.getParameter("sid");
        //2.调用业务
        ScheduleService scheduleService = new ScheduleServiceImpl();
        //uid
        SysSchedule sysSchedule =  scheduleService.detailSchedule(sid);
        //3.响应结果
        req.setAttribute("schedule",sysSchedule);
        req.getRequestDispatcher("/updateSchedule.jsp").forward(req,resp);
    }
}

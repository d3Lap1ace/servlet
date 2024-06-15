package com.lewis.servlet.servlet;

import com.lewis.servlet.service.ScheduleService;
import com.lewis.servlet.service.impl.ScheduleServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * projectName: com.lewis.servlet.servlet
 *
 * @author: 赵伟风
 * description:
 */
@WebServlet("/schedule/update")
public class ScheduleUpdateController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.接收参数
        String title = req.getParameter("title");
        String sid = req.getParameter("sid");
        Integer completed = Integer.parseInt(req.getParameter("completed"));
        //2.调用业务
        ScheduleService scheduleService = new ScheduleServiceImpl();
        //uid
        scheduleService.updateSchedule(sid,title,completed);
        //3.响应结果
        resp.sendRedirect(req.getContextPath()+"/schedule/show");
    }
}

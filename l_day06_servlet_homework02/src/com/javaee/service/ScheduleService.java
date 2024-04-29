package com.javaee.service;

import com.javaee.pojo.SysSchedule;

import java.util.List;

/**
 * @classname javawedTest
 * @Auther d3Lap1ace
 * @Time 29/4/2024 11:50 周一
 * @description
 * @Version 1.0
 * From the Laplace Demon
 */
public interface ScheduleService {
    List<SysSchedule> showList(Integer uid);
}

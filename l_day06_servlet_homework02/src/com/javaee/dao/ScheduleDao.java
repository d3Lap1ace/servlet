package com.javaee.dao;

import com.javaee.pojo.SysSchedule;

import java.util.List;

/**
 * @classname javawedTest
 * @Auther d3Lap1ace
 * @Time 29/4/2024 11:47 周一
 * @description
 * @Version 1.0
 * From the Laplace Demon
 */
public interface ScheduleDao {
    List<SysSchedule>queryList(Integer id);
}

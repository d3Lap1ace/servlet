package com.javaee.service.lmpl;
import com.javaee.dao.ScheduleDao;
import com.javaee.dao.impl.ScheduleDaoimpl;
import com.javaee.pojo.SysSchedule;
import com.javaee.service.ScheduleService;


import java.util.List;

/**
 * @classname javawedTest
 * @Auther d3Lap1ace
 * @Time 29/4/2024 11:51 周一
 * @description
 * @Version 1.0
 * From the Laplace Demon
 */


public class ScheduleServiceimpl implements ScheduleService {


    @Override
    public List<SysSchedule> showList(Integer uid) {
        ScheduleDao scheduleDao = new ScheduleDaoimpl();
        List<SysSchedule> sysSchedules = scheduleDao.queryList(uid);
        return sysSchedules;
    }
}

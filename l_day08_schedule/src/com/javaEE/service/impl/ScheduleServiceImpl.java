package com.javaEE.service.impl;

import com.javaEE.dao.ScheduleDao;
import com.javaEE.dao.impl.ScheduleDaoImpl;
import com.javaEE.pojo.SysSchedule;
import com.javaEE.service.ScheduleService;

import java.util.List;

/**
 * projectName: com.atguigu.service.impl
 *
 * @author: 赵伟风
 * description:
 */
public class ScheduleServiceImpl  implements ScheduleService {
    @Override
    public List<SysSchedule> showList(Integer uid) {
        ScheduleDao scheduleDao = new ScheduleDaoImpl();
        List<SysSchedule> sysSchedules = scheduleDao.queryList(uid);
        return sysSchedules;
    }
}

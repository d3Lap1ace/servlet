package com.atguigu.service.impl;

import com.atguigu.dao.ScheduleDao;
import com.atguigu.dao.UserDao;
import com.atguigu.dao.impl.ScheduleDaoImpl;
import com.atguigu.dao.impl.UserDaoImpl;
import com.atguigu.pojo.SysSchedule;
import com.atguigu.service.ScheduleService;

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

package com.lewis.servlet.service.impl;

import com.lewis.servlet.dao.ScheduleDao;
import com.lewis.servlet.dao.impl.ScheduleDaoImpl;
import com.lewis.servlet.pojo.SysSchedule;
import com.lewis.servlet.service.ScheduleService;

import java.util.List;

/**
 * projectName: com.lewis.servlet.service.impl
 *
 * @author: 赵伟风
 * description:
 */
public class ScheduleServiceImpl  implements ScheduleService {

    @Override
    public List<SysSchedule> showList(Integer uid, String page, String size) {
        int pageNumber = 1;
        int sizeNumber = 3; //默认值
        if (page!=null&&page.length()>0){
            pageNumber = Integer.parseInt(page);
        }
        if (size!=null&&size.length()>0){
            sizeNumber = Integer.parseInt(size);
        }
        ScheduleDao scheduleDao = new ScheduleDaoImpl();
        List<SysSchedule> sysSchedules = scheduleDao.queryList(uid,(pageNumber-1)*sizeNumber, sizeNumber);
        return sysSchedules;
    }

    @Override
    public void addSchedule(String title, Integer uid) {
        ScheduleDao scheduleDao = new ScheduleDaoImpl();
        scheduleDao.insertSchedule(title,uid);
    }

    @Override
    public void delSchedule(Integer sid) {
        ScheduleDao scheduleDao = new ScheduleDaoImpl();
        scheduleDao.deleteById(sid);
    }

    @Override
    public SysSchedule detailSchedule(String sid) {
        ScheduleDao scheduleDao = new ScheduleDaoImpl();
        return scheduleDao.queryById(sid);
    }

    @Override
    public void updateSchedule(String sid, String title, Integer completed) {
        ScheduleDao scheduleDao = new ScheduleDaoImpl();
        scheduleDao.updateById(sid,title,completed);
    }

    @Override
    public Long findCount(Integer uid) {
        ScheduleDao scheduleDao = new ScheduleDaoImpl();
        return scheduleDao.queryCountByUid(uid);
    }
}

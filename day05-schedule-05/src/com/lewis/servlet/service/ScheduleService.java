package com.lewis.servlet.service;

import com.lewis.servlet.pojo.SysSchedule;

import java.util.List;

/**
 * projectName: com.lewis.servlet.service
 *
 * @author: 赵伟风
 * description:
 */
public interface ScheduleService {

    List<SysSchedule> showList(Integer uid, String page, String size);

    void addSchedule(String title, Integer uid);

    void delSchedule(Integer sid);

    SysSchedule detailSchedule(String sid);

    void updateSchedule(String sid, String title, Integer completed);

    Long findCount(Integer uid);
}

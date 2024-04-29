package com.atguigu.service;

import com.atguigu.pojo.SysSchedule;

import java.util.List;

/**
 * projectName: com.atguigu.service
 *
 * @author: 赵伟风
 * description:
 */
public interface ScheduleService {

    List<SysSchedule> showList(Integer uid);

}

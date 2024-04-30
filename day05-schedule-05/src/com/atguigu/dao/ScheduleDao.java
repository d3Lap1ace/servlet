package com.atguigu.dao;

import com.atguigu.pojo.SysSchedule;

import java.util.List;

/**
 * projectName: com.atguigu.dao
 *
 * @author: 赵伟风
 * description:
 */
public interface ScheduleDao {

    List<SysSchedule> queryList(Integer uid);
}

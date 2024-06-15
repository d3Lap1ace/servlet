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

    List<SysSchedule> queryList(Integer uid, int i, int sizeNumber);

    void insertSchedule(String title, Integer uid);

    void deleteById(Integer sid);

    SysSchedule queryById(String sid);

    void updateById(String sid, String title, Integer completed);

    Long queryCountByUid(Integer uid);
}

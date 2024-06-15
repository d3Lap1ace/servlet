package com.lewis.servlet.dao;

import com.lewis.servlet.pojo.SysSchedule;

import java.util.List;

/**
 * projectName: com.lewis.servlet.dao
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

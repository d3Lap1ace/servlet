package com.javaee.dao;
import com.javaee.pojo.SysSchedule;

import java.util.List;

/**
 * projectName: com.atguigu.dao
 *
 * @author: 赵伟风
 * description:
 */
public interface ScheduleDao {

    List<SysSchedule> queryList(Integer uid);

    void insertSchedule(String title, Integer uid);

    void deleteById(Integer sid);



    void updateById(String sid, String title, Integer completed);



    SysSchedule queryById(String sid);

    void updataById(String uid, String title, Integer completed);
}

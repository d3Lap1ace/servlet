package com.javaee.dao.impl;

import com.javaee.dao.ScheduleDao;
import com.javaee.pojo.SysSchedule;
import com.javaee.utils.BaseDao;

import java.util.List;

/**
 * @classname javawedTest
 * @Auther d3Lap1ace
 * @Time 29/4/2024 11:48 周一
 * @description
 * @Version 1.0
 * From the Laplace Demon
 */


public class ScheduleDaoimpl extends BaseDao implements ScheduleDao {

    @Override
    public List<SysSchedule> queryList(Integer uid) {
        //查询用户的! 不是查询全部的!
        String sql ="select * from sys_schedule where uid = ? ;";
        return baseQuery(SysSchedule.class,sql,uid);
    }
}

package com.javaEE.dao.impl;

import com.javaEE.dao.ScheduleDao;
import com.javaEE.pojo.SysSchedule;
import com.javaEE.utils.BaseDao;

import java.util.List;

/**
 * projectName: com.atguigu.dao.impl
 *
 * @author: 赵伟风
 * description:
 */
public class ScheduleDaoImpl extends BaseDao implements ScheduleDao {

    @Override
    public List<SysSchedule> queryList(Integer uid) {
        //查询用户的! 不是查询全部的!
        String sql ="select * from sys_schedule where uid = ? ;";
        return baseQuery(SysSchedule.class,sql,uid);
    }
}

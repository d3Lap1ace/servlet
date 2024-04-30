package com.atguigu.dao.impl;

import com.atguigu.dao.ScheduleDao;
import com.atguigu.pojo.SysSchedule;
import com.atguigu.utils.BaseDao;

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

    @Override
    public void insertSchedule(String title, Integer uid) {
        String sql = "insert into sys_schedule (uid,title,completed) values(?,?,0)";
        baseUpdate(sql,uid,title);
    }

    @Override
    public void deleteById(Integer sid) {
        String sql = "delete from sys_schedule where sid = ? ;";
        baseUpdate(sql,sid);
    }

    @Override
    public void updateById(String sid, String title, Integer completed) {
        ScheduleDao scheduleDao = new ScheduleDaoImpl();
        scheduleDao.updateById(sid,title,completed);
    }


}

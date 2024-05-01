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
    public List<SysSchedule> queryList(Integer uid, int offset, int sizeNumber) {
        //查询用户的! 不是查询全部的!
        String sql ="select * from sys_schedule where uid = ? limit ?,? ;";
        return baseQuery(SysSchedule.class,sql,uid,offset,sizeNumber);
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
    public SysSchedule queryById(String sid) {
        String sql ="select * from sys_schedule where sid = ? ;";
        List<SysSchedule> sysScheduleList = baseQuery(SysSchedule.class, sql, sid);
        return sysScheduleList.size()>0?sysScheduleList.get(0):null;
    }

    @Override
    public void updateById(String sid, String title, Integer completed) {
        String sql = "update sys_schedule set title = ? , completed = ? where sid = ? ";
        baseUpdate(sql,title,completed,sid);
    }

    @Override
    public Long queryCountByUid(Integer uid) {
        String sql = "select count(*) from sys_schedule where uid = ? ;";
        return baseQueryObject(Long.class,sql,uid);
    }
}

package com.javaee.dao.impl;

import com.javaee.dao.ScheduleDao;
import com.javaee.utils.BaseDao;
import com.javaee.pojo.SysSchedule;

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
        String sql = "updata sys_schedule set title = ? , completed = ? where sid = ?";
        baseUpdate(sql,title,completed,sid);

    }
    @Override
    public SysSchedule queryById(String sid) {
        String sql = "select *from sys_schedule where sid = ?;";
        List<SysSchedule> sysSchedulaList = baseQuery(SysSchedule.class, sql, sid);
        return sysSchedulaList.size()>0?sysSchedulaList.get(0):null;
    }

    @Override
    public void updataById(String uid, String title, Integer completed) {
        String sql = "update sys_schedule set title = ? , completed = ? where sid = ? ";
        baseUpdate(sql,title,completed);
    }


}

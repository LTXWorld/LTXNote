package com.ltx.schedule.dao.impl;

import com.ltx.schedule.dao.BaseDao;
import com.ltx.schedule.dao.SysScheduleDao;
import com.ltx.schedule.pojo.SysSchedule;

import java.util.List;

/**
 * ClassName: SysScheduleDaoImpl
 * Package:com.ltx.schedule.dao.impl
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/1/15 19:30
 */
public class SysScheduleDaoImpl extends BaseDao implements SysScheduleDao {

    @Override
    public int addSchedule(SysSchedule schedule) {
        String sql = "insert into sys_schedule values(DEFAULT,?,?,?)";
        baseUpdate(sql,schedule.getUid(),schedule.getTitle(),schedule.getCompleted());
        return 0;
    }

    @Override
    public List<SysSchedule> findAll() {
        String sql = "select sid,uid,title,completed from sys_schedule";
        List<SysSchedule> schedules = baseQuery(SysSchedule.class, sql);
        return schedules;
    }
}

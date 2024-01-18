package com.ltx.schedule.dao;

import com.ltx.schedule.pojo.SysSchedule;

/**
 * ClassName: SysScheduleDao
 * Package:com.ltx.schedule.dao
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/1/15 19:24
 */
public interface SysScheduleDao {
    /**
     * 该方法用于向数据库中增加一条日程记录
     * @param schedule 日程数据以实体类对象形式入参
     * @return 返回影响数据库记录的行数，为0增加失败；大于0增加成功
     */
    int addSchedule(SysSchedule schedule);
}
/**
 *
 */
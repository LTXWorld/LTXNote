package com.ltx.schedule.test;

import com.ltx.schedule.dao.impl.SysScheduleDaoImpl;
import com.ltx.schedule.pojo.SysSchedule;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

/**
 * ClassName: TestScheduleDao
 * Package:com.ltx.schedule.test
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/1/18 10:50
 */
public class TestScheduleDao {
    private static SysScheduleDaoImpl scheduleDao;
    @BeforeClass
    public static void init(){
        scheduleDao = new SysScheduleDaoImpl();
    }
    //
    @Test
    public void testAddSchedule(){
        int ba = scheduleDao.addSchedule(new SysSchedule(null, 2, "学习", 1));
        System.out.println(ba);
    }
    @Test
    public void testFindAll(){
        List<SysSchedule> schedules = scheduleDao.findAll();
        schedules.forEach(System.out::println);
    }
}

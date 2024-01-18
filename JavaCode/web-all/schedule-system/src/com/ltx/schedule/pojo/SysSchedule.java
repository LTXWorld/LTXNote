package com.ltx.schedule.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * ClassName: SysSchedule
 * Package:com.ltx.schedule.pojo
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/1/15 19:21
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SysSchedule implements Serializable {
    private Integer sid;
    private Integer uid;
    private  String title;
    private Integer completed;
}

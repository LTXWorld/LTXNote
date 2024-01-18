package com.ltx.schedule.pojo;

import lombok.*;

import java.util.Objects;

/**
 * ClassName: SysUser
 * Package:com.ltx.schedule.pojo
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/1/15 19:03
 * 实体类的类名与表格名称对应
 * 实体类的属性名和表格的列名对应
 * 每个属性都必须私有
 * 每个属性都应该具备getter和setter
 * 必须具备无参构造器
 * 应该实现序列化接口（分布式）
 * 重写hashcode和equals
 *lombok设置里勾选enable annotation processing
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Data//相当于getset\equals\hashcode
public class SysUser {
    private Integer uid;
    private String username;
    private String userPwd;
}

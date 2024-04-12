package com.hmdp.dto;

import lombok.Data;

import java.util.List;

@Data
public class ScrollResult {
    private List<?> list;//查询到的结果（博客等）
    private Long minTime;//上一次的最小时间戳
    private Integer offset;//偏移量
}

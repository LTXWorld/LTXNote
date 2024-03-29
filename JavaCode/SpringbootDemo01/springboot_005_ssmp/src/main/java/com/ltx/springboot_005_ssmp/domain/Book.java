package com.ltx.springboot_005_ssmp.domain;

import lombok.Data;
import lombok.Getter;

/**
 * ClassName: Book
 * Package:com.ltx.springboot_005_ssmp
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/3/20 14:43
 */
@Data
//实体类一般都用的无参构造
public class Book {
    private Integer id;
    private String type;
    private String name;
    private String description;
}

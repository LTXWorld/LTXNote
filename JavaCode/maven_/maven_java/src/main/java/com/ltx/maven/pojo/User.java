package com.ltx.maven.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * ClassName: User
 * Package:com.ltx.maven.pojo
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/1/14 16:19
 */
@Data
@NoArgsConstructor
@Getter
@Setter
public class User {
    private Integer id;
    private String username;
    private String password;
}

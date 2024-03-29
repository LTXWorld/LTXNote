package com.ltx.springboot_005_ssmp.controller.utils;

import lombok.Data;

/**
 * ClassName: R
 * Package:com.ltx.springboot_005_ssmp.controller.utils
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/3/20 17:21
 */
@Data
/**
 * flag作为操作是否成功，true为成功
 * data作为真实数据
 */
public class R {
    private Boolean flag;
    private Object data;

    private String message;

    public R(Boolean flag){
        this.flag = flag;
    }

    public R(Boolean flag, Object data){
        this.flag = flag;
        this.data = data;
    }
    public R(Boolean flag, String msg){
        this.flag = flag;
        this.message = msg;
    }
}

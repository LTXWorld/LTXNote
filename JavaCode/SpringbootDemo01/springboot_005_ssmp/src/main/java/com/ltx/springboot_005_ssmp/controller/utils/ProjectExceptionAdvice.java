package com.ltx.springboot_005_ssmp.controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * ClassName: ProjectExceptionAdvice
 * Package:com.ltx.springboot_005_ssmp.controller.utils
 * Description:
 *作为springmvc的异常处理器
 * @author LTX
 * @version 炼气期
 * @Create 2024/3/21 15:42
 */
//@ControllerAdvice
@RestControllerAdvice
public class ProjectExceptionAdvice {
    //拦截所有的异常信息
    @ExceptionHandler
    public R doException(Exception ex){
        //记录日志，通知运维，通知开发，返回统一格式R
        ex.printStackTrace();
        return new R(false, "服务器故障");
    }
}

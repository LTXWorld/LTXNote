package com.ltx.FileTest.Intro;

import org.junit.Test;

import java.io.File;

/**
 * ClassName: Test001
 * Package:com.ltx.FileTest.Intro
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/24 15:26
 */
public class Test001 {
    @Test
    public void test1(){
        //使用单元测试方法，相对路径相对于module；main方法对应当前工程下
        File file1 = new File("abc");
        System.out.println(file1.getAbsoluteFile());
        File file2 = new File("abc", "ChildName1");
        System.out.println(file2.getAbsoluteFile());
    }
}

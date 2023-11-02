package com.ltx.oop5.Wrapper.Apply;

import org.junit.Test;

/**
 * ClassName: WrapperTest
 * Package:com.ltx.oop5.Wrapper.Apply
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/8 16:16
 */
public class WrapperTest {
    @Test
    public void test(){
        int i1 = 10;
        Integer i = new Integer(i1);
        i.toString();
        Integer ii = Integer.valueOf(i1);

        int i2 = ii.intValue();
        System.out.println(i2);
    }
}

package com.ltx.maven.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * ClassName: MavenTest
 * Package:com.ltx.maven.test
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/1/14 16:28
 */
public class MavenTest {
    @Test
    public void testAssert(){
        int a = 10;
        int b = 20;
        Assertions.assertEquals(a+b,30);
    }
}

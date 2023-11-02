package com.ltx.reflection.Test;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * ClassName: ReflectionTest
 * Package:com.ltx.reflection.Test
 * Description:使用反射，可以调用运行时类的任意属性方法，开发中不经常使用反射
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/30 10:58
 */
public class ReflectionTest {
    @Test
    public void test1() throws Exception{
        Class<Person01> clazz = Person01.class;
        Person01 person01 = clazz.newInstance();//Instance只能用空参的构造器

        //反射调属性
        Field age = clazz.getField("age");
        age.set(person01,10);
        System.out.println(age.get(person01));
        //反射调方法
        Method show = clazz.getMethod("show");
        show.invoke(person01);
    }
    //对于类的私有结构，通过反射的方式进行调用
    @Test
    public void test2() throws Exception{
        //私有构造器
        Class<Person01> clazz = Person01.class;
        Constructor<Person01> cons = clazz.getDeclaredConstructor(String.class, int.class);
        cons.setAccessible(true);//设置使得可以访问私有的构造器
        Person01 tom = cons.newInstance("Tom", 12);
        System.out.println(tom);
        //私有属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(tom,"Jerry");
        System.out.println(name.get(tom));
        //
    }
}

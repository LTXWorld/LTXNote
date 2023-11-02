package com.ltx.reflection.ClassT;

import com.ltx.reflection.Test.Person01;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * ClassName: ClassTest
 * Package:com.ltx.reflection.ClassT
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/31 08:54
 */
public class ClassTest {
    @Test
    public void test1() throws ClassNotFoundException {
        //调用运行时类的静态属性：class
        Class clazz = Person01.class;

        //调用运行时类的对象的getclass方法
        Person01 p1 = new Person01();
        Class clazz1 = p1.getClass();

        //3调用Class类中的forName方法;最常用
        String name = "com.ltx.reflection.Test.Person01";
        Class<?> clazz2 = Class.forName(name);

        //调用类的加载器
        Class<?> clazz3 = ClassLoader.getSystemClassLoader().loadClass("com.ltx.reflection.Test.Person01");




    }
    //调用属性
    @Test
    public void test2() throws IOException {
        Properties properties = new Properties();
        //默认路径在当前module下，因为Test
        FileInputStream fileInputStream = new FileInputStream(new File("info.properties"));
        properties.load(fileInputStream);
        String name = properties.getProperty("name");
        String number = properties.getProperty("number");
        System.out.println(name + " " + number);
    }
    //使用类的加载器去获取流，并取得配置信息
    @Test
    public void test3() throws IOException {
        Properties properties = new Properties();
        //通过类的加载器读到属性文件，默认路径为当前src里面的
        InputStream stream = ClassLoader.getSystemClassLoader().getResourceAsStream("info1.properties");
        properties.load(stream);
        String name = properties.getProperty("name");
        String number = properties.getProperty("number");
        System.out.println(name + " " + number);
    }
}

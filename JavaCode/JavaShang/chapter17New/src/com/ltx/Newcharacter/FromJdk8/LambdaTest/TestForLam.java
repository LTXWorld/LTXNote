package com.ltx.Newcharacter.FromJdk8.LambdaTest;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author 陆涛
 * @version 1.0
 */
public class TestForLam {
    @Test
    public void test1(){
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("I love u");
            }
        };

        r1.run();

        System.out.println("********************");
        Runnable r2 = () -> {
            System.out.println("I love u");
        };
        //
        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("xxxx");

        Consumer<String> con1 = (String s) ->{
            System.out.println(s);
        };

        Consumer<String> con2 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con2.accept("xxxxxxxx");

        Consumer<String> con3 = (s) ->{
            System.out.println(s);
        };

        Comparator<Integer> com1 =(x1,x2) ->{
            return x1.compareTo(x2);
        };
        System.out.println(com1.compare(12,13));
    }
}

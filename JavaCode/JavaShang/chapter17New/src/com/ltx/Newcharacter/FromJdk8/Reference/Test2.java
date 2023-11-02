package com.ltx.Newcharacter.FromJdk8.Reference;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author 陆涛
 * @version 1.0
 */
public class Test2 {
    @Test
    public void test1(){
        Consumer<String> con1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        //方法引用
        Consumer<String> con3 = System.out :: println;
        con3.accept("xx");
    }
    @Test
    public void test2(){
        Function<Double,Long> fun1 = new Function<Double, Long>() {
            @Override
            public Long apply(Double aDouble) {
                return Math.round(aDouble);
            }
        };

        Function<Double,Long> fun2 = Math :: round;
        fun2.apply(2.0);//这里必须用apply吗，不用round吗？是的，创建出的实例化对象要调用其重写的方法
    }
    @Test
    public void test3(){
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };

        Comparator<Integer> com2 = Integer::compare;
        System.out.println(com2.compare(12, 3));

        BiPredicate<String,String> biPredicate = new BiPredicate<String, String>() {
            @Override
            public boolean test(String s, String s2) {
                return s.equals(s2);
            }
        };

        BiPredicate<String,String> biPredicate1 = String::equals;//类名::非静态方法
    }
    
}

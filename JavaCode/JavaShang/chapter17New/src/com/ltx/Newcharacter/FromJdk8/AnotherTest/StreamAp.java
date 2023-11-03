package com.ltx.Newcharacter.FromJdk8.AnotherTest;

import org.junit.Test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author 陆涛
 * @version 1.0
 */
public class StreamAp {
    @Test
    public void test1(){
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5};
        Stream<Integer> stream = Arrays.stream(arr);

        int[] arr1 = new int[]{1,2,3};
        IntStream stream1 = Arrays.stream(arr1);
        Stream<? extends Serializable> stream2 = Stream.of(1, 2, 3, 4, 5, "xxx");
        //stream2.filter().forEach();
        //
        Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return !s.isEmpty();
            }
        };
        Predicate<String> predicate1 = s -> !s.isEmpty();
        predicate1.test("ss");
    }
    @Test
    public void test2(){
        List<String> list = Arrays.asList("aa","bb");
        list.stream().map(str -> str.toUpperCase()).forEach(System.out ::println);

    }
    @Test
    public void test3(){
        Integer[] arr = new Integer[]{32,53,532,1,53,2,234};
        Arrays.stream(arr).sorted().forEach(System.out::println);
        Arrays.stream(arr).sorted((e1,e2)->e1.compareTo(e2));
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        System.out.println(list.stream().reduce(0, (x1, x2) -> x1 + x2));
    }
    @Test
    public void test4(){
        BinaryOperator<Integer> binaryOperator = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return null;
            }
        };
    }
}

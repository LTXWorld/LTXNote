package com.ltx.one.exer;

import java.util.Scanner;

/**
 * ClassName: week
 * Package:com.ltx.one.exer
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/9/23 15:02
 */
public class Week {
    public static void main(String[] args) {
        String[] weeks = new String[]{"Mon","Tue","Wen","Thur","Fri","Sat","Sun"};
        //用户输入1-7打印出对应的星期
        Scanner scan = new Scanner(System.in);
        int day = scan.nextInt();
        System.out.println("Please input 1-7");

        if (day < 1 || day > 7){
            System.out.println("Wrong");
        }else{
            System.out.println(weeks[day - 1]);
        }
        scan.close();
    }
}

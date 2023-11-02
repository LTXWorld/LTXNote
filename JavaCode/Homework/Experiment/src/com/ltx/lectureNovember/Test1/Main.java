package com.ltx.lectureNovember.Test1;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.Scanner;

/**
 * ClassName: Main
 * Package:com.ltx.lectureNovember.Test1
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/31 15:03
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入动物名称： ");
        String input = sc.nextLine();

        Animal animal;
        switch (input){
            case "小狗":
                animal = new Dog();
                break;
            case "小猫":
                animal = new Cat();
                break;
            default:
                animal = new Animal();
                System.out.println("请输入小猫或者小狗");
                break;
        }

        animal.MakeSound();
        sc.close();
    }
}

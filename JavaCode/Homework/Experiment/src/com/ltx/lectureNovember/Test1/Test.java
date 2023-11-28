package com.ltx.lectureNovember.Test1;

import java.util.Scanner;

/**
 * @author 陆涛
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("input name of the animal");
        String input = sc.nextLine();

        Animal animal;
        switch (input){
            case "小狗":
                animal = new Dog();//向上转型
                break;
            case "小猫":
                animal = new Cat();
                break;
            default:
                animal = new Animal();
                System.out.println("请输入正确的");
                break;
        }
        animal.MakeSound();
        sc.close();
    }
}

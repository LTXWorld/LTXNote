package com.ltx.lectureOctober.E1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @author 陆涛
 * @version 1.0
 */
public class StudentTest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入学生数量");
        int number = sc.nextInt();
        ArrayList<Student> students = new ArrayList<>();
        //循环接收学生信息
        for (int i = 0; i < number; i++) {
            System.out.println("请输入学生id");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.println("输入学生姓名");
            String name = sc.nextLine();
            sc.nextLine();
            System.out.println("请输入数学成绩");
            double mathScore = sc.nextDouble();
            sc.nextLine();
            System.out.println("请输入计算机成绩");
            double computeScore = sc.nextDouble();
            sc.nextLine();

            students.add(new Student(id,name,mathScore,computeScore));
        }
        //这句排序很重要
//        Collections.sort(students, Comparator.comparingDouble(Student :: getMathScore));
        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Double.compare(o2.getMathScore(),o1.getMathScore());//按照降序进行排列
            }
        });
        System.out.println("学生由数学成绩排序");
        for(Student student : students){
            student.print();
        }
        sc.close();
    }
}

package com.ltx.lectureOctober.E1;

import java.util.Scanner;



public class StudentTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生数量");
        int number = sc.nextInt();
        Student[] students = new Student[number];
        for (int i = 0; i < number; i++) {
            System.out.println("请输入学生ID");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.println("请输入学生姓名");
            String name = sc.nextLine();

            System.out.println("请输入数学成绩");
            double mathScore = sc.nextDouble();
            sc.nextLine();
            System.out.println("请输入计算机成绩");
            double computerScore = sc.nextDouble();
            sc.nextLine();

            students[i] = new Student(id,name,mathScore,computerScore);
            //按照数学成绩升序排序
            for (int j = i; j > 0 ; j --) {
                if (students[j].getMathScore() < students[j - 1].getMathScore()){
                    Student temp = students[j];
                    students[j] = students[j - 1];
                    students[j - 1] = temp;
                }else {
                    break;
                }
            }
        }

        System.out.println("Students sorted by math score:");
        for (Student student : students) {
            student.print();
        }
        sc.close();
    }
}

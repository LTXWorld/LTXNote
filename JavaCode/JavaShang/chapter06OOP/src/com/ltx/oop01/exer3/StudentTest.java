package com.ltx.oop01.exer3;

/**
 * ClassName: StudentTest
 * Package:com.ltx.oop01.exer3
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/9/28 09:45
 */
public class StudentTest {
    public static void main(String[] args) {
        Student[] stu = new Student[20];
        //使用循环给数组赋值
        for (int i = 0; i < stu.length; i++) {
            stu[i] = new Student();
            stu[i].number = i + 1;
            stu[i].state = (int)(Math.random() * 6 + 1) ;
            stu[i].score = (int)(Math.random() * 101);
        }
        //打印出三年级的学生信息
        for (int i = 0; i < stu.length; i++) {
            if(stu[i].state == 3){
                Student str = stu[i];
                System.out.println("number = " + str.number);
            }
        }
        //使用冒泡排序根据成绩排序
        for (int i = 0; i < stu.length - 1; i++) {
            for (int j = 0; j < stu.length - i - 1; j++) {
                if(stu[j].score > stu[j + 1].score){
                    //更换的是地址，而不是值
                    Student temp = stu[j];
                    stu[j] = stu[j + 1];
                    stu[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < stu.length; i++) {
            System.out.println("number = " + stu[i].number);
        }
    }
}

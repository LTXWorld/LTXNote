package com.ltx.oop5.StringI;

import java.util.Scanner;
import java.util.Vector;

/**
 * ClassName: ScoreTest
 * Package:com.ltx.oop5.StringI
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/9 08:46
 */
public class ScoreTest {
    public static void main(String[] args) {
        Vector v = new Vector();
        Scanner sc = new Scanner(System.in);
        int maxScore = Integer.MIN_VALUE;
        while (true){
            System.out.println("请输入学生成绩 : ");
            int score = sc.nextInt();
            //将int装为Integer
            //Integer s1 = Integer.valueOf(score);

            if (score < 0){
                break;
            }
            v.addElement(score);
            if (maxScore < score){
                maxScore = score;
            }
        }
        //取出成绩遍历
        for (int i = 0; i < v.size(); i++) {
            Object obScore = v.elementAt(i);
            Integer integerScore = (Integer) obScore;//强转为Integer
            //拆箱
            //int score = integerScore.intValue();
            int score = integerScore;
            char grade = ' ';
            if (maxScore - score <= 10){
                grade ='A';
            }else if (maxScore - score <= 20){
                grade = 'B';
            }else if (maxScore - score <= 30){
                grade = 'C';
            }else {
                grade = 'D';
            }
            System.out.println("student " + i + "score " + score + " grade " + grade);
        }

    }
}

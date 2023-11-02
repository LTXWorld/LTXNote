package com.ltx.lectureOctober.StudentExperiment;

/**
 * ClassName: Undergraduate
 * Package:com.ltx.lectureOctober.StudentExperiment
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/17 14:15
 */
public class Undergraduate extends Student{
    public Undergraduate(int id, String name, double mathScore, double computerScore) {
        super(id, name, mathScore, computerScore);
    }

    @Override
    public void print() {
        System.out.println("本科生学生信息为： " + "学号：" + getId() + "姓名： " + getName() + "数学成绩 ： " + getMathScore() + "计算机成绩 ： " + getComputerScore());
    }
}

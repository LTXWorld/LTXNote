package com.ltx.lectureOctober.E1;

public class Student {
    private int numberId;
    private String name;
    private double MathScore;
    private double ComputerScore;

    public Student() {
    }

    public Student(int numberId, String name, double mathScore, double computerScore) {
        this.numberId = numberId;
        this.name = name;
        MathScore = mathScore;
        ComputerScore = computerScore;
    }

    public int getNumberId() {
        return numberId;
    }

    public void setNumberId(int numberId) {
        this.numberId = numberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMathScore() {
        return MathScore;
    }

    public void setMathScore(double mathScore) {
        MathScore = mathScore;
    }

    public double getComputerScore() {
        return ComputerScore;
    }

    public void setComputerScore(double computerScore) {
        ComputerScore = computerScore;
    }

    /**
     * 输出成员变量信息
     */
    public void print(){
        System.out.println("学生学号为 " + numberId + " 学生姓名为 " + name + " 数学成绩为 " + MathScore + " 计算机成绩为 " + ComputerScore);
    }
}

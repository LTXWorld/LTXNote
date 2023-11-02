package com.ltx.lectureOctober.E1;


public class PostGraduate extends Student{
    private String TeacherName;
    private String Research;

    public PostGraduate(int numberId, String name, double mathScore, double computerScore, String teacherName, String research) {
        super(numberId, name, mathScore, computerScore);
        TeacherName = teacherName;
        Research = research;
    }

    public PostGraduate(String teacherName, String research) {
        TeacherName = teacherName;
        Research = research;
    }

    public String getTeacherName() {
        return TeacherName;
    }

    public void setTeacherName(String teacherName) {
        TeacherName = teacherName;
    }

    public String getResearch() {
        return Research;
    }

    public void setResearch(String research) {
        Research = research;
    }

    @Override
    public void print() {
        System.out.println("学生学号为 " + super.getNumberId() + " 学生姓名为 " + super.getName() + " 数学成绩为 " + super.getMathScore() + " 计算机成绩为 " + super.getComputerScore() +"");
    }
}

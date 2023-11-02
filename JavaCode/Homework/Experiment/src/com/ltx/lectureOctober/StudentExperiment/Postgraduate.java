package com.ltx.lectureOctober.StudentExperiment;

/**
 * ClassName: Postgraduate
 * Package:com.ltx.lectureOctober.StudentExperiment
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/17 14:21
 */
public class Postgraduate extends Student {
    private String TeacherName;
    private String Search;

    public Postgraduate() {
    }

    public Postgraduate(int id, String name, double mathScore, double computerScore, String teacherName, String search) {
        super(id, name, mathScore, computerScore);
        TeacherName = teacherName;
        Search = search;
    }

    public String getTeacherName() {
        return TeacherName;
    }

    public void setTeacherName(String teacherName) {
        TeacherName = teacherName;
    }

    public String getSearch() {
        return Search;
    }

    public void setSearch(String search) {
        Search = search;
    }

    @Override
    public void print() {
        System.out.println("研究生学生信息为： " + " 学号：" + getId() + " 姓名： " + getName() +
                " 数学成绩 ： " + getMathScore() + " 计算机成绩 ： " + getComputerScore() +" 导师： "
        + getTeacherName() +" 研究方向 " + getSearch());
    }
}

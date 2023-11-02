package com.ltx.lectureOctober.StudentExperiment;

public abstract class Student 
{
    private int id;
    private String name;
    private double MathScore;
    private double ComputerScore;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Student(int id, String name, double mathScore, double computerScore) {
        this.id = id;
        this.name = name;
        MathScore = mathScore;
        ComputerScore = computerScore;
    }

    public Student() {
    }

    /**
     * 抽象方法，子类来实现。
     */
    public abstract void print();
	
}

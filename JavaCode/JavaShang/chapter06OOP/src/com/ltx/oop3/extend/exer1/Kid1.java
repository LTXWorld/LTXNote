package com.ltx.oop3.extend.exer1;

/**
 * ClassName: Kid1
 * Package:com.ltx.oop3.extend.exer1
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/2 11:23
 */
public class Kid1 extends ManKind{
    private int yearsOld;
    public Kid1(){

    }

    public Kid1(int yearsOld) {
        this.yearsOld = yearsOld;
    }
    public Kid1(int sex,int salary,int yearsOld){
        this.yearsOld = yearsOld;
        setSex(sex);
        setSalary(salary);
    }
    public int getYearsOld() {
        return yearsOld;
    }

    public void setYearsOld(int yearsOld) {
        this.yearsOld = yearsOld;
    }

    public void printAge(){
        System.out.println("I am" + yearsOld + "yearsOld");
    }
}

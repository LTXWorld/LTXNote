package com.ltx.reflection.Test;

/**
 * ClassName: Person01
 * Package:com.ltx.reflection.Test
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/30 10:59
 */
public class Person01 {
    private String name;
    public int age;

    public Person01() {
    }

    public Person01(int age) {
        this.age = age;
    }

    private Person01(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void show(){
        System.out.println("show my way");
    }
    private String showNation(String nation){
        return nation + "xxx";
    }
}

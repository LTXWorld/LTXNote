package com.ltx.ltx.Yichang.exer1;

/**
 * ClassName: Person
 * Package:com.ltx.Yichang.exer1
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/12 10:04
 */
public class Person {
    private String name;
    private int lifeValue;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLifeValue() {
        return lifeValue;
    }

    public void setLifeValue(int lifeValue) {
        if (lifeValue < 0){
            throw new NoLifeValueException("生命值不能为负数 " + lifeValue);
        }
        this.lifeValue = lifeValue;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", lifeValue=" + lifeValue +
                '}';
    }

    public Person(String name, int lifeValue) {
        this.name = name;
        setLifeValue(lifeValue);
    }

    public Person() {
    }
}

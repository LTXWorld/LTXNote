package com.ltx.oop3.polymorphism.exer2;

/**
 * ClassName: AnimalTest
 * Package:com.ltx.oop3.polymorphism.exer2
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/3 11:15
 */
public class AnimalTest {
    public static void main(String[] args) {
        AnimalTest a = new AnimalTest();
        a.adopt(new Dog("Wang",12,234));
        a.adopt(new Cat("Ji",23,212));
    }
    public void adopt(Animal animal){
        animal.eat();
        animal.jump();
        if (animal instanceof Dog){
            Dog dog = (Dog) animal;
            dog.watchDoor();
        }
        if (animal instanceof Cat){
            Cat cat = (Cat) animal;
            cat.Fish();
        }
    }
}

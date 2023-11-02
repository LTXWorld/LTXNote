package com.ltx.oop01.ValueTransfer.exer;

/**
 * ClassName: PassProjecr
 * Package:com.ltx.oop01.ValueTransfer.exer
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/9/28 15:29
 */
public class PassProject {
    public static void main(String[] args) {
        PassProject p1 = new PassProject();
        p1.printAreas(new Circle(),5);
    }
    public void printAreas(Circle c,int time){
        System.out.println("Radius\t\tAreas");

        for (int i = 1; i <=time ; i++) {
            c.radius = i;
            System.out.println(c.radius + "\t\t" + c.Area(c.radius));
        }

    }
}

package com.ltx.oop3.polymorphism.exer3;

/**
 * ClassName: TsetP
 * Package:com.ltx.oop3.polymorphism.exer3
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/3 12:44
 */
public class TestP {
    public static void main(String[] args) {
        TestP t = new TestP();
        t.meeting(new Man(),new Woman(),new Woman(),new Man());
    }
    public  void meeting(Person ...ps){//可变形参，相当于数组
        for (int i = 0; i < ps.length; i++) {
            ps[i].eat();
            ps[i].toilet();
            if (ps[i] instanceof Woman woman){
                //Woman woman = (Woman) ps[i];
                woman.Face();
            }
            if (ps[i] instanceof Man){
                Man man = (Man) ps[i];
                man.smoke();
            }
            System.out.println();
        }
    }
}

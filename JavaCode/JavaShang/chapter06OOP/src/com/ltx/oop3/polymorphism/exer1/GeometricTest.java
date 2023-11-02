package com.ltx.oop3.polymorphism.exer1;

/**
 * ClassName: GeometricTest
 * Package:com.ltx.oop3.polymorphism.exer1
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/3 11:02
 */
public class GeometricTest {
    public static void main(String[] args) {
        GeometricTest test = new GeometricTest();
        Circle c1 = new Circle("red",1.0,2.3);
        Circle c2 = new Circle("red",1.0,3.3);
        test.displayArea(c1);
        test.displayArea(c2);
        boolean isEquals = test.equalsArea(c1,c2);
        if (isEquals){
            System.out.println("面积相等");
        }else{
            System.out.println("面积不相等");
        }
    }
    /**
     * 比较两个几何图形面积是否相等
     * @param g1
     * @param g2
     * @return
     */
    public boolean equalsArea(GeometricObject g1,GeometricObject g2){
        return g1.findArea() == g2.findArea();
    }

    public void displayArea(GeometricObject g1){
        System.out.println("几何图形的面积" + g1.findArea());
    }
}

package com.ltx.oop4.interface4.exer1;

/**
 * ClassName: ComparableCircle
 * Package:com.ltx.oop4.interface4.exer1
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/7 13:47
 */
public class ComparableCircle extends Circle implements CompareObject{
    public ComparableCircle() {
    }

    public ComparableCircle(double radius) {
        super(radius);
    }
    //根据对象的半径的大小，比较对象的大小
    @Override
    public int compareTo(Object o) {
        if(this == o){
            return 0;
        }
        if (o instanceof ComparableCircle){
            ComparableCircle c = (ComparableCircle) o;
            return this.getRadius() - c.getRadius() > 0 ? 1 : -1;
        }
        return 0;
    }
}

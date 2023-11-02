package com.ltx.oop4.SpecialEnum.exer3;

/**
 * ClassName: Color
 * Package:com.ltx.oop4.SpecialEnum.exer3
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/8 13:43
 */
public class ColorTest {
    public static void main(String[] args) {
        System.out.println(Color.ORANGE);
    }
}
enum Color{
    RED(255,0,0,"红色"),ORANGE(255,128,0,"橙色"),
    YELLOW(255,255,0,"黄色");
    private final int red;
    private final int green;
    private final int blue;
    private final String description;

    private Color(int red, int green, int blue, String description) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.description = description;
    }

    @Override
    public String toString() {
        return name() + "(" + red + green + blue +")" +"->" +description;
    }
}

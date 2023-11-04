package com.ltx.NiuKe.J11_4;

/**
 * ClassName: ClassOrderTest1
 * Package:com.ltx.NiuKe.J11_4
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/11/4 08:36
 */
public class ClassOrderTest1 {
    public static void main(String[] args) {
        Base b = new Base.Sub();
    }
}
class Base{
    private String baseName = "base";
    public Base(){
        callName();
    }
    public void callName(){
        System.out.println(baseName);
    }
    static class Sub extends Base{
        private String baseName = "sub";
        public void callName(){
            System.out.println(baseName);
        }
    }
}

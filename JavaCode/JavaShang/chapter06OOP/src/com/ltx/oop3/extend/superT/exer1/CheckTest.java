package com.ltx.oop3.extend.superT.exer1;

/**
 * ClassName: CheckTest
 * Package:com.ltx.oop3.extend.superT.exer1
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/2 16:03
 */
public class CheckTest {
    public static void main(String[] args) {
        CheckAccount c1 = new CheckAccount(1122, 20000, 0.045, 5000);
        c1.withdraw(5000);
        System.out.println("账户余额" + c1.getBalance());
        System.out.println("可透支额度" + c1.getOverdraft());

        c1.withdraw(18000);
        System.out.println("账户余额" + c1.getBalance());
        System.out.println("可透支额度" + c1.getOverdraft());

        c1.withdraw(3000);
        System.out.println("账户余额" + c1.getBalance());
        System.out.println("可透支额度" + c1.getOverdraft());
    }
}

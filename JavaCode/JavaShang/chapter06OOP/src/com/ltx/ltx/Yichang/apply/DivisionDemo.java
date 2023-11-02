package com.ltx.ltx.Yichang.apply;

/**
 * ClassName: DivisionDemo
 * Package:com.ltx.Yichang.apply
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/12 10:18
 */
public class DivisionDemo {
    public static void main(String[] args) {
        try {
            int m = Integer.parseInt(args[0]);
            int n = Integer.parseInt(args[1]);
            int ret = divide(m,n);
            System.out.println("result= " + ret);
        } catch (BelowZeroException e) {
            e.printStackTrace();
        }catch (NumberFormatException e){
            System.out.println("数据类型不一致");
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("缺少命令行参数");
        }catch (ArithmeticException e){
            System.out.println("------");
        }
    }
    public static int divide(int m,int n) throws BelowZeroException{
        if (m < 0 || n < 0){
            //手动抛出异常对象
            throw new BelowZeroException("输入负数了，违反要求");
        }
        return m / n;
    }
}

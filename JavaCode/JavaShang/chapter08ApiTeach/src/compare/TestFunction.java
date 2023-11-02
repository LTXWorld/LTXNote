package compare;

/**
 * ClassName: TestFunction
 * Package:compare
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/23 20:25
 */
public class TestFunction {
    public static void main(String[] args) {
        Statement(true,maxI(1,2),2);
        System.out.println("123");
    }
    public static int maxI(int i,int j){
        System.out.println("111");
        return i + j;
    }
    public static void Statement(boolean flag,int fun,int num){
        System.out.println("222");
    }
}

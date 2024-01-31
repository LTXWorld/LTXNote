/**
 * ClassName: TestBag01Single
 * Package:PACKAGE_NAME
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/1/28 11:23
 */
public class TestBag01Single {
    public static void main(String[] args) {

    }
}
class SolutionBag2{
    public static void testWeightBagProblem(int[] weight,int[] value,int bagWeight){
        int wLen = weight.length;
        //声明一维的dp数组
        int[] dp = new int[bagWeight + 1];
        //遍历来填充dp数组
        for (int i = 0; i < wLen; i++) {
            for (int j = bagWeight; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j],dp[j-weight[i]] + value[i]);
            }
        }
        //
        for (int i : dp) {
            System.out.println(i + " ");
        }
    }
}

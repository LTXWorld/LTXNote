/**
 * ClassName: Test96
 * Package:PACKAGE_NAME
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/1/26 14:25
 */
public class Test96 {
    public static void main(String[] args) {

    }
}
class Solution96{
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        //
        dp[0] = 1;
        dp[1] = 1;
        //
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j-1] * dp[i-j];//
            }
        }
        return dp[n];
    }
}

/**
 * ClassName: Test62
 * Package:PACKAGE_NAME
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/1/22 09:06
 */
public class Test62 {
    public static void main(String[] args) {
        Solution62 s = new Solution62();
        System.out.println(s.uniquePaths(3,7));
    }
}
class Solution62{
    public int uniquePaths(int m, int n){
        //先确定dp数组，再对其进行初始化
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        //确定遍历顺序，使用递推公式
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];//对剩下的空格子进行填充，固定行先填充列
            }
        }
        return dp[m-1][n-1];
    }
}

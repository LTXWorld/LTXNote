/**
 * ClassName: Test63
 * Package:PACKAGE_NAME
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/1/23 08:25
 */
public class Test63 {
    public static void main(String[] args) {

    }
}
class Solution63{
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;//先记录行列值
        int[][] dp = new int[m][n];
        //健壮性判断
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) return 0;
        //初始化,注意防止其中包含障碍
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n && obstacleGrid[0][i] == 0; i++) {
            dp[0][i] = 1;
        }
        //进行遍历，如果遇到障碍置其dp为0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = (obstacleGrid[i][j] == 0) ? dp[i-1][j] + dp[i][j-1] : 0;
            }
        }
        return dp[m-1][n-1];
    }
}

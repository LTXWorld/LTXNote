package com.ltx.test.Test;
import com.ltx.test.Code.Solution188;
import com.ltx.test.Code.Test121;
/**
 * ClassName: T188
 * Package:com.ltx.test
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2024/2/27 09:39
 */
public class T188 {
    public static void main(String[] args) {
        Solution188 s188 = new Solution188();
        int k = 2;
        int[] prices = {3, 2, 6, 5, 0, 3};
        int max = s188.maxProfit(k, prices);
        System.out.println(max);
    }
}

package com.ltx.common_algrithm.ex2;

/**
 * ClassName: YangHuiTranagle
 * Package:com.ltx.common_algrithm.ex2
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/9/24 15:47
 */
public class YangHuiTranagle {
    public static void main(String[] args) {
        //初始化外层元素
        int[][] Yang = new int[10][];
        //初始化内层元素
        for (int i = 0; i < Yang.length; i++) {
            Yang[i] = new int[i + 1];
            //对元素进行赋值
            Yang[i][0] = Yang[i][i] = 1;//对外圈元素进行赋值
            //对内圈元素进行赋值，遵循杨辉三角的规则
            for (int j = 1; j < Yang[i].length - 1 ; j++) {
                Yang[i][j] = Yang[i - 1][j] + Yang[i-1][j-1];
            }
        }
    }
}
/*

 */

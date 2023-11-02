package com.ltx.October.Test904;

import java.util.HashMap;

/**
 * ClassName: Solution1
 * Package:com.ltx.October.Test904
 * Description:
 *
 * @author LTX
 * @version 炼气期
 * @Create 2023/10/1 20:08
 */
public class Solution1 {
    public int totalFruit(int[] fruits) {
        if(fruits == null || fruits.length == 0) return 0;

        int max = 1;
        HashMap<Integer, Integer> map = new HashMap<>();
        int i = 0, j = 0;

        while (j < fruits.length){
            if (map.size() <= 2){
                map.put(fruits[j], j++);
            }
            if (map.size() > 2){
                int min = fruits.length - 1;
                for(int value : map.values()){
                    min = Math.min(min,value);
                    /*
                    这样min来找到当前窗口最左边的元素下标值，这个增强for循环就是遍历哈希表map中所存的下标值
                    而已，找到最小的下标值就是最左边的，然后将其remove掉
                     */
                }
                i = min + 1;//i指向下一次开始的左边位置
                map.remove(fruits[min]);
            }
            max = Math.max(max,j - i);
        }
        return max;
    }
}

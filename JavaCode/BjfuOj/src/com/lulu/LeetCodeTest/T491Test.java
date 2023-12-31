package com.lulu.LeetCodeTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 陆涛
 * @version 1.0
 */
public class T491Test {
    public static void main(String[] args) {
        Solution491 s = new Solution491();
        int[] nums = new int[]{4,6,7,7};
        s.findSubsequences(nums);
    }
}
class Solution491 {
    private List<Integer> path = new ArrayList<>();
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums,0);
        return result;
    }
    private void backtracking(int[] nums,int startIndex){
        //如果在这里收集会多一个空数组，尝试添加一个条件。
        if (path.size() > 1){//并且注意长度至少为2
            result.add(new ArrayList<>(path));
        }
        if (startIndex >= nums.length){
            return;//最终收集在哪里收集
        }
        for (int i = startIndex; i < nums.length; i++) {
            if (i == 0) path.add(nums[i]);
            if (i > 0 && nums[i-1] <= nums[i]){
                path.add(nums[i]);//只有满足条件才往path里面放,但是这样写第一个元素怎么进来啊
            }
            //往下一层进行探索
            backtracking(nums,i+1);
            //回溯
            path.remove(path.size()-1);
        }
    }
}

package com.lulu.LeetCodeTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * @author 陆涛
 * @version 1.0
 */
public class T40Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] can = new int[]{10,1,2,7,6,1,5};
        s.combinationSum2(can,8);
    }
}
class Solution {
    private List<Integer> path = new ArrayList<>();
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        boolean[] used = new boolean[candidates.length];//初始化默认为false
        Arrays.sort(candidates);
        backtracing(candidates,target,0,0,used);
        return result;
    }
    private void backtracing(int[] candidates,int target,int currentSum,int startIndex,boolean[] used){
        if (currentSum > target){
            return;
        }
        if (currentSum == target){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < candidates.length && currentSum + candidates[i] <= target; i++) {
            if (i > 0 && candidates[i] == candidates[i-1] && used[i - 1] == false){
                continue;//证明同一层遇到相同的了
            }
            currentSum += candidates[i];
            path.add(candidates[i]);
            used[i] = true;
            backtracing(candidates,target,currentSum,i + 1,used);
            currentSum -= candidates[i];//进行回溯
            used[i] = false;
            path.remove(path.size() - 1);
        }
    }
}
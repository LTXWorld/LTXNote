package main

/**
给定一个含有 n 个正整数的数组和一个正整数 target 。
找出该数组中满足其和 ≥ target 的长度最小的
连续子数组 [numsl, numsl+1, ..., numsr-1, numsr]
并返回其长度。如果不存在符合条件的子数组，返回 0
**/
import "math"

func MinLength(target int, nums []int) int {
	start, sum, miniLength := 0, 0, math.MaxInt32
	for end := 0; end < len(nums); end++ {
		sum += nums[end]
		for sum >= target {
			//更新最小长度
			if end-start+1 < miniLength {
				miniLength = end - start + 1
			}
			sum -= nums[start]
			start++
		}
	}
	if miniLength == math.MaxInt32 {
		return 0
	}
	return miniLength
}

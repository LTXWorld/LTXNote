package main

import (
	"fmt"
)

var (
	res   [][]int
	path  []int
	state []bool
)

func permute(nums []int) [][]int { //这里的[][]int是返回类型
	res, path = make([][]int, 0), make([]int, 0, len(nums))
	state = make([]bool, len(nums)) //上下的make怎么语法有点不一样
	dfs(nums, 0)
	return res
}
func dfs(nums []int, cur int) {
	if cur == len(nums) {
		tmp := make([]int, len(path)) //make以及局部变量的赋值方法
		copy(tmp, path)
		res = append(res, tmp)
		return
	}
	for i := 0; i < len(nums); i++ {
		if !state[i] {
			path = append(path, nums[i])
			state[i] = true
			dfs(nums, cur+1)
			state[i] = false
			path = path[:len(path)-1] //这里的回溯怎么直接上：？
		}
	}
}

func main() {
	nums := []int{1, 2, 3}
	result := permute(nums)
	fmt.Println(result)
}

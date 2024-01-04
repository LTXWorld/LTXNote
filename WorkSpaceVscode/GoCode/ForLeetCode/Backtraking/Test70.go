package main

func combine(n int, k int) [][]int {
	var result [][]int
	var path []int
	var backtraking func(int, int)

	backtraking = func(startIndex int, k int) {
		if len(path) == k { //这里是结束条件
			combination := make([]int, len(path)) //为什么不直接将path append到result里面呢
			copy(combination, path)               //将path全部复制进combination当中
			result = append(result, combination)
			return
		}
		//处理结点
		for i := startIndex; i <= n; i++ {
			path = append(path, i)
			backtraking(i+1, k)
			path = path[:len(path)-1] //remove the last,这个语法是否有些？
		}
	}
	backtraking(1, k)
	return result
}

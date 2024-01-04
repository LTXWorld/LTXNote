package main

func CombinationSum(k int, n int) [][]int {
	var result [][]int
	var path []int
	var backtraking func(k int, n int, startIndex int, currentSum int)

	backtraking = func(k int, n int, startIndex int, currentSum int) {
		//结束条件
		if len(path) == k {
			if currentSum == n {
				combination := make([]int, len(path)) //make[type,size]
				copy(combination, path)
				result = append(result, combination)
			}
			return
		}
		//处理结点
		for i := startIndex; i <= 9-(k-len(path))+1; i++ {
			path = append(path, i)
			currentSum += i

			if currentSum > n {
				return //剪枝
			}
			backtraking(k, n, i+1, currentSum)
			//回溯
			currentSum -= i
			path = path[:len(path)-1]
		}
	}
	return result
}

package main

func CombinationSumRepeat(candidates []int, target int) [][]int {
	var path []int
	var result [][]int
	var backtracking func(target int, candidates []int, currentSum int, startIndex int)

	backtracking = func(target int, candidates []int, currentSum int, startIndex int) {
		if currentSum > target {
			return
		}
		if currentSum == target {
			combination := make([]int, len(path))
			copy(combination, path)
			result = append(result, combination)
			return
		}
		//
		for i := startIndex; i < len(candidates); i++ {
			currentSum += candidates[i]
			path = append(path, candidates[i])
			backtracking(target, candidates, currentSum, i) //Allow repeating
			//
			currentSum -= candidates[i]
			path = path[:len(path)-1]
		}
	}
	return result
}

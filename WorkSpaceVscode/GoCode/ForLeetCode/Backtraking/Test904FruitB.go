package main

func totalFruit(fruits []int) int {
	if len(fruits) == 0 {
		return 0
	}

	max := 1
	fruitMap := make(map[int]int) // Renamed variable 'map' to 'fruitMap'
	i, j := 0, 0

	for j < len(fruits) {
		if len(fruitMap) <= 2 {
			fruitMap[fruits[j]] = j
			j++
		}
		if len(fruitMap) > 2 {
			min := len(fruits) - 1
			for _, value := range fruitMap {
				if value < min {
					min = value
				}
			}
			i = min + 1
			delete(fruitMap, fruits[min])
		}
		if j-i > max {
			max = j - i
		}
	}
	return max
}

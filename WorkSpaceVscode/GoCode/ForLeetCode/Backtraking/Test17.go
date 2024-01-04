package main

func combinationLetters(digits string) []string {
	var result []string
	var path string
	wordsMap := []string{
		"",
		"",
		"abc",
		"def",
		"ghi",
		"jkl",
		"mno",
		"pqrs",
		"tuv",
		"wxyz",
	}
	var backtraking func(digits string, index int)
	backtraking = func(digits string, index int) {
		if index == len(digits) {
			result = append(result, path)
			return
		}
		//
		digit := int(digits[index] - '0')
		words := wordsMap[digit]

		for i := 0; i < len(words); i++ {
			path += string(words[i]) //为什么还要使用string强转
			backtraking(digits, index+1)
			path = path[:len(path)-1]
		}
	}
	backtraking(digits, 0)
	return result
}

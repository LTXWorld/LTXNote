package main

// 将数组中的0全部移动到末尾
func moveZeros(nums []int) {
	i, j := 0, 0
	for j < len(nums) {
		if nums[j] == 0 {
			j++
		} else {
			if i != j {
				nums[i], nums[j] = nums[j], nums[i]
			}
			i++
			j++ //j用来标记当前工作指针走到哪，i用来标记非零位置
		}
	}
}

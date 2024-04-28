package solutions

import (
	"slices"
)

// Permutate using heaps algorithm
func permutateHeaps(nums []int, size int, acc *[][]int) {
	if size == 1 {
		*acc = append(*acc, slices.Clone(nums))
		return
	}
	for i := 0; i < size; i++ {
		permutateHeaps(nums, size-1, acc)

		temp := nums[size-1]
		if size%2 == 0 {
			nums[size-1] = nums[i]
			nums[i] = temp
		} else {
			nums[size-1] = nums[0]
			nums[0] = temp
		}
	}
}

func permute(nums []int) [][]int {
	result := [][]int{}
	permutateHeaps(nums, len(nums), &result)
	return result
}

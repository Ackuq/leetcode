package solutions

func searchEnd(nums []int, target int, start bool) int {
	left := 0
	right := len(nums) - 1

	result := -1

	for left <= right {
		mid := (left + right) / 2

		if nums[mid] > target {
			right = mid - 1
			continue
		}
		if nums[mid] < target {
			left = mid + 1
			continue
		}
		result = mid
		if start {
			right = mid - 1
			continue
		}
		left = mid + 1
	}
	return result
}

func searchRange(nums []int, target int) []int {
	return []int{searchEnd(nums, target, true), searchEnd(nums, target, false)}
}

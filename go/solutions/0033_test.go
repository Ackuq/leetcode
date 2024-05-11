package solutions

func search(nums []int, target int) int {
	left := 0
	right := len(nums) - 1

	for left <= right {
		mid := (left + right) / 2
		if nums[mid] == target {
			return mid
		}
		// Left half is sorted
		if nums[left] <= nums[mid] {
			// Target is between left and mid
			if nums[left] <= target && target < nums[mid] {
				right = mid - 1
				continue
			}
			left = mid + 1
			continue
		}
		// Target is between mid and right
		if nums[mid] < target && target <= nums[right] {
			left = mid + 1
			continue
		}
		right = mid - 1

	}
	return -1
}

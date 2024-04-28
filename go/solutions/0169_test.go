package solutions

func majorityElement(nums []int) int {
	var result int
	count := 0

	for _, num := range nums {
		if count == 0 {
			result = num
		}
		if num == result {
			count++
		} else {
			count--
		}
	}
	return result
}

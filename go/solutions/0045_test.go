package solutions

import (
	"math"
	"testing"
)

func jumpDynamic(i int, nums *[]int, memory *map[int]int) int {
	// Base case: we are at the end
	if i == len(*nums)-1 {
		return 0
	}
	if value, ok := (*memory)[i]; ok {
		return value
	}

	min := math.MaxInt16 - 1
	for j := 1; j <= (*nums)[i] && j+i < len(*nums); j++ {
		result := 1 + jumpDynamic(i+j, nums, memory)
		if result < min {
			min = result
		}
	}
	(*memory)[i] = min
	return min
}

func jump(nums []int) int {
	// Memory of number of jumps from index to end
	memory := map[int]int{}
	return jumpDynamic(0, &nums, &memory)
}

func TestJump1(t *testing.T) {
	nums := []int{2, 3, 1, 1, 4}

	actual := jump(nums)
	expected := 2
	if actual != expected {
		t.Fail()
	}
}

func TestJump2(t *testing.T) {
	nums := []int{2, 3, 0, 1, 4}

	actual := jump(nums)
	expected := 2
	if actual != expected {
		t.Fail()
	}
}

func TestJump3(t *testing.T) {
	nums := []int{1, 2}

	actual := jump(nums)
	expected := 1
	if actual != expected {
		t.Fail()
	}
}

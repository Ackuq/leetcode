package solutions

import "testing"

func removeElement(nums []int, val int) int {
	newIndex := 0
	for _, num := range nums {
		if num != val {
			nums[newIndex] = num
			newIndex += 1
		}
	}
	return newIndex
}

func TestRemoveElement1(t *testing.T) {
	nums := []int{3, 2, 2, 3}
	val := 3
	actual := removeElement(nums, val)
	expected := []int{2, 2}
	if actual != len(expected) {
		t.Fail()
	}
	for i, num := range expected {
		if num != nums[i] {
			t.Fail()
		}
	}
}

func TestRemoveElement2(t *testing.T) {
	nums := []int{0, 1, 2, 2, 3, 0, 4, 2}
	val := 2
	actual := removeElement(nums, val)
	expected := []int{0, 1, 3, 0, 4}
	if actual != len(expected) {
		t.Fail()
	}
	for i, num := range expected {
		if num != nums[i] {
			t.Fail()
		}
	}
}

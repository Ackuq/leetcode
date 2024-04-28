package solutions

func merge(nums1 []int, m int, nums2 []int, n int) {
	iEnd := m + n - 1
	for m > 0 && n > 0 {
		// If the last value of 2 is greater than the last of 1
		// it is the gratest value overall. Put it in the end
		if nums2[n-1] >= nums1[m-1] {
			nums1[iEnd] = nums2[n-1]
			n--
		} else {
			nums1[iEnd] = nums1[m-1]
			m--
		}
		iEnd--
	}
	// If there is values left in the right array, we need to insert them into the left array
	// We know that these values are empty since m = 0
	for n > 0 {
		nums1[iEnd] = nums2[n-1]
		n--
		iEnd--
	}
}

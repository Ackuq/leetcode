class MedianSortedArray {
    private fun median(nums: IntArray): Double {
        if (nums.size % 2 == 0) {
            return (nums[nums.size / 2] + nums[(nums.size - 1) / 2]) / 2.0
        }
        return nums[nums.size / 2].toDouble()
    }

    private fun merge(left: IntArray, right: IntArray): IntArray {
        val newList = mutableListOf<Int>()
        var leftIndex = 0
        var rightIndex = 0
        while (leftIndex < left.size || rightIndex < right.size) {
            val leftValue = if (leftIndex < left.size) left[leftIndex] else null
            val rightValue = if (rightIndex < right.size) right[rightIndex] else null
            if (leftValue == null) {
                newList.add(rightValue!!)
                rightIndex++
                continue
            }
            if (rightValue == null) {
                newList.add(leftValue)
                leftIndex++
                continue
            }
            if (rightValue < leftValue) {
                newList.add(rightValue)
                rightIndex++
                continue
            }
            leftIndex++
            newList.add(leftValue)
        }

        return newList.toIntArray()
    }

    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        return median(merge(nums1, nums2))
    }
}
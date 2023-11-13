class Solution4 {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        return binarySearch(nums1, nums2)
    }

    /**
     * O(n) solution
     */
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


    /**
     *  O(log(n)) solution
     */

    private fun binarySearch(A: IntArray, B: IntArray): Double {
        val n = A.size
        val m = B.size
        if (n > m) {
            // The left array must be smaller
            return binarySearch(B, A)
        }
        var start = 0
        var end = n
        val midIndex = (n + m + 1) / 2
        while (start <= end) {
            val mid = (start + end) / 2
            val leftASize = mid
            val leftBSize = midIndex - mid
            val leftA = if (leftASize > 0) A[leftASize - 1] else Int.MIN_VALUE
            val leftB = if (leftBSize > 0) B[leftBSize - 1] else Int.MIN_VALUE

            val rightA = if (leftASize < n) A[leftASize] else Int.MAX_VALUE
            val rightB = if (leftBSize < m) B[leftBSize] else Int.MAX_VALUE

            if (leftA <= rightB && leftB <= rightA) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(leftA, leftB) + Math.min(rightA, rightB)) / 2.0
                }
                return Math.max(leftA, leftB).toDouble()
            }
            if (leftA > rightB) {
                end = mid - 1
                continue
            }
            start = mid + 1
        }
        return 0.0
    }
}
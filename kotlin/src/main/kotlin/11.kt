import kotlin.math.abs
import kotlin.math.min

class Solution11 {
    private fun calculateArea(a: IndexedValue<Int>, b: IndexedValue<Int>): Int {
        val height = min(a.value, b.value)
        val width = abs(a.index - b.index)
        return height * width
    }

    fun maxArea(height: IntArray): Int {
        var max = 0

        var leftIndex = 0
        var rightIndex = height.size - 1

        while (leftIndex != rightIndex) {
            val left = height[leftIndex]
            val right = height[rightIndex]
            val area = calculateArea(
                IndexedValue(leftIndex, left),
                IndexedValue(rightIndex, right)
            )
            if (area > max) {
                max = area
            }
            if (left >= right) {
                rightIndex--
            } else {
                leftIndex++
            }
        }
        return max
    }
}
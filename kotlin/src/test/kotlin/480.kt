import kotlin.test.Test
import kotlin.test.assertContentEquals

class Solution480Test {
    private val subject = Solution480()

    @Test
    fun example1() {
        val nums = intArrayOf(1, 3, -1, -3, 5, 3, 6, 7)
        val k = 3

        val expected = doubleArrayOf(1.00000, -1.00000, -1.00000, 3.00000, 5.00000, 6.00000)
        val actual = subject.medianSlidingWindow(nums, k)
        assertContentEquals(actual, expected)
    }

    @Test
    fun example2() {
        val nums = intArrayOf(1, 4, 2, 3)
        val k = 4

        val expected = doubleArrayOf(2.50000)
        val actual = subject.medianSlidingWindow(nums, k)
        assertContentEquals(actual, expected)
    }

    @Test
    fun example3() {
        val nums = intArrayOf(2147483647, 2147483647)
        val k = 2

        val expected = doubleArrayOf(2147483647.00000)
        val actual = subject.medianSlidingWindow(nums, k)
        assertContentEquals(actual, expected)
    }
}
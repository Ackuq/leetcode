import kotlin.test.Test
import kotlin.test.assertEquals

class Solution215Test {
    private val subject = Solution215()

    @Test
    fun example1() {
        val nums = intArrayOf(3, 2, 1, 5, 6, 4)
        val k = 2

        val expected = 5
        val actual = subject.findKthLargest(nums, k)
        assertEquals(expected, actual)
    }

    @Test
    fun example2() {
        val nums = intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6)
        val k = 2

        val expected = 4
        val actual = subject.findKthLargest(nums, k)
        assertEquals(expected, actual)
    }
}
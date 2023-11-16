import kotlin.test.Test
import kotlin.test.assertEquals

class Solution15Test {
    private val subject = Solution15()

    @Test
    fun example1() {
        val nums = intArrayOf(-1, 0, 1, 2, -1, -4)
        val expected = listOf(
            listOf(-1, -1, 2),
            listOf(-1, 0, 1)
        )
        val actual = subject.threeSum(nums)
        assertEquals(expected, actual)
    }

    @Test
    fun example2() {
        val nums = intArrayOf(0, 1, 1)
        val expected = listOf<List<Int>>()
        val actual = subject.threeSum(nums)
        assertEquals(expected, actual)
    }

    @Test
    fun example3() {
        val nums = intArrayOf(0, 0, 0)
        val expected = listOf(listOf(0, 0, 0))
        val actual = subject.threeSum(nums =)
        assertEquals(expected, actual)
    }
}
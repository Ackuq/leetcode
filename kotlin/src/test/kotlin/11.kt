import kotlin.test.Test
import kotlin.test.assertEquals

class Solution11Test {
    private val subject = Solution11()

    @Test
    fun example1() {
        val expected = 49
        val actual = subject.maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7))
        assertEquals(expected, actual)
    }

    @Test
    fun example2() {
        val expected = 1
        val actual = subject.maxArea(intArrayOf(1, 1))
        assertEquals(expected, actual)
    }
}
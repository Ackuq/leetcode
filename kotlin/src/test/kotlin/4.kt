import kotlin.test.Test
import kotlin.test.assertEquals

class Solution4Test {
    private val subject = Solution4()

    @Test
    fun example1() {
        val expected = 2.0
        val actual = subject.findMedianSortedArrays(
            intArrayOf(1, 3),
            intArrayOf(2)
        )
        assertEquals(expected, actual)
    }

    @Test
    fun example2() {
        val expected = 2.5
        val actual = subject.findMedianSortedArrays(
            intArrayOf(1, 2),
            intArrayOf(3, 4)
        )
        assertEquals(expected, actual)
    }
}
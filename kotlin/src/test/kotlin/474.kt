import kotlin.test.Test
import kotlin.test.assertEquals

class Solution474Test {
    private val subject = Solution474()

    @Test
    fun example1() {
        val strs = arrayOf("10", "0001", "111001", "1", "0")

        val expected = 4
        val actual = subject.findMaxForm(strs, 5, 3)
        assertEquals(actual, expected)
    }

    @Test
    fun example2() {
        val strs = arrayOf("00011", "00001", "00001", "0011", "111")

        val expected = 4
        val actual = subject.findMaxForm(strs, 8, 5)
        assertEquals(actual, expected)
    }
}
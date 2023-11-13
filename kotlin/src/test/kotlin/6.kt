import kotlin.test.Test
import kotlin.test.assertEquals

class Solution6Test {
    private val subject = Solution6()

    @Test
    fun example1() {
        val expected = "PAHNAPLSIIGYIR"
        val actual = subject.convert("PAYPALISHIRING", 3)
        assertEquals(expected, actual)
    }

    @Test
    fun example2() {
        val expected = "PINALSIGYAHRPI"
        val actual = subject.convert("PAYPALISHIRING", 4)
        assertEquals(expected, actual)
    }

    @Test
    fun example3() {
        val expected = "A"
        val actual = subject.convert("A", 1)
        assertEquals(expected, actual)
    }
}
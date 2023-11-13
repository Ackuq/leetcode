import kotlin.test.Test
import kotlin.test.assertEquals

class Solution9Test {
    private val subject = Solution9()

    @Test
    fun example1() {
        val actual = subject.isPalindrome(424)
        val expected = true
        assertEquals(expected, actual)
    }
}
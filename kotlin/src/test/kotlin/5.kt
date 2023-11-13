import kotlin.test.Test
import kotlin.test.assertEquals

class Solution5Test {
    private val subject = Solution5()

    @Test
    fun example1() {
        val expected = "bab"
        val actual = subject.longestPalindrome("babad")
        assertEquals(expected, actual)
    }

    @Test
    fun example2() {
        val expected = "bb"
        val actual = subject.longestPalindrome("cbbd")
        assertEquals(expected, actual)
    }

    @Test
    fun example3() {
        val expected = "a"
        val actual = subject.longestPalindrome("ac")
        assertEquals(expected, actual)
    }

    @Test
    fun example4() {
        val expected = ""
        val actual = subject.longestPalindrome("")
        assertEquals(expected, actual)
    }
}
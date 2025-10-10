import kotlin.test.Test
import kotlin.test.assertEquals

class Solution125Test {
    private val subject = Solution125()

    @Test
    fun example1() {
        val s = "A man, a plan, a canal: Panama"

        val expected = true
        val actual = subject.isPalindrome(s)
        assertEquals(expected, actual)
    }

    @Test
    fun example2() {
        val s = "race a car"

        val expected = false
        val actual = subject.isPalindrome(s)
        assertEquals(expected, actual)
    }

    @Test
    fun example3() {
        val s = " "

        val expected = true
        val actual = subject.isPalindrome(s)
        assertEquals(expected, actual)
    }
}
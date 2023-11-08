import kotlin.test.Test
import kotlin.test.assertEquals

class LongestSubstringTest {
    private val subject = LongestSubstring()

    @Test
    fun example1() {
        val expected = 3
        val actual = subject.lengthOfLongestSubstring("abcabcbb")
        assertEquals(expected, actual)
    }

    @Test
    fun example2() {
        val expected = 1
        val actual = subject.lengthOfLongestSubstring("bbbbb")
        assertEquals(expected, actual)
    }

    @Test
    fun example3() {
        val expected = 3
        val actual = subject.lengthOfLongestSubstring("pwwkew")
        assertEquals(expected, actual)
    }

    @Test
    fun example4() {
        val expected = 1
        val actual = subject.lengthOfLongestSubstring(" ")
        assertEquals(expected, actual)
    }

    @Test
    fun example5() {
        val expected = 2
        val actual = subject.lengthOfLongestSubstring("au")
        assertEquals(expected, actual)
    }
}
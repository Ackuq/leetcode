import kotlin.test.Test
import kotlin.test.assertEquals

class Solution14Test {
    private val subject = Solution14()

    @Test
    fun example1() {
        val strs = arrayOf("flower", "flow", "flight")
        val expected = "fl"
        val actual = subject.longestCommonPrefix(strs)
        assertEquals(expected, actual)
    }

    @Test
    fun example2() {
        val strs = arrayOf("dog", "racecar", "car")
        val expected = ""
        val actual = subject.longestCommonPrefix(strs)
        assertEquals(expected, actual)
    }

    @Test
    fun example3() {
        val strs = arrayOf("ab", "a")
        val expected = "a"
        val actual = subject.longestCommonPrefix(strs)
        assertEquals(expected, actual)
    }

    @Test
    fun example4() {
        val strs = arrayOf("abc", "abc")
        val expected = "abc"
        val actual = subject.longestCommonPrefix(strs)
        assertEquals(expected, actual)
    }

}
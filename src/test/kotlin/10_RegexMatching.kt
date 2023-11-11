import kotlin.test.Test
import kotlin.test.assertEquals

class RegexMatchingTest {
    private val subject = RegexMatching()

    @Test
    fun example1() {
        val expected = false
        val actual = subject.isMatch("aa", "a")
        assertEquals(expected, actual)
    }

    @Test
    fun example2() {
        val expected = true
        val actual = subject.isMatch("aa", "a*")
        assertEquals(expected, actual)
    }

    @Test
    fun example3() {
        val expected = true
        val actual = subject.isMatch("ab", ".*")
        assertEquals(expected, actual)
    }

    @Test
    fun example4() {
        val expected = true
        val actual = subject.isMatch("aaaabbbb", "a*b*c*")
        assertEquals(expected, actual)
    }

    @Test
    fun example5() {
        val expected = true
        val actual = subject.isMatch("aab", "c*a*b")
        assertEquals(expected, actual)
    }

    @Test
    fun example6() {
        val expected = false
        val actual = subject.isMatch("mississippi", "mis*is*p*.")
        assertEquals(expected, actual)
    }

    @Test
    fun example7() {
        val expected = true
        val actual = subject.isMatch("bbbba", ".*a*a")
        assertEquals(expected, actual)
    }

}
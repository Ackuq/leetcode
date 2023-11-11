import kotlin.test.Test
import kotlin.test.assertEquals

class AtoiTest {
    private val subject = Atoi()

    @Test
    fun example1() {
        val expected = 42
        val actual = subject.myAtoi("42")
        assertEquals(expected, actual)
    }

    @Test
    fun example2() {
        val expected = -42
        val actual = subject.myAtoi("   -42")
        assertEquals(expected, actual)
    }

    @Test
    fun example3() {
        val expected = 4193
        val actual = subject.myAtoi("4193 with words")
        assertEquals(expected, actual)
    }

    @Test
    fun example4() {
        val expected = 0
        val actual = subject.myAtoi("words and 987")
        assertEquals(expected, actual)
    }

    @Test
    fun example5() {
        val expected = 0
        val actual = subject.myAtoi("")
        assertEquals(expected, actual)
    }

    @Test
    fun example6() {
        val expected = 0
        val actual = subject.myAtoi(" ")
        assertEquals(expected, actual)
    }
}
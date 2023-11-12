import kotlin.test.Test
import kotlin.test.assertEquals

class ReverseIntegerTest {
    private val subject = ReverseInteger()

    @Test
    fun example1() {
        val expected = 321
        val actual = subject.reverse(123)
        assertEquals(expected, actual)
    }

    @Test
    fun example2() {
        val expected = -321
        val actual = subject.reverse(-123)
        assertEquals(expected, actual)
    }

    @Test
    fun example3() {
        val expected = 21
        val actual = subject.reverse(120)
        assertEquals(expected, actual)
    }

    @Test
    fun example4() {
        val expected = 0
        val actual = subject.reverse(1534236469)
        assertEquals(expected, actual)
    }
}
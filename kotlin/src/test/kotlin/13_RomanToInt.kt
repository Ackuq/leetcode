import kotlin.test.Test
import kotlin.test.assertEquals

class RomanToIntTest {
    private val subject = RomanToInt()

    @Test
    fun example1() {
        val expected = 3
        val actual = subject.romanToInt("III")
        assertEquals(expected, actual)
    }

    @Test
    fun example2() {
        val expected = 58
        val actual = subject.romanToInt("LVIII")
        assertEquals(expected, actual)
    }

    @Test
    fun example3() {
        val expected = 1994
        val actual = subject.romanToInt("MCMXCIV")
        assertEquals(expected, actual)
    }
}
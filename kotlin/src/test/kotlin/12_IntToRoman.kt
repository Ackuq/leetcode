import kotlin.test.Test
import kotlin.test.assertEquals

class IntToRomanTest {
    private val subject = IntToRoman()

    @Test
    fun example1() {
        val expected = "III"
        val actual = subject.intToRoman(3)
        assertEquals(expected, actual)
    }

    @Test
    fun example2() {
        val expected = "LVIII"
        val actual = subject.intToRoman(58)
        assertEquals(expected, actual)
    }

    @Test
    fun example3() {
        val expected = "MCMXCIV"
        val actual = subject.intToRoman(1994)
        assertEquals(expected, actual)
    }
}
import kotlin.test.Test
import kotlin.test.assertEquals

class Solution482Test {
    private val subject = Solution482()

    @Test
    fun example1() {
        val s = "5F3Z-2e-9-w"
        val k = 4

        val expected = "5F3Z-2E9W"
        val actual = subject.licenseKeyFormatting(s, k)
        assertEquals(expected, actual)
    }


}
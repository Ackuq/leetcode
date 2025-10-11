import kotlin.test.Test
import kotlin.test.assertEquals

class Solution286Test {
    private val subject = Solution286()

    @Test
    fun example1() {
        val rooms = arrayOf(
            intArrayOf(2147483647, -1, 0, 2147483647),
            intArrayOf(2147483647, 2147483647, 2147483647, -1),
            intArrayOf(2147483647, -1, 2147483647, -1),
            intArrayOf(0, -1, 2147483647, 2147483647)
        )

        val expected = arrayOf(
            intArrayOf(3, -1, 0, 1),
            intArrayOf(2, 2, 1, -1),
            intArrayOf(1, -1, 2, -1),
            intArrayOf(0, -1, 3, 4)
        )
        subject.wallsAndGates(rooms)
        assertEquals(expected, rooms)
    }


}
import utils.ListNode
import kotlin.test.assertEquals
import kotlin.test.Test

class Solution2Test {
    private val subject = Solution2()

    @Test
    fun example1() {
        val expected = ListNode.fromList(listOf(7, 0, 8))
        val actual = subject.addTwoNumbers(
            ListNode.fromList(listOf(2, 4, 3)),
            ListNode.fromList(listOf(5, 6, 4))
        )
        assertEquals(expected.toString(), actual.toString())
    }

    @Test
    fun example2() {
        val expected = ListNode(0)
        val actual = subject.addTwoNumbers(
            ListNode(0),
            ListNode(0)
        )
        assertEquals(expected.toString(), actual.toString())
    }

    @Test
    fun example3() {
        val expected = ListNode.fromList(listOf(8, 9, 9, 9, 0, 0, 0, 1))
        val actual = subject.addTwoNumbers(
            ListNode.fromList(listOf(9, 9, 9, 9, 9, 9, 9)),
            ListNode.fromList(listOf(9, 9, 9, 9))
        )
        assertEquals(expected.toString(), actual.toString())
    }

    @Test
    fun example4() {
        val expected = ListNode.fromList(listOf(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1))
        val actual = subject.addTwoNumbers(
            ListNode.fromList(listOf(9)),
            ListNode.fromList(listOf(1, 9, 9, 9, 9, 9, 9, 9, 9, 9))
        )
        assertEquals(expected.toString(), actual.toString())
    }
}
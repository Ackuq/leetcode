import kotlin.test.Test
import kotlin.test.assertContentEquals

class TwoSumsTest {
    private val subject = TwoSums()

    @Test
    fun example1() {
        val expected = intArrayOf(1, 0)
        val nums = intArrayOf(2, 7, 11, 15)
        val target = 9
        val result = subject.twoSum(nums, target)

        assertContentEquals(expected, result)
    }

    @Test
    fun example2() {
        val expected = intArrayOf(2, 1)
        val nums = intArrayOf(3, 2, 4)
        val target = 6
        val result = subject.twoSum(nums, target)

        assertContentEquals(expected, result)
    }

    @Test
    fun example3() {
        val expected = intArrayOf(1, 0)
        val nums = intArrayOf(3, 3)
        val target = 6
        val result = subject.twoSum(nums, target)

        assertContentEquals(expected, result)
    }
}
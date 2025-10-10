import java.util.*

class Solution215 {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val queue = PriorityQueue<Int>(k)

        for (n in nums) {
            queue.add(n)
            if (queue.size > k) {
                queue.remove()
            }
        }

        return queue.first()
    }
}
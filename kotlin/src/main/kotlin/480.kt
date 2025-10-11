import java.util.*

class Solution480 {
    fun medianSlidingWindow(nums: IntArray, k: Int): DoubleArray {
        val medians = mutableListOf<Double>()

        val lows = PriorityQueue<Int>(reverseOrder())
        val highs = PriorityQueue<Int>()
        val table = hashMapOf<Int, Int>()

        var i = 0
        while (i < k) {
            lows.add(nums[i++])
        }
        for (j in 0..<k / 2) {
            highs.add(lows.remove())
        }
        while (true) {
            medians.add(
                if (k % 2 == 0) (lows.first().toLong() + highs.first()) / 2.toDouble() else lows.first().toDouble()
            )

            if (i >= nums.size) {
                break
            }

            val outNum = nums[i - k]
            val inNum = nums[i++]
            var balance = 0


            balance += if (outNum <= lows.first()) -1 else 1
            table[outNum] = table.getOrDefault(outNum, 0) + 1

            if (inNum <= lows.first()) {
                balance += 1
                lows.add(inNum)
            } else {
                balance -= 1
                highs.add(inNum)
            }

            if (balance < 0) {
                lows.add(highs.first())
                highs.remove()
            }
            if (balance > 0) {
                highs.add(lows.first())
                lows.remove()
            }

            while (table.getOrDefault(lows.first(), 0) > 0) {
                table[lows.first()] = table[lows.first()]!! - 1
                lows.remove()
            }
            while (!highs.isEmpty() && table.getOrDefault(highs.first(), 0) > 0) {
                table[highs.first()] = table[highs.first()]!! - 1;
                highs.remove()
            }
        }

        return medians.toDoubleArray()
    }
}
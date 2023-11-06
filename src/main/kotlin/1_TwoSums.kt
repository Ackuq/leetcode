import java.lang.Error

class TwoSums {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        nums.forEachIndexed { index, item ->
            val complement = target - item
            if (map.containsKey(complement)) {
               return intArrayOf(
                   index,
                   map[complement]!!
               )
            }
            map[item] = index
        }
        throw Error("No solution found")
    }
}


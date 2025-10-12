import kotlin.math.max

class Solution474 {
    fun findMaxForm(strs: Array<String>, m: Int, n: Int): Int {
        val counts = strs.map { s ->
            val zeroes = s.count { it == '0' }
            val ones = s.length - zeroes
            zeroes to ones
        }
        return findMaxFormRec(counts, 0, m, n, mutableMapOf())
    }

    fun findMaxFormRec(
        counts: List<Pair<Int, Int>>,
        i: Int,
        m: Int,
        n: Int,
        cache: MutableMap<Triple<Int, Int, Int>, Int>
    ): Int {
        if (i == counts.size) return 0
        val cacheKey = Triple(i, m, n)
        cache[cacheKey]?.let { return it }
        val (zeroes, ones) = counts[i]
        val taken = if (zeroes <= m && ones <= n) findMaxFormRec(counts, i + 1, m - zeroes, n - ones, cache) + 1 else 0
        val notTaken = findMaxFormRec(counts, i + 1, m, n, cache)
        return max(taken, notTaken).also { cache[cacheKey] = it }
    }
}
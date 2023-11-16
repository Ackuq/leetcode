import kotlin.math.min

class Solution14 {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) {
            return ""
        }
        if (strs.size == 1) {
            return strs[0]
        }
        val minSize = strs.minBy { it.length }.length

        var i = 0
        while (i < minSize) {
            val characters = strs.map { it[i] }
            if (characters.toSet().size > 1) {
                break
            }
            i++
        }
        return strs[0].substring(0, i)
    }
}
class LongestSubstring {
    fun lengthOfLongestSubstring(s: String): Int {
        var max = 0

        var left = 0
        var right = 1
        while (right <= s.length) {
            val substring = s.substring(left, right)

            val set = setOf(substring)
            if (set.size == substring.length) {
                if (set.size > max) {
                    max = set.size
                }
                right += 1
            } else {
                left += 1
                if (left == right) {
                    right += 1
                }
            }
        }

        return max
    }
}
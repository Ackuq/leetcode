class LongestPalindromicSubstring {
    private fun isPalindrome(s: String): Boolean {
        var left = 0
        var right = s.length - 1
        while (left < right) {
            if (s[left] != s[right]) {
                return false
            }
            left++
            right--
        }
        return true
    }

    fun longestPalindrome(s: String): String {
        // Edge case, empty string
        if (s.length == 0) return ""

        // Base case, just first character
        var max = s.substring(0, 1)

        for (currentIndex in 0..<s.length) {
            val current = s.elementAt(currentIndex)
            for (otherIndex in (currentIndex + max.length)..<s.length) {
                val other = s.elementAt(otherIndex)
                if (current != other) continue

                val substring = s.substring(currentIndex, otherIndex + 1)
                if (isPalindrome(substring)) {
                    max = substring
                }
            }
        }
        return max
    }
}
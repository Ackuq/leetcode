class Solution9 {
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


    fun isPalindrome(x: Int): Boolean {
        return isPalindrome(x.toString())
    }
}
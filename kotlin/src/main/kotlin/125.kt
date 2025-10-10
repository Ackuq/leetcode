class Solution125 {
    fun isPalindrome(s: String): Boolean {
        val filteredString = s.filter { it.isLetterOrDigit() }.lowercase()

        if (filteredString.isEmpty()) {
            return true
        }

        for (i in 0..(filteredString.length.floorDiv(2))) {
            if (filteredString[i] != filteredString[filteredString.length - 1 - i]) {
                return false
            }
        }

        return true
    }
}
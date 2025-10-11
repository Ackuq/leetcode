class Solution393 {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        if (ransomNote.length > magazine.length) {
            return false
        }

        val charCount = hashMapOf<Char, Int>()
        magazine.forEach {
            charCount[it] = charCount.getOrDefault(it, 0) + 1
        }

        ransomNote.forEach {
            val count = charCount.getOrDefault(it, 0)
            if (count == 0) {
                return false
            }
            charCount[it] = count - 1
        }

        return true
    }
}
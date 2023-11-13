import java.lang.NumberFormatException

class Solution8 {
    fun myAtoi(s: String): Int {
        // 1. Read in and ignore any leading whitespace.
        val trimmed = s.trim()
        if (trimmed.length == 0) {
            return 0
        }
        val array = trimmed.toMutableList()
        // 2. Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
        val firstChar = array.elementAt(0)
        val isNegative = firstChar == '-'
        if (firstChar == '-' || firstChar == '+') {
            array.removeFirst()
        }
        // 3. Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
        var digits = ""
        for (char in array) {
            if (!char.isDigit()) {
                break
            }
            digits += char
        }
        if (digits == "") {
            return 0
        }
        // 4. Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
        try {
            return if (isNegative) -digits.toInt() else digits.toInt()
        } catch (e: NumberFormatException) {
            return if (isNegative) Int.MIN_VALUE else Int.MAX_VALUE
        }
    }
}
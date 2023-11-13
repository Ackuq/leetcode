import java.lang.NumberFormatException

class Solution7 {
    fun reverse(x: Int): Int {
        val isNegative = x < 0
        try {
            val reversed = Math.abs(x).toString().reversed().toInt()
            return if (isNegative) -reversed else reversed
        } catch (e: NumberFormatException) {
            return 0
        }
    }
}
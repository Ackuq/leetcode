class RomanToInt {
    final val charMap = mapOf(
        'I' to 1,
        'V' to 5,
        'X' to 10,
        'L' to 50,
        'C' to 100,
        'D' to 500,
        'M' to 1000
    )

    final val rules = mapOf(
        'I' to setOf('V', 'X'),
        'X' to setOf('L', 'C'),
        'C' to setOf('D', 'M')
    )

    fun calculate(s: MutableList<Char>): Int {
        if (s.isEmpty()) return 0

        val current = s.removeFirst()
        var count = 1
        while (true) {
            if (s.isEmpty() || s[0] != current) {
                break
            }
            count++
            s.removeFirst()
        }
        val value = charMap[current]!! * count
        if (s.isEmpty()) {
            return value
        }
        val nextChar = s[0]
        val shouldSubtract = rules.containsKey(current) && rules[current]!!.contains(nextChar)
        return if (shouldSubtract) calculate(s) - value else calculate(s) + value
    }

    fun romanToInt(s: String): Int {
        val chars = s.toMutableList()
        return calculate(chars)
    }
}
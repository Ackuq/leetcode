class Solution10 {
    enum class Quantity {
        ONE, STAR
    }

    val memo: HashMap<Pair<Int, Int>, Boolean> = HashMap()

    data class Expression(val char: Char, val quantity: Quantity)

    private fun parseExpressions(tokens: CharArray): MutableList<Expression> {
        val expressions = mutableListOf<Expression>()

        tokens.withIndex().forEach {
            if (it.value == '*') {
                return@forEach
            }
            val char = it.value
            val isStarQuantity = it.index < (tokens.size - 1) && tokens[it.index + 1] == '*'
            expressions.add(Expression(char, if (isStarQuantity) Quantity.STAR else Quantity.ONE))
        }
        return expressions
    }

    private fun isMatch(s: Char, expression: Expression): Boolean {
        return expression.char == '.' || s == expression.char
    }

    fun isMatch(s: List<Char>, expressions: List<Expression>): Boolean {
        val key = Pair(s.size, expressions.size)
        if (memo.containsKey(key)) {
            return memo[key]!!
        }
        if (expressions.isEmpty()) {
            return s.isEmpty()
        }

        val currentExpression = expressions[0]
        val nextExpressions = expressions.subList(1, expressions.size)

        if (s.isEmpty()) {
            if (currentExpression.quantity == Quantity.ONE) {
                memo[key] = false
                return false
            }
            val res = isMatch(s, nextExpressions)
            memo[key] = res
            return res
        }

        val currentChar = s[0]
        val nextChars = s.subList(1, s.size)

        if (!isMatch(currentChar, currentExpression)) {
            if (currentExpression.quantity === Quantity.STAR) {
                val res = isMatch(s, nextExpressions)
                memo[key] = res
                return res
            }
            memo[key] = false
            return false
        }

        if (isMatch(nextChars, nextExpressions)) {
            memo[key] = true
            return true
        }

        if (currentExpression.quantity == Quantity.STAR && (isMatch(nextChars, expressions) || isMatch(
                s,
                nextExpressions
            ))
        ) {
            memo[key] = true
            return true
        }
        memo[key] = false
        return false
    }

    fun isMatch(s: String, p: String): Boolean {
        val expressions = parseExpressions(p.toCharArray())
        return isMatch(s.toMutableList(), expressions)
    }
}
class Solution509 {
    val cache = hashMapOf<Int, Int>()

    fun fib(n: Int): Int = cache.getOrPut(n) {
        when (n) {
            0, 1 -> n
            else -> fib(n - 1) + fib(n - 2)
        }
    }
}
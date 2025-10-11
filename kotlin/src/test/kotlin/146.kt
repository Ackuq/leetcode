import kotlin.test.Test

class Solution146Test {


    @Test
    fun example1() {
        val cache = LRUCache(1)
        cache.put(2, 1)
        cache.get(1)
    }
}
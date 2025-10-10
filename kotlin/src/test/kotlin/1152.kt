import kotlin.test.Test
import kotlin.test.assertEquals

class Solution1152Test {
    private val subject = Solution1152()

    @Test
    fun example1() {
        val usernames = arrayOf("joe", "joe", "joe", "james", "james", "james", "james", "mary", "mary", "mary")
        val timestamps = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val websites = arrayOf("home", "about", "career", "home", "cart", "maps", "home", "home", "about", "career")

        val expected = listOf("home", "about", "career")
        val actual = subject.mostVisitedPattern(usernames, timestamps, websites)
        assertEquals(expected, actual)
    }

    @Test
    fun example2() {
        val usernames = arrayOf("ua", "ua", "ua", "ub", "ub", "ub")
        val timestamps = intArrayOf(1, 2, 3, 4, 5, 6)
        val websites = arrayOf("a", "b", "a", "a", "b", "c")

        val expected = listOf("a", "b", "a")
        val actual = subject.mostVisitedPattern(usernames, timestamps, websites)
        assertEquals(expected, actual)
    }

    @Test
    fun example3() {
        val usernames = arrayOf("ua", "ua", "ua", "ub", "ub", "ub")
        val timestamps = intArrayOf(1, 2, 3, 4, 5, 6)
        val websites = arrayOf("a", "b", "c", "a", "b", "a")

        val expected = listOf("a", "b", "a")
        val actual = subject.mostVisitedPattern(usernames, timestamps, websites)
        assertEquals(expected, actual)
    }

    @Test
    fun example4() {
        val usernames = arrayOf("joe", "joe", "joe", "james", "james", "james", "james", "mary", "mary", "mary")
        val timestamps = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val websites = arrayOf("home", "about", "career", "home", "cart", "maps", "home", "home", "about", "career")

        val expected = listOf("home", "about", "career")
        val actual = subject.mostVisitedPattern(usernames, timestamps, websites)
        assertEquals(expected, actual)
    }

    @Test
    fun example5() {
        val usernames = arrayOf("zkiikgv", "zkiikgv", "zkiikgv", "zkiikgv")
        val timestamps = intArrayOf(436363475, 710406388, 386655081, 797150921)
        val websites = arrayOf("wnaaxbfhxp", "mryxsjc", "oz", "wlarkzzqht")

        val expected = listOf("oz", "mryxsjc", "wlarkzzqht")
        val actual = subject.mostVisitedPattern(usernames, timestamps, websites)
        assertEquals(expected, actual)
    }

    @Test
    fun example6() {
        val usernames = arrayOf("h", "eiy", "cq", "h", "cq", "txldsscx", "cq", "txldsscx", "h", "cq", "cq")
        val timestamps = intArrayOf(
            527896567,
            334462937,
            517687281,
            134127993,
            859112386,
            159548699,
            51100299,
            444082139,
            926837079,
            317455832,
            411747930
        )
        val websites = arrayOf(
            "hibympufi",
            "hibympufi",
            "hibympufi",
            "hibympufi",
            "hibympufi",
            "hibympufi",
            "hibympufi",
            "hibympufi",
            "yljmntrclw",
            "hibympufi",
            "yljmntrclw"
        )

        val expected = listOf("hibympufi", "hibympufi", "yljmntrclw")
        val actual = subject.mostVisitedPattern(usernames, timestamps, websites)
        assertEquals(expected, actual)
    }
}
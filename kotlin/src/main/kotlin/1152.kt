class Solution1152 {
    fun mostVisitedPattern(usernames: Array<String>, timestamps: IntArray, websites: Array<String>): List<String> {
        val triples = usernames.zip(timestamps.toList()).zip(websites) { (username, timestamp), website ->
            Triple(username, website, timestamp)
        }

        val sortedTriples = triples.sortedBy {
            it.third
        }

        val userPaths = sortedTriples.groupBy({ it.first }, { it.second })

        val counter = mutableMapOf<Triple<String, String, String>, Int>()

        for ((_, path) in userPaths) {
            val seen = mutableSetOf<Triple<String, String, String>>()
            for (i in 0..<path.size - 2) {
                for (j in i + 1..<path.size - 1) {
                    for (k in j + 1..<path.size) {
                        val triple = Triple(path[i], path[j], path[k])
                        if (triple in seen) {
                            continue
                        }
                        counter[triple] = counter.getOrPut(triple, { 0 }) + 1
                        seen.add(triple)
                    }
                }
            }
        }

        return counter.minWith(
            compareBy(
                { -it.value },
                { it.key.first },
                { it.key.second },
                { it.key.third })
        ).key.toList()
    }
}
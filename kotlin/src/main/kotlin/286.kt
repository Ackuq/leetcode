class Solution286 {
    data class Coord(val x: Int, val y: Int)

    fun wallsAndGates(rooms: Array<IntArray>): Unit {
        val queue = ArrayDeque<Pair<Coord, Int>>()
        val visited = mutableSetOf<Coord>()

        for (y in 0..<rooms.size) {
            for (x in 0..<rooms[y].size) {
                if (rooms[y][x] == 0) {
                    val coord = Coord(x, y)
                    queue.addLast(Pair(coord, 0))
                    visited.add(coord)
                }
            }
        }

        while (queue.isNotEmpty()) {
            val (coord, value) = queue.removeFirst()
            val (x, y) = coord
            rooms[y][x] = value

            for (adjacent in listOf(
                Coord(x - 1, y),
                Coord(x + 1, y),
                Coord(x, y + 1),
                Coord(x, y - 1)
            )) {
                if (
                    adjacent in visited ||
                    adjacent.y < 0 || adjacent.y >= rooms.size ||
                    adjacent.x < 0 || adjacent.x >= rooms[y].size ||
                    rooms[adjacent.y][adjacent.x] == -1
                ) {
                    continue
                }
                visited.add(adjacent)
                queue.addLast(Pair(adjacent, value + 1))
            }
        }
    }
}
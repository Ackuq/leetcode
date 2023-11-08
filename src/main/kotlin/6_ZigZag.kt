class ZigZag {
    /**
     * 1 row:
     *  ABCD
     *
     * 2 rows:
     *  AC
     *  BD
     *
     * 3 rows:
     *  A  E  I
     *  BD FH J
     *  C  G
     *
     * 4 rows:
     *  A   G
     *  B  FH
     *  CE  I
     *  D   J
     *
     */
    fun convert(s: String, numRows: Int): String {
        // Edge case, one row
        if (numRows == 1) return s

        val result = MutableList(numRows) { "" }

        var direction = 1
        var row = 0
        // Initialise list
        for (char in s) {
            result[row] = result[row] + char
            row += direction
            if (row == 0) {
                direction = 1
            }
            if (row == numRows - 1) {
                direction = -1
            }
        }
        return result.joinToString(separator = "")
    }
}
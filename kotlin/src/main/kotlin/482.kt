class Solution482 {
    fun licenseKeyFormatting(s: String, k: Int): String {
        val result = StringBuilder(s.replace("-", "").uppercase())
        var i = result.length - k
        while (i > 0) {
            result.insert(i, "-")
            i -= k
        }
        return result.toString()
    }
}
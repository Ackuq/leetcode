class MovingAverage(val size: Int) {
    var nums = mutableListOf<Int>()
    var sum = 0

    fun next(`val`: Int): Double {
        nums += `val`
        sum += `val`
        if (nums.size > size) {
            sum -= nums.removeAt(0)
        }
        return sum / nums.size.toDouble()
    }
}
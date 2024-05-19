package binary_search

class SquareRootEstimation {
    fun squareRoot(n: Int): Int {
        if (n == 0) return 0
        var left = 1
        var right = n
        var res = -1
        while (left <= right) {
            val mid = left + (right - left) / 2
            if (mid * mid == n) {
                return mid
            } else if (mid * mid > n) {
                res = mid
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return res - 1
    }
}

fun main() {
    val obj = SquareRootEstimation()
    val res = obj.squareRoot(8)
    println(res)
}
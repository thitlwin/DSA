package search.binary_search
/*Given an integer, find its square root without using the built-in square root function. Only return the integer part (truncate the decimals).

Input: 16

Output: 4

Input: 8

Output: 2

Explanation: square root of 8 is 2.83..., return the integer part, 2


*/
class SquareRootEstimation {
    fun squareRoot(n: Int): Int {
        if(n == 0) return 0
        var left = 1
        var right = n
        var result = 0
        while(left <= right) {
            val mid = left + (right - left)/2
            if(mid * mid == n) return mid
            if(mid * mid >= n) {
                right = mid - 1
                result = mid
            } else {
                left = mid + 1
            }
        }
        return result - 1;
    }
}

// TC = O(log n)

fun main() {
    val obj = SquareRootEstimation()
    println(obj.squareRoot(8))
}
package leetcode_problem_2485_pivot_sum

class UsingBinarySearchAndMath {
    fun pivotInteger(n: Int): Int {
        var left = 1
        var right = n
        val totalSum = n * (n+1) / 2
        while(left < right){
            val mid = (left + right) / 2
            if(mid * mid - totalSum < 0){
                left = mid + 1
            } else {
                right = mid
            }
        }

        if (left * left - totalSum == 0){
            return left
        } else {
            return -1
        }
    }
}

fun main() {
    val obj = UsingBinarySearchAndMath()
    println(obj.pivotInteger(4))
}
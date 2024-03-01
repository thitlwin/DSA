package leetcode_problem_2864_max_odd_binary_number

import java.util.*

class UsingSortAndSwapApproach2 {
    fun maximumOddBinaryNumber(s: String): String {
        val arr = s.toCharArray()
        val N = arr.size
        Arrays.sort(arr)
        val secondLast = N - 2
        for (i in 0 until N / 2) {
            val temp = arr[i]
            arr[i] = arr[secondLast - i]
            arr[secondLast - i] = temp
        }
        return String(arr)
    }
}

fun main() {
    val obj = UsingSortAndSwapApproach2()
    println(obj.maximumOddBinaryNumber("010"))
    println(obj.maximumOddBinaryNumber("0101"))
}
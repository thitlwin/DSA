package leetcode_problem_2485_pivot_sum

import kotlin.math.sqrt

class UsingMathFormula {
    fun pivotInteger(n: Int): Int {
        val sum = (n * (n + 1)/2)
        val pivot = sqrt(sum.toDouble()).toInt()
        return if (pivot * pivot == sum) pivot else -1
    }
}

fun main() {
    val obj = UsingMathFormula()
    println(obj.pivotInteger(9))
}
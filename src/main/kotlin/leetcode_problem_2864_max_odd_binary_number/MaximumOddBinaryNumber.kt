package leetcode_problem_2864_max_odd_binary_number

import java.lang.StringBuilder

class MaximumOddBinaryNumber {
    fun maximumOddBinaryNumber(s: String): String {
        val strBuilderFor1 = StringBuilder()
        val strBuilderFor0 = StringBuilder()
        s.forEach {
            if (it == '1')
                strBuilderFor1.append('1')
            else
                strBuilderFor0.append('0')
        }

        return strBuilderFor1.substring(1).plus(strBuilderFor0.toString()).plus('1')
    }
}

fun main() {
    val obj = MaximumOddBinaryNumber()
    println(obj.maximumOddBinaryNumber("010"))
    println(obj.maximumOddBinaryNumber("0101"))
}
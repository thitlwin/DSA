package leetcode_problem_402_remove_k_digits

import java.lang.StringBuilder

class RemoveKDigits {
    fun removeKdigits(num: String, k: Int): String {
        var count = k
        val stack = StringBuilder()
        for (digit in num) {
            while (count > 0 && stack.isNotEmpty() && stack[stack.length - 1] > digit) {
                stack.deleteCharAt(stack.length - 1)
                count--
            }
            stack.append(digit)
        }
        while (count > 0) {
            stack.deleteCharAt(stack.length - 1)
            count--
        }
        var nonZeroIndex = 0
        while (nonZeroIndex < stack.length && stack[nonZeroIndex] == '0') {
            nonZeroIndex++
        }
        val result = stack.substring(nonZeroIndex)
        return result.ifEmpty { "0" }
    }
}

fun main() {
    val obj = RemoveKDigits()
//    val result = obj.removeKdigits("1432219", 3)
//    val result = obj.removeKdigits("10200", 1)
    val result = obj.removeKdigits("9", 1)

    println(result)
}
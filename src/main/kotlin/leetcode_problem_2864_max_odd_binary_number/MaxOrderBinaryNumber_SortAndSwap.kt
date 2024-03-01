package leetcode_problem_2864_max_odd_binary_number

class MaxOrderBinaryNumber_SortAndSwap {
    fun maximumOddBinaryNumber(s: String): String {
        var charArr = s.toCharArray().sortedArray()
        val reversedStr = charArr.joinToString("")
        return reversedStr.substring(0,reversedStr.length - 1).reversed()+"1"
    }
}
fun main() {
    val obj = MaxOrderBinaryNumber_SortAndSwap()
    println(obj.maximumOddBinaryNumber("010"))
    println(obj.maximumOddBinaryNumber("0101"))
}
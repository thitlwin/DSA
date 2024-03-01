package leetcode_problem_2864_max_odd_binary_number

class ByCounting1s {
    fun maximumOddBinaryNumber(s: String): String {
        val N = s.length
        var oneCount = 0
        for (i in 0 until N){
            oneCount += s[i] - '0'
        }

        val sb = StringBuilder()
        for (i in 0 until oneCount - 1){
            sb.append("1")
        }

        for (i in 0 until N - oneCount){
            sb.append("0")
        }
        sb.append("1")
        return sb.toString()
    }
}

fun main() {
    val obj = ByCounting1s()
    println(obj.maximumOddBinaryNumber("010"))
//    println(obj.maximumOddBinaryNumber("0101"))
}
package backtracking.aggregation_and_memorization.decode_ways

class DecodeWay2 {
    fun decodeWays(digits: String): Int {
        val memo = IntArray(digits.length) { -1 }
        return dfs(digits, start = 0, memo)
    }

    private fun dfs(digits: String, start: Int, memo: IntArray): Int {
        if (start == digits.length) {
            return 1
        }
        if (memo[start] != -1) {
            return memo[start]
        }
        var result = 0
        for (end in start until digits.length) {
            val subStr = digits.substring(start, end + 1)
            if (subStr.startsWith('0')) {
                continue
            }
            val subDigit = subStr.toDouble()
            if (subDigit in 1.0..26.0) {
                result += dfs(digits, start + subStr.length, memo)
            }
        }
        memo[start] = result
        return result
    }
}

fun main() {
    val obj = DecodeWay2()
    println(obj.decodeWays("123")) // 3
//    println(obj.decodeWays("03")) // 0
//    println(obj.decodeWays("11223")) // 8
//    println(obj.decodeWays("313")) // 2
//    println(obj.decodeWays("111111111111111111111111111111111111111111111")) // TLE if not use memo
}
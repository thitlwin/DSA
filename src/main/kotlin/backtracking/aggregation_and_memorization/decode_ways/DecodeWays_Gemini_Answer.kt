package backtracking.aggregation_and_memorization.decode_ways

class DecodeWays_Using_IterativeApproach {
    fun decodeWays(digits: String): Int {
        if (digits.isEmpty() || digits[0] == '0') return 0

        val memo = IntArray(digits.length) { -1 }
        return dfs(0, digits, memo)
    }

    private fun dfs(startIndex: Int, digits: String, memo: IntArray): Int {
        if (startIndex == digits.length) return 1

        if (memo[startIndex] != -1) return memo[startIndex]

        var ways = if (digits[startIndex] == '0') 0 else dfs(startIndex + 1, digits, memo)

        if (startIndex + 1 < digits.length &&
            digits[startIndex] != '0' &&
            (digits[startIndex] - '0') * 10 + (digits[startIndex + 1] - '0') <= 26) {
            ways += dfs(startIndex + 2, digits, memo)
        }

        memo[startIndex] = ways
        return ways
    }
}

//fun main() {
//    val obj = DecodeWays_Using_IterativeApproach()
//
//    println(obj.decodeWays("123")) // 3
//    println(obj.decodeWays("03")) // 0
//    println(obj.decodeWays("11223")) // 8
//    println(obj.decodeWays("313")) // 2
//    println(obj.decodeWays("111111111111111111111111111111111111111111111")) // TLE if not use memo
//
//}
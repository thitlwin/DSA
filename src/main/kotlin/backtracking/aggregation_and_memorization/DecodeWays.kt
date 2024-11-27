package backtracking.aggregation_and_memorization

class DecodeWays {
    fun decodeWays(digits: String): Int {
        val memo = IntArray(digits.length){-1}
        return dfs(0, digits, memo)
    }

    private fun dfs(startIndex: Int, digits: String, memo: IntArray): Int {
        if (startIndex == digits.length) return 1
        if (memo[startIndex] != -1) return memo[startIndex]

        var ways = 0
        if (digits[startIndex] == '0') {
            return ways
        }

        ways += dfs(startIndex + 1, digits, memo)
        if (startIndex + 2 <= digits.length &&
            Integer.parseInt(digits.substring(startIndex, startIndex +2)) <= 26) {
            ways += dfs(startIndex + 2, digits, memo)
        }
        memo[startIndex] = ways
        return ways
    }
}

fun main() {
    val obj = DecodeWays()
//    println(obj.decodeWays("123")) // 3
//    println(obj.decodeWays("03")) // 0
//    println(obj.decodeWays("11223")) // 8
    println(obj.decodeWays("313")) // 2
}
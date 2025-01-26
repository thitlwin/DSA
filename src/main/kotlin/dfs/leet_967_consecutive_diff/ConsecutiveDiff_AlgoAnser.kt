package dfs.leet_967_consecutive_diff

class ConsecutiveDiff_AlgoAnser {
    fun numsSameConsecDiff(n: Int, k: Int): IntArray {
        val result: ArrayList<Int> = arrayListOf()
        for (num in 1..9) {
            dfs(n, k, 1, result, num)
        }
        return result.toIntArray()
    }

    private fun dfs(n: Int, k: Int, startIndex: Int, result: ArrayList<Int>, num: Int) {
        if (n == startIndex) {
            result.add(num)
            return
        }
        val currentDigit = num %  10
        if(currentDigit - k  >= 0){
            dfs(n, k,startIndex + 1, result, num * 10 + (currentDigit - k))
        } else if (currentDigit + k <= 9 && k != 0) {
            dfs(n, k,startIndex + 1, result, num * 10 + (currentDigit + k))
        }
    }
}

fun main() {
    val obj = ConsecutiveDiff_AlgoAnser()
    val res = obj.numsSameConsecDiff(2,0)
    println(res.joinToString())
}
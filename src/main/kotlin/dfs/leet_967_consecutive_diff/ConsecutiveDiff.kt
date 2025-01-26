package dfs.leet_967_consecutive_diff

import kotlin.math.abs

class ConsecutiveDiff {
    fun numsSameConsecDiff(n: Int, k: Int): IntArray {
        val result: MutableSet<Int> = mutableSetOf()
        for(firstDigit in 1..9) {
            dfs(n, k , start=firstDigit, path= arrayListOf(), result)
        }
        return result.toIntArray()
    }

    private fun dfs(n: Int, k: Int, start: Int, path: ArrayList<Int>, result: MutableSet<Int>) {
        if(path.size == n) {
            result.add(path.joinToString("").toInt())
            return
        }

        for(i in 0..9) {
            if(abs(i - start) == k) {
                path.add(start)
                dfs(n, k , i, path, result)
                path.removeLast()
            }
        }
    }
}

fun main() {
    val obj = ConsecutiveDiff()
//    println(obj.numsSameConsecDiff(3,7).joinToString())
    println(obj.numsSameConsecDiff(2,1).joinToString())
}
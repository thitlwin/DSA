package leetcode_problem_2932_trie

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

class BestAnswer2 {
    fun maximumStrongPairXor(nums: IntArray): Int {
        var result = 0
        for(x in nums)
            for (y in nums) {
                if (abs(x - y) <= min(x, y)){
                    result = max(result, x xor y)
                }
            }
        return result
    }
}

fun main() {
    val obj = BestAnswer2()
    val res = obj.maximumStrongPairXor(intArrayOf(1,2,3,4,5))
    println(res)
}
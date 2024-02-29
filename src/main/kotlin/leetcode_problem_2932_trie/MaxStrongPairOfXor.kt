package leetcode_problem_2932_trie

import kotlin.math.abs
import kotlin.math.min

class MaxStrongPairOfXor {
    fun maximumStrongPairXor(nums: IntArray): Int {
        var max = 0
        for(i in nums.indices) {
            for(j in nums.indices) {
                val x = nums[i]
                val y = nums[j]
                if(abs(x - y) <= min(x, y) && x xor y > max) {
                        max = x xor y
                }
            }
        }
        return max
    }
}

fun main() {
    val obj = MaxStrongPairOfXor()
    val res = obj.maximumStrongPairXor(intArrayOf(1,2,3,4,5))
    println(res)
}
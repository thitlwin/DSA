package leetcode_problem_2932_trie

import kotlin.math.abs
import kotlin.math.min

class BestAnswer1 {
        @OptIn(ExperimentalStdlibApi::class)
        fun maximumStrongPairXor(nums: IntArray): Int {
            var result = 0
            for (i in nums.indices)
                for (j in i + 1..<nums.size) {
                    val a = nums[i]
                    val b = nums[j]
                    if (a xor b > result && abs(a - b) <= min(a, b))
                        result = a xor b
                }
            return result
        }
}

fun main() {
    val obj = BestAnswer1()
    val res = obj.maximumStrongPairXor(intArrayOf(1,2,3,4,5))
    println(res)
}
package two_pointers.leet_209_min_subarr_sum

import kotlin.math.max
import kotlin.math.min

class MinSizeSubArraySum {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var left = 0
        var minSoFar = Int.MAX_VALUE
        var sum = 0
        for(right in nums.indices) {
            sum += nums[right]
            while(sum >= target) {
                minSoFar = min(minSoFar, right - left + 1)
                sum -= nums[left]
                left++
            }
        }
        return if(Int.MAX_VALUE ==  minSoFar) 0 else minSoFar
    }
}

fun main() {
    val obj = MinSizeSubArraySum()
    println(obj.minSubArrayLen(7, intArrayOf(2,3,1,2,4,3)))
}
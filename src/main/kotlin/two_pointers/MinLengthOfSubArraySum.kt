package two_pointers

import kotlin.math.min
//TC = O(n)
class MinLengthOfSubArraySum {
    fun minSubArrayLen(nums: List<Int>, target: Int): Int {
        var size = nums.size + 1
        var total = 0
        var left = 0
        for (right in nums.indices) {
            total += nums[right]
            while (total >= target) {
                size = min(size, right - left + 1)
                total -= nums[left]
                left++
            }
        }
        return if(size != nums.size+1) size else 0
    }
}

fun main() {
    val obj = MinLengthOfSubArraySum()
    println(obj.minSubArrayLen(listOf(2,3,1,2,4,3), 7))//2
//    println(obj.minSubArrayLen(listOf(1,4,4), 4))//2
}
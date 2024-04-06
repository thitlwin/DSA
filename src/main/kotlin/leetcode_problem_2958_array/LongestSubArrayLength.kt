package leetcode_problem_2958_array

import kotlin.math.max

class LongestSubArrayLength {
    fun maxSubarrayLength(nums: IntArray, k: Int): Int {
        var left = 0
        var result = 0
        val hm = HashMap<Int, Int>()
        for(right in nums.indices) {
            val key = nums[right]
            hm[key] = hm.getOrDefault(key, 0) + 1
            if(hm[nums[right]]!! > k){
                while (hm[nums[right]]!! > k){
                    hm[nums[left]] = hm[nums[left]]!! - 1
                    left++
                }
            }
            result = max(result, right - left + 1)
        }
        return result
    }
}

fun main() {
    val obj = LongestSubArrayLength()
    println(obj.maxSubarrayLength(intArrayOf(1,2,3,1,2,3,1,2),2))
    println(obj.maxSubarrayLength(intArrayOf(1,4,4,3),1))

}
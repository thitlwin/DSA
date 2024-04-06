package leetcode_problem_992_subarrays_with_k

class SubArrayWithKCount {
    fun subarraysWithKDistinct(nums: IntArray, k: Int): Int {
        return slidingWindowAtMost(nums,k) - slidingWindowAtMost(nums, k-1)
    }

    private fun slidingWindowAtMost(nums: IntArray, k: Int): Int {
        val freqMap = HashMap<Int,Int>()
        var left = 0
        var totalCount = 0
        for(right in nums.indices) {
            freqMap[nums[right]] = freqMap.getOrDefault(nums[right], 0) + 1

            while(freqMap.size > k) {
                freqMap[nums[left]] = freqMap[nums[left]]!! - 1
                if(freqMap[nums[left]] == 0) {
                    freqMap.remove(nums[left])
                }
                left++
            }
            totalCount += right - left + 1
        }
        return totalCount
    }
}

fun main() {
    val obj = SubArrayWithKCount()
    println(obj.subarraysWithKDistinct(intArrayOf(1,2,1,2,3),2))
//    println(obj.subarraysWithKDistinct(intArrayOf(1,2,1,3,4),3))

}
package leetcode_problem_2962_subarray_count

class LeetcodeEditorAnswer {
    fun countSubarrays(nums: IntArray, k: Int): Long {
        val maxElement = nums.maxOrNull()
        val indicesOfMaxElement = ArrayList<Int>()
        var result = 0L
        for(i in nums.indices) {
            if(nums[i] == maxElement) {
                indicesOfMaxElement.add(i)
            }
            val freq = indicesOfMaxElement.size
            if(freq >= k) {
                result += indicesOfMaxElement[freq - k] + 1
            }
        }
        return result
    }
}
fun main() {
    val obj = LeetcodeEditorAnswer()
//    println(obj.countSubarrays(intArrayOf(1,2,2,3,2), 2))//0
//    println(obj.countSubarrays(intArrayOf(1,3,2,3,3), 2))//0
//    println(obj.countSubarrays(intArrayOf(3,5,7,8,8,2), 2))//8

    println(obj.countSubarrays(intArrayOf(1,3,2,3,3), 2))//8
}
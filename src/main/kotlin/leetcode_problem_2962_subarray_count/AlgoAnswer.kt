package leetcode_problem_2962_subarray_count

class AlgoAnswer {
    fun countSubarrays(nums: IntArray, k: Int): Long {
        val maxNum = nums.maxOrNull()
        val n = nums.size
        var countOfSubarrays = 0L
        var maxCount = 0
        var right = 0
        for (left in 0 until n){
            while (right < n && maxCount < k) {
                if (nums[right] == maxNum){
                    maxCount++
                }
                right++
            }

            if (maxCount < k)
                break

            countOfSubarrays += n - right + 1
            if (nums[left] == maxNum){
                maxCount--
            }
        }
        return countOfSubarrays
    }
}

fun main() {
    val obj = AlgoAnswer()
    println(obj.countSubarrays(intArrayOf(1,2,2,3,2), 2))//0
//    println(obj.countSubarrays(intArrayOf(1,3,2,3,3), 2))//0
//    println(obj.countSubarrays(intArrayOf(3,5,7,8,8,2), 2))//8

}
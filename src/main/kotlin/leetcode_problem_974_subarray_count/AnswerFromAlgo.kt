package leetcode_problem_974_subarray_count

class AnswerFromAlgo {
    fun subarraysDivByK(nums: IntArray, k: Int): Int {
        val countMap = hashMapOf(0 to 1)
        var answer = 0
        var sum = 0
        for (num in nums) {
            sum = ((sum + num) % k + k) % k
            answer += countMap.getOrDefault(sum, 0)
//            countMap[sum] = (countMap[sum] ?: 0) + 1
            countMap[sum] = countMap.getOrDefault(sum, 0) + 1
        }
        return answer
    }
}

fun main() {
    val obj = AnswerFromAlgo()
    println(obj.subarraysDivByK(intArrayOf(4,5,0,-2,-3,1), 5))
}
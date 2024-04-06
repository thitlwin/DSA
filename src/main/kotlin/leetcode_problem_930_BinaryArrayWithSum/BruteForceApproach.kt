package leetcode_problem_930_BinaryArrayWithSum

class BruteForceApproach {
    fun numSubarraysWithSum(nums: IntArray, goal: Int): Int {
        var totalCount = 0
        var currentSum = 0
        val freq = HashMap<Int, Int>()
        for (n in nums) {
            currentSum += n
            if (currentSum == goal) {
                totalCount++
            }

            if (freq.containsKey(currentSum - goal)) {
                totalCount += freq[currentSum - goal] ?: 0
            }
            freq[currentSum] = freq.getOrDefault(currentSum, 0) + 1
        }
        return totalCount
    }
}
fun main() {
    val obj = BruteForceApproach()
//    println(obj.numSubarraysWithSum(intArrayOf(0,0,0,0,0,0,1,0,0,0), 0))
    println(obj.numSubarraysWithSum(intArrayOf(1,0,1,0,1), 2))
}
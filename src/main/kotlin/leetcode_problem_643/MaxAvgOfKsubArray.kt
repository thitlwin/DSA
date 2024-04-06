package leetcode_problem_643

import kotlin.math.max

class MaxAvgOfKsubArray {
        fun findMaxAverage(nums: IntArray, k: Int): Double {
            var answer = 0.0
            var kSum = 0.0
            for (i in 0 until k) {
                kSum += nums[i]
            }
            answer = kSum / k

            for(i in k until nums.size) {
                val left = i - k
                kSum += nums[i]
                kSum -= nums[left]
                answer = max(answer, kSum/k)
            }
            return answer
        }
}
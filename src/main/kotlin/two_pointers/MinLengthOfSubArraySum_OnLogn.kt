package two_pointers

import kotlin.math.min

// TC = O(n log n)
class MinLengthOfSubArraySum_OnLogn {
    fun minSubArrayLen(nums: List<Int>, target: Int): Int {
        val prefixSum = mutableListOf<Int>()
        for (n in nums)
            prefixSum.add(prefixSum[-1] + n)

        var size = nums.size + 1
        for (start in nums.indices) {
            val total = 0
            var l = 0
            var r = nums.size - 1
            var end = -1
            while (l <= r) {
                val mid = (l + r) / 2
                if (prefixSum[mid + 1] - prefixSum[start] >= target) {
                    end = mid
                    r = mid - 1
                } else
                    l = mid + 1
            }
            if (end != -1) size = min(size, end - start + 1)
        }
        return if (size != nums.size + 1) size else 0
    }
}

fun main() {
    val obj = MinLengthOfSubArraySum_OnLogn()
    println(obj.minSubArrayLen(listOf(2,3,1,2,4,3),7))
}
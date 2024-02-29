package two_pointers

class SlidingWindowLongest {
    fun subArraySumLongest(nums: List<Int>, target: Int): Int {
        var windowSum = 0
        var length = 0
        var left = 0
        for (right in nums.indices) {
            windowSum += nums[right]
            while (windowSum > target) {
                windowSum -= nums[left]
                ++left
            }
            length = length.coerceAtLeast(right - left + 1)
        }
        return length
    }
}

fun main() {
    val obj = SlidingWindowLongest()
    val res = obj.subArraySumLongest(listOf(1,6,3,1,2,4,1,1,2,3,5), 5)
    println(res)
}
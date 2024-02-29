package two_pointers

class SlidingWindow {
    fun maxSlidingWindow(nums: IntArray, k: Int): Int {
        var windowSum = 0

        for (i in 0 until k) {
            windowSum += nums[i]
        }
        var largest = windowSum
        for (right in k until nums.size) {
            val left = right - k
            windowSum = windowSum - nums[left] + nums[right]
            largest = maxOf(windowSum, largest)
        }
        return largest
    }
}

fun main() {
    val obj = SlidingWindow()
    println(obj.maxSlidingWindow(intArrayOf(7, 2, 89, 3, 7, 4, 8), 3))
}
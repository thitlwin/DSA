package leetcode_problem_215_maxHeap

class UsingSorting {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        nums.sortDescending()
        return nums[k - 1]
    }
}

fun main() {
    val obj = UsingSorting()
    println(obj.findKthLargest(intArrayOf(5, 7, 2, 1, 3, 9, 6, 7, 6), 2))//7
    println(obj.findKthLargest(intArrayOf(3, 2, 1, 5, 6, 4), 2))//5
}
package leetcode_problem_215_maxHeap

import java.util.*

class KLargestElement_BestAnswer1 {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val maxHeap = PriorityQueue<Int>(k, Collections.reverseOrder())
        maxHeap.addAll(nums.slice(0 until k))
        for (i in k until nums.size) {
            if (nums[i] > maxHeap.peek()) {
                maxHeap.poll()
                maxHeap.offer(nums[i])
            }
        }
        return maxHeap.peek()
    }
}

fun main() {
    val obj = KLargestElement_BestAnswer1()
//    println(obj.findKthLargest(intArrayOf(5, 7, 2, 1, 3, 9, 6, 7, 6), 2))//7
    println(obj.findKthLargest(intArrayOf(3, 2, 1, 5, 4), 2))//5
}
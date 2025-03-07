package heap.leet_215_maxHeap

import java.util.*
// Incorrect - the function returns the largest element, not kth largest
class ChatGptAnswer {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val maxHeap = PriorityQueue<Int>(Collections.reverseOrder())

        for (num in nums) {
            if (maxHeap.size < k) {
                maxHeap.offer(num)
            } else {
                if (num > maxHeap.peek()) {
                    maxHeap.poll()
                    maxHeap.offer(num)
                }
            }
        }

        return maxHeap.poll()
    }
}

fun main() {
    val obj = ChatGptAnswer()
//    println(obj.findKthLargest(intArrayOf(5, 7, 2, 1, 3, 9, 6, 7, 6), 2))//7
    println(obj.findKthLargest(intArrayOf(3, 2, 1, 5, 4, 6), 2))//5
}
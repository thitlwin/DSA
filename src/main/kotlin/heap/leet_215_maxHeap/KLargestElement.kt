package heap.leet_215_maxHeap

import java.util.Collections
import java.util.PriorityQueue

class KLargestElement {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val maxHeap = PriorityQueue<Int>(nums.size, Collections.reverseOrder())
        for (n in nums)
            maxHeap.add(n)
        for (i in 0 until k - 1){
            maxHeap.poll()
        }
        return maxHeap.poll()
    }
}

fun main() {
    val obj = KLargestElement()
//    println(obj.findKthLargest(intArrayOf(3, 2, 1, 5, 6, 4), 2))//5
    println(obj.findKthLargest(intArrayOf(5, 7, 2, 1, 3, 9, 6, 7, 6), 2))//7


}
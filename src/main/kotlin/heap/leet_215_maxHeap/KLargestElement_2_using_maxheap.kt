package heap.leet_215_maxHeap

import java.util.Collections
import java.util.PriorityQueue

class KLargestElement_2_using_maxheap {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val maxHeap: PriorityQueue<Int> = PriorityQueue(Collections.reverseOrder())
        nums.forEach {
            maxHeap.offer(it)
        }// TC = O(n.log.n)

        var res: Int = maxHeap.peek()
        for (i in 0 until k){
            res = maxHeap.poll()
        }// TC=O(k.log.n)
        return res
    }// SC=O(n), TC=O(n.log.n)
}
package heap.leet_215_maxHeap

import java.util.PriorityQueue

class KLargestElement_2_using_minHeap {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val minHeap: PriorityQueue<Int> = PriorityQueue()
        nums.forEach {
            minHeap.offer(it)// TC=O(log.k) , where heap size is limited to k size
            if (minHeap.size > k){
                minHeap.poll()//  TC=O(log.k)
            }
        }// TC=O(n.log.k), worst case: where k is n
        return minHeap.peek()
    }// SC=O(k), TC
}

fun main() {
    val obj = KLargestElement_2_using_minHeap()
    println(obj.findKthLargest(intArrayOf(3,2,1,5,6,4), 2))
}
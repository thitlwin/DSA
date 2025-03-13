package heap.leet_295_median_stream

import java.util.*

class MedianStream {
    val minHeap: PriorityQueue<Double> = PriorityQueue()
    val maxHeap = PriorityQueue<Double> { a, b -> b.compareTo(a) }
    fun addNum(num: Int) {
        if (minHeap.size == 0 || num < minHeap.peek()) {
            maxHeap.add(num.toDouble())
        } else {
            minHeap.add(num.toDouble())
        }
        balance()
    }

    private fun balance() {
        if (maxHeap.size < minHeap.size) {
            maxHeap.add(minHeap.poll())
        }
        if (maxHeap.size > minHeap.size + 1) {
            minHeap.add(maxHeap.poll())
        }
    }

    fun findMedian(): Double {
        return if (maxHeap.size == minHeap.size) {
            (maxHeap.peek() + minHeap.peek()) / 2.0
        } else {
            maxHeap.peek()
        }
    }
}

fun main() {
    val obj = MedianStream()
    obj.addNum(1)
    obj.addNum(2)
    obj.addNum(3)
    println(obj.findMedian())
    obj.addNum(4)
    println(obj.findMedian())
}
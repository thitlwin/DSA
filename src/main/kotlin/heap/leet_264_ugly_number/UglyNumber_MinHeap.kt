package heap.leet_264_ugly_number

import java.util.PriorityQueue

class UglyNumber_MinHeap {
    fun nthUglyNumber(n: Int): Int {
        val minHeap = PriorityQueue<Long>()
        val usedNumber: HashSet<Long> = hashSetOf() // SC=O(n)
        minHeap.add(1)
        usedNumber.add(1)
        repeat(n - 1) {
            val res = minHeap.poll()// O(n.logn)
            for (multiplier in arrayOf(2, 3, 5)) {
                if (!usedNumber.contains(res * multiplier)) {// TC=O(1)
                    minHeap.add(res * multiplier)// TC= O(3.logn)
                    usedNumber.add(res * multiplier)// TC=O(1)
                }
            }
        }
        return minHeap.poll().toInt()
    }
}

fun main() {
    val obj = UglyNumber_MinHeap()
//    println(obj.nthUglyNumber(10))
    println(obj.nthUglyNumber(1407))
}
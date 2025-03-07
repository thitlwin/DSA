package heap

import java.util.PriorityQueue

class HeapTop3 {
    fun heapTop3(arr: List<Int>): List<Int> {
        val heap: PriorityQueue<Int> = PriorityQueue(arr)
        val res: MutableList<Int> = mutableListOf()
        repeat(3){
            res.add(heap.poll())
        }
        return res
    }
}

fun main() {
    val obj = HeapTop3()
    val res = obj.heapTop3(listOf(3, 1, 2, 10, 33, 100, 20, 0))
    println(res.joinToString())
}
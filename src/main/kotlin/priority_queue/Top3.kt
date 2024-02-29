package priority_queue

import java.util.PriorityQueue

class Top3 {
    fun heapTop3(data: List<Int>): List<Int> {
        val res = mutableListOf<Int>()
        val heap = PriorityQueue(data)
        repeat(3) {
            res.add(heap.poll())
        }
        return res
    }
}

fun main() {
    val obj = Top3()
    val res= obj.heapTop3(listOf(3 ,1 ,2 ,10, 33, 100, 20))
    println(res.joinToString())
}
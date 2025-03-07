package heap

import java.util.PriorityQueue

class KClosestPoints {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val distanceComparator1 = compareBy<IntArray> { it[0] * it[0] + it[1] * it[1] }
        val heap: PriorityQueue<IntArray> = PriorityQueue(points.size, distanceComparator1)
        points.forEach {
            heap.add(it)
        }
        val res: MutableList<IntArray> = mutableListOf()
        repeat(k){
            res.add(heap.poll())
        }
        return res.toTypedArray()
    }
}

fun main() {
    val obj = KClosestPoints()
//    [[1,3],[-2,2]]
    val res = obj.kClosest(arrayOf(intArrayOf(1,3), intArrayOf(-2,2)), 1)
    res.forEach {
        println(it.joinToString())
    }
}
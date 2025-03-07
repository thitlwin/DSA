package heap

import java.util.PriorityQueue

class KClosetPoints_2 {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val maxHeap: PriorityQueue<IntArray> = PriorityQueue(k) { p1, p2 ->
            distanceToOrigin(p1) - distanceToOrigin(p2)
        }
        repeat(k) {
            println(it)
            maxHeap.add(points[it])
        }
        for (i in k until points.size) {
            var point = points[i]
            var furtestPointInHeap = maxHeap.peek()
            if (distanceToOrigin(point) > distanceToOrigin(furtestPointInHeap)) {
                maxHeap.poll()
                maxHeap.add(point)
            }
        }
        val res: MutableList<IntArray> = mutableListOf()
        while (maxHeap.size > 0) {
            res.add(maxHeap.poll())
        }
        res.reverse()
        return res.toTypedArray()
    }

    private fun distanceToOrigin(p: IntArray): Int {
        return -(p[0] * p[0] + p[1] * p[1])
    }
}

fun main() {
    val obj = KClosetPoints_2()
//    [[1,3],[-2,2]]
    val res = obj.kClosest(arrayOf(intArrayOf(1,3), intArrayOf(-2,2)), 1)
    res.forEach {
        println(it.joinToString())
    }
}
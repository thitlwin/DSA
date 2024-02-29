package leetcode_problem_1046

import java.util.*
import kotlin.math.abs

class LastStoneWeight {
    fun lastStoneWeight(stones: IntArray): Int {
        val maxHeap = PriorityQueue<Int>(reverseOrder())
        stones.forEach{
            maxHeap.add(it)
        }
        while(maxHeap.size > 1) {
            val x = maxHeap.poll()
            val y = maxHeap.poll()
            if (x != y)
                maxHeap.add(x - y)
        }

        return if(maxHeap.isEmpty()) 0 else maxHeap.poll()
    }
}

fun main() {
    val obj = LastStoneWeight()
    val res = obj.lastStoneWeight(intArrayOf(2,7,4,1,8,1))
    println(res)
}
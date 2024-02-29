package leetcode_problem_1921

import java.util.*

class Approach2Heap {
    fun eliminateMaximum(dist: IntArray, speed: IntArray): Int {
        val heap = PriorityQueue<Double>()
        for(i in dist.indices) {
            heap.add(dist[i].toDouble() / speed[i])
        }

        var ans = 0
        while(heap.isNotEmpty()) {
            if(heap.remove() <= ans) {
                break
            }
            ans++
        }
        return ans
    }
}
package leetcode_problem_1337

import java.util.*

class KWeakestRowInAMatrix {
    fun kWeakestRows(mat: Array<IntArray>, k: Int): IntArray {
        val minHeap = PriorityQueue<Pair<Int, Int>>(compareBy<Pair<Int, Int>> { it.second }.thenBy { it.first })
        for(i in mat.indices) {
            minHeap.offer(Pair(i, mat[i].count { it == 1 }))
        }

        val res = IntArray(k)
        for(i in 0 until k) {
            res[i] = minHeap.poll().first
        }
        return res
    }
}

fun main() {
    val obj = KWeakestRowInAMatrix()
    val arr = arrayOf(intArrayOf(1,0,0,0),intArrayOf(1,1,1,1),intArrayOf(1,0,0,0),intArrayOf(1,0,0,0))
    obj.kWeakestRows(arr, 2).forEach { print("$it ") }
}
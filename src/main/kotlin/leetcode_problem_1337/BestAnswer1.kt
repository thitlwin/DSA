package leetcode_problem_1337

import java.util.*

class BestAnswer1 {
    fun kWeakestRows(mat: Array<IntArray>, k: Int): IntArray {
        fun countOnes(array: IntArray): Int {
            var min = 0
            var max = array.size
            while (min < max) {
                val mid = min + (max - min) / 2
                if (array[mid] == 1) min = mid + 1 else max = mid
            }
            return min
        }

        val pq =
            PriorityQueue<IntArray> { a, b -> a[0].compareTo(b[0]).let { if (it != 0) it else a[1].compareTo(b[1]) } }
        for (i in mat.indices) {
            pq += intArrayOf(countOnes(mat[i]), i)
        }
        return IntArray(k) { pq.remove()[1] }
    }
}

fun main() {
    val obj = BestAnswer1()
    val arr = arrayOf(intArrayOf(1,0,0,0),intArrayOf(1,0,1,1),intArrayOf(1,0,0,0),intArrayOf(1,0,0,0))
    obj.kWeakestRows(arr, 2).forEach { print("$it ") }
}
package leetcode_problem_378

import java.util.PriorityQueue

class FindKthSmallestElementFromMatrix {
    fun kthSmallest(matrix: Array<IntArray>, k1: Int): Int {
        var k = k1
        val n = matrix.size
        val heap = PriorityQueue<IntArray>(Comparator { a, b ->
            matrix[a[0]][a[1]].compareTo(matrix[b[0]][b[1]])
        })
        heap.offer(intArrayOf(0,0))
        val columnTop = IntArray(n)
        val rowFirst = IntArray(n)
        while (k > 1) {
            k--
            val coords = heap.poll()
            val (row, column) = coords
            rowFirst[row] = column + 1
            // Add the item on the right to the theap if everything above it is processed
            if (column + 1 < n && columnTop[column + 1] == row) {
                heap.offer(intArrayOf(row, column + 1))
            }
            columnTop[column] = row + 1
            if (row + 1 < n && rowFirst[row + 1] == column) {
                heap.offer(intArrayOf(row + 1, column))
            }
        }
        val resCoords = heap.poll()
        return matrix[resCoords[0]][resCoords[1]]
    }
}

fun main() {
    val obj = FindKthSmallestElementFromMatrix()
//    val matrix = arrayOf(
//        intArrayOf(1,5,9),
//        intArrayOf(10,11,13),
//        intArrayOf(12,13,15)
//    )
//    println(obj.kthSmallest(matrix, 8))
    val matrix = arrayOf(
        intArrayOf(1,1),
        intArrayOf(1,5)
    )
    println(obj.kthSmallest(matrix, 4))
}
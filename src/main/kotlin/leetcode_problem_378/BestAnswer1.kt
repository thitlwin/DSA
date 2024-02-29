package leetcode_problem_378

import java.util.PriorityQueue

/*
* class Solution {
    fun kthSmallest(matrix: Array<IntArray>, k: Int): Int {
        val n = matrix.size
        var smallestIdx = k
        val minHeap = PriorityQueue<Triple<Int,Int,Int>>(){a,b -> a.first - b.first }
        for(row in 0 until minOf(k, n)){
            minHeap.offer(Triple(matrix[row][0],row,0))
        }

        var ans = minHeap.peek()
        while(smallestIdx > 0){
            ans = minHeap.poll()
            val (value, row, col) = ans
            if(col < n - 1){
                minHeap.offer(Triple(matrix[row][col+1], row, col+1))
            }
            smallestIdx--
        }
        return ans.first
    }
}
* */
class BestAnswer1 {
    fun kthSmallest(matrix: Array<IntArray>, k: Int): Int {
        val n = matrix.size
        var smallestIndex = k
        val minHeap = PriorityQueue<Triple<Int, Int, Int>> { t, t2 -> t.first - t2.first }
        for (row in 0 until minOf(k, n)){
            minHeap.offer(Triple(matrix[row][0], row, 0))
        }
        var ans = minHeap.peek()
        while (smallestIndex > 0) {
            ans = minHeap.poll()
            val (value, row, col) = ans
            if (col < n-1) {
                minHeap.offer(Triple(matrix[row][col+1], row, col + 1))
            }
            smallestIndex--
        }
        return ans.first
    }
}

fun main() {
    val obj = BestAnswer1()
    val matrix = arrayOf(
        intArrayOf(1,1),
        intArrayOf(1,5)
    )
    println(obj.kthSmallest(matrix, 3))
}
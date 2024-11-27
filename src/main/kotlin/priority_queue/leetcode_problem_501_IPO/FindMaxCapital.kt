package priority_queue.leetcode_problem_501_IPO

import java.util.PriorityQueue

class FindMaxCapital {
    fun findMaximizedCapital(k: Int, w: Int, profits: IntArray, capital: IntArray): Int {
        // create min-heap to keep track of projects based on required capital
        val minCapitalHeap = PriorityQueue<Pair<Int, Int>> { a, b -> a.first - b.first }

        // populate the min=heap with project info - each item is an array where
        // the first element is the capital required and the second element is the profit
        for (i in capital.indices) {
            minCapitalHeap.offer(Pair(capital[i], profits[i]))
        }

        val maxProfitHeap = PriorityQueue<Int> { a, b -> b - a }
        var prjCount = k
        var totalCapital = w
        while(prjCount-- > 0) {
            while (!minCapitalHeap.isEmpty() && minCapitalHeap.peek().first <= totalCapital) {
                maxProfitHeap.offer(minCapitalHeap.poll().second)
            }
            // if the max profit heap is empty, it means there are no project we can afford
            if (maxProfitHeap.isEmpty()) {
                break
            }
            // otherwise, take the most profitable project from the max profit heap
            totalCapital += maxProfitHeap.poll()
        }
        return totalCapital
    }
}

fun main() {
    val obj = FindMaxCapital()
//    println(obj.findMaximizedCapital(2,0, intArrayOf(1,2,3), intArrayOf(0,1,1)))
//    println(obj.findMaximizedCapital(1,0, intArrayOf(1,2,3), intArrayOf(1,1,2)))
    println(obj.findMaximizedCapital(3,0, intArrayOf(1,2,3), intArrayOf(0,1,2)))
}
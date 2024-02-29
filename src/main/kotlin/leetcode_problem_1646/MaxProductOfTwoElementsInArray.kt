package leetcode_problem_1646

import java.util.*

class MaxProductOfTwoElementsInArray {
    fun maxProduct(nums: IntArray): Int {
        val maxPriorityQueue = PriorityQueue<Int>(compareByDescending { it })
        nums.forEach {
            maxPriorityQueue.offer(it)
        }
        return (maxPriorityQueue.poll()-1) * (maxPriorityQueue.poll()-1)
    }
}

fun main() {
    val obj = MaxProductOfTwoElementsInArray()
    val res = obj.maxProduct(intArrayOf(3,4,5,2))
    println(res)
}
package leetcode_problem_3075_max_happiness_of_selected_children

import java.util.PriorityQueue
import kotlin.math.max

class Solution1_MaxHeap {
    fun maximumHappinessSum(happiness: IntArray, k: Int): Long {
        val maxHeap = PriorityQueue<Int>(compareByDescending { it })
        happiness.forEach { maxHeap.add(it) }
        var result = 0L
        repeat(k) {
            result += max(maxHeap.poll() - it, 0)
        }
        return result
    }
}

fun main() {
    val obj = Solution1_MaxHeap()
//    val res = obj.maximumHappinessSum(intArrayOf(2,98,45), 1)
    val res = obj.maximumHappinessSum(intArrayOf(1,2,3), 2)

    println(res)
}
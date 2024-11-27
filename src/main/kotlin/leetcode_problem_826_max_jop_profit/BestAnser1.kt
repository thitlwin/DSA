package leetcode_problem_826_max_jop_profit

import kotlin.math.max

class BestAnser1 {
    fun maxProfitAssignment(difficulty: IntArray, profit: IntArray, worker: IntArray): Int {
        val n = difficulty.size
        val jobProfile = Array(n) { Pair(0, 0) }
        for (i in 0 until n) {
            val pair = Pair(difficulty[i], profit[i])
            jobProfile[i] = pair
        }

        jobProfile.sortWith(compareBy { it.first })
        worker.sort()

        var maxProfit = 0
        var result = 0
        var jobIndex = 0
        for (i in worker.indices) {
            while (jobIndex < n && worker[i] >= jobProfile[jobIndex].first) {
                maxProfit = max(maxProfit, jobProfile[jobIndex].second)
                jobIndex++
            }
            result += maxProfit
        }
        return result
    }
}

fun main() {
    val obj = BestAnser1()
    val res = obj.maxProfitAssignment(
        intArrayOf(2,4,6,8,10),
        intArrayOf(10,20,30,40,50),
        intArrayOf(4,5,6,7)
    )
//    val res = obj.maxProfitAssignment(
//        intArrayOf(5, 50, 92, 21, 24, 70, 17, 63, 30, 53),
//        intArrayOf(68, 100, 3, 99, 56, 43, 26, 93, 55, 25),
//        intArrayOf(96, 3, 55, 30, 11, 58, 68, 36, 26, 1)
//    )
    println(res)
}
package leetcode_problem_826_max_jop_profit

import kotlin.math.max

class MaximizeJobProfit {
    fun maxProfitAssignment(difficulty: IntArray, profit: IntArray, worker: IntArray): Int {
        val jobProfile = ArrayList<Pair<Int, Int>>()
        jobProfile.add(Pair(0, 0))
        for (i in difficulty.indices) {
            jobProfile.add(Pair(difficulty[i], profit[i]))
        }

        // sort by difficulty values in descending order
        jobProfile.sortWith(compareBy { it.first })
        for (i in 0 until jobProfile.size - 1) {
            val maxProfit = max(jobProfile[i].second, jobProfile[i + 1].second)
            jobProfile[i + 1] = Pair(jobProfile[i + 1].first, maxProfit)
        }

        var netProfit = 0
        for (i in worker.indices) {
            val ability = worker[i]
            // find the job with just smaller or equal difficulty than ability
            var l = 0
            var r = jobProfile.size - 1
            var currentProfit = 0
            while (l <= r) {
                val mid = (l + r) / 2
                if (jobProfile[mid].first <= ability) {
                    currentProfit = max(currentProfit, jobProfile[mid].second)
                    l = mid + 1
                } else {
                    r = mid - 1
                }
            }
            netProfit += currentProfit
        }
        return netProfit
    }
}

fun main() {
    val obj = MaximizeJobProfit()
    val res = obj.maxProfitAssignment(intArrayOf(2,4,6,8,10), intArrayOf(10,20,30,40,50), intArrayOf(4,5,6,7))
    println(res)
}
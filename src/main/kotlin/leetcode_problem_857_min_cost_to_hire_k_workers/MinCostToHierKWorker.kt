package leetcode_problem_857_min_cost_to_hire_k_workers

import java.util.*
import kotlin.Comparator
import kotlin.collections.ArrayList

class MinCostToHierKWorker {
    fun mincostToHireWorkers(quality: IntArray, wage: IntArray, k: Int): Double {
        val n = quality.size
        var totalCost = Double.MAX_VALUE
        var currentTotalQuality = 0.0

        val wageToQualityRatio = ArrayList<Pair<Double, Int>>()
        for (i in 0 until n) {
            wageToQualityRatio.add(Pair(wage[i]/quality[i].toDouble(), quality[i]))
        }

        Collections.sort(wageToQualityRatio, Comparator.comparingDouble { it.first })
//        wageToQualityRatio.sortWith(compareBy(Pair<Double, Int>::first))

        // Use a priority queue to keep track of the highest quality workers
        val highestQualityWorkers = PriorityQueue<Int>(Comparator.reverseOrder())

        for (i in 0 until n) {
            highestQualityWorkers.add(wageToQualityRatio[i].second)
            currentTotalQuality += wageToQualityRatio[i].second

            // if we have more than k workers,
            // remove the one with the highest quality
            if (highestQualityWorkers.size > k) {
                currentTotalQuality -= highestQualityWorkers.poll()
            }

            // if we have exactly k workers,
            // calculate the total cost and update if it's the minimum
            if (highestQualityWorkers.size == k) {
                totalCost = minOf(totalCost, currentTotalQuality * wageToQualityRatio[i].first)
            }
        }
        return totalCost
    }
}

fun main() {
    val obj = MinCostToHierKWorker()
    val quality = intArrayOf(10,20,5)
    val wage = intArrayOf(70,50,30)

//    val quality = intArrayOf(3,1,10,10,1)
//    val wage = intArrayOf(4,8,2,2,7)
    println(obj.mincostToHireWorkers(quality, wage, 2))
}
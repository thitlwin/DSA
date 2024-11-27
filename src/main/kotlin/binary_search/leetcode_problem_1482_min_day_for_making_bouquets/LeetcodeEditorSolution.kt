package binary_search.leetcode_problem_1482_min_day_for_making_bouquets

import kotlin.math.max

class LeetcodeEditorSolution {
    private fun getNumOfBouquets(bloomDay: IntArray, mid: Int, k: Int): Int {
        var numberOfBouquets = 0
        var count = 0
        for (i in bloomDay.indices) {
            if (bloomDay[i] <= mid) {
                count++
            } else {
                count = 0
            }
            if (count == k) {
                numberOfBouquets++
                count = 0
            }
        }
        return numberOfBouquets
    }

    fun minDays(bloomDay: IntArray, m: Int, k: Int): Int {
        var start = 0
        var end = 0
        for (day in bloomDay) {
            end = max(end, day)
        }

        var minDays = -1
        while (start <= end) {
            val mid = (start + end) / 2
            if (getNumOfBouquets(bloomDay, mid, k) >= m) {
                minDays = mid
                end = mid - 1
            } else {
                start = mid + 1
            }
        }
        return minDays
    }
}

fun main() {
    val obj = LeetcodeEditorSolution()
//    val res = obj.minDays(intArrayOf(1, 10, 3, 10, 2), 3, 2)
//    val res = obj.minDays(intArrayOf(1, 10, 3, 10, 2), 3, 1) // 3
    val res = obj.minDays(intArrayOf(7,7,7,7,12,7,7), 2, 3) // 12
    println(res)
}
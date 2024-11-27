package binary_search.leetcode_problem_1482_min_day_for_making_bouquets

import kotlin.math.max
import kotlin.math.min

class MakingBouquets {
    fun minDays(bloomDay: IntArray, m: Int, k: Int): Int {
        if (m * k > bloomDay.size) {
            return -1
        }

        var minDay = Int.MAX_VALUE
        var maxDay = Int.MIN_VALUE
        for (day in bloomDay) {
            minDay = min(minDay, day)
            maxDay = max(maxDay, day)
        }

        var left = minDay
        var right = maxDay
        while (left < right) {
            val mid = (left + right) shr 1
            if (canMakeBouquets(bloomDay, m, k, mid)) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        return left
    }

    private fun canMakeBouquets(bloomDay: IntArray, numberOfBouquets: Int, bouquetSize: Int, currentDay: Int): Boolean {
        var bouquetsMade = 0
        var flowersInBouquet = 0
        for (day in bloomDay) {
            if (day <= currentDay) {
                flowersInBouquet++
                if (flowersInBouquet == bouquetSize) {
                    bouquetsMade++
                    flowersInBouquet = 0
                }
            } else {
                flowersInBouquet = 0
            }
        }
        return bouquetsMade >= numberOfBouquets
    }
}

fun main() {
    val obj = MakingBouquets()
//    val res = obj.minDays(intArrayOf(1, 10, 3, 10, 2), 3, 2)
//    val res = obj.minDays(intArrayOf(1, 10, 3, 10, 2), 3, 1) // 3
    val res = obj.minDays(intArrayOf(7,7,7,7,12,7,7), 2, 3)
    println(res)
}
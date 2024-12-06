package binary_search.leetcode_problem_875_BinarySearch

import kotlin.math.ceil

class KokoEatingBanana {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var left = 1
        var right = 1_000_000_000 // max is 10^9
        var result = -1
        while(left <= right) {
            val mid = (left + right)/2
            if(canFinishEating(piles,h,mid)){
                result = mid
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return result
    }

    private fun canFinishEating(piles: IntArray, h: Int, k: Int): Boolean {
        var hourUsed = 0.0
        for(pile in piles) {
            hourUsed += ceil(pile.toDouble()/k)
        }
        return hourUsed.toInt() <= h
    }
}

fun main() {
    val obj = KokoEatingBanana()
//    println(obj.minEatingSpeed(intArrayOf(3,6,7,11), 8))
//    println(obj.minEatingSpeed(intArrayOf(1000000000), 2))
    println(obj.minEatingSpeed(intArrayOf(805306368,805306368,805306368), 1000000000))

}
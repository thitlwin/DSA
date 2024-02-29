package leetcode_problem_2558

import kotlin.math.pow
import kotlin.math.sqrt

class BestAnswer1WithoutHeap {
    fun pickGifts(gifts: IntArray, k: Int): Long {
        var max = 0
        var maxIndex = 0
        repeat(k) {
            for (i in gifts.indices) {
                if (gifts[i] > max) {
                    max = gifts[i]
                    maxIndex = i
                }
            }
            gifts[maxIndex] = sqrt(max.toDouble()).toInt()
            max = 0
        }

        val mod = 10.0.pow(9.0) + 7
        return (gifts.sum() / mod).toLong()
    }
}

fun main() {
    val obj = BestAnswer1WithoutHeap()
    val res = obj.pickGifts(intArrayOf(25,64,9,4,100), 4)
    println(res)
}
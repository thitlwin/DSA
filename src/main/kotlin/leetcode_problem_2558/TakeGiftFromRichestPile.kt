package leetcode_problem_2558

import java.util.*
import kotlin.math.floor
import kotlin.math.sqrt

class TakeGiftFromRichestPile {
    fun pickGifts(gifts: IntArray, k: Int): Long {
        val maxHeap = PriorityQueue<Int>(Collections.reverseOrder())
        gifts.forEach {
            maxHeap.offer(it)
        }
        repeat(k) {
            val max = maxHeap.poll()
            maxHeap.offer(floor(sqrt(max.toDouble())).toInt())
        }
        return maxHeap.fold(0L){acc, i -> acc + i}
    }
}

fun main() {
    val obj = TakeGiftFromRichestPile()
    val res = obj.pickGifts(intArrayOf(25,64,9,4,100), 4)
    println(res)
}
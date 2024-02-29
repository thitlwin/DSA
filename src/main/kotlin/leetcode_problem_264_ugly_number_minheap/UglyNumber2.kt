package leetcode_problem_264_ugly_number_minheap

import java.util.PriorityQueue

class UglyNumber2 {
    private val allowedPrime = intArrayOf(2,3,5)
    fun nthUglyNumber(n: Int): Int {
        val ansHeap = PriorityQueue<Long>()
        val usedNum = HashSet<Long>()
        ansHeap.offer(1)
        usedNum.add(1)
        for (i in 0 until n-1){
            val res = ansHeap.poll()
            for (multiplier in allowedPrime) {
                if (!usedNum.contains(res * multiplier)) {
                    ansHeap.offer(res * multiplier)
                    usedNum.add(res * multiplier)
                }
            }
        }
        return ansHeap.poll().toInt()
    }
}

fun main() {
    val res = UglyNumber2()
    println(res.nthUglyNumber(1407))
}
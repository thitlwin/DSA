package leetcode_problem_786_kth_smallest_prime

import java.util.PriorityQueue

class KthSmallestPrime {
    fun kthSmallestPrimeFraction(arr: IntArray, k: Int): IntArray {
        val n = arr.size
        val priorityQueue = PriorityQueue<Fraction>()

        // initialize the priority queue with the smallest prime fractions
        for (i in 1 until n) {
            priorityQueue.offer(Fraction(arr[0], arr[i], 0, i))
        }

        // poll the queue k-1 times to get the kth smallest prime fraction
        for (count in 1 until k) {
            val fraction = priorityQueue.poll()
            if (fraction.numeratorIndex + 1 < fraction.denominatorIndex) {
                priorityQueue.offer(
                    Fraction(
                        arr[fraction.numeratorIndex + 1],
                        arr[fraction.denominatorIndex],
                        fraction.numeratorIndex + 1,
                        fraction.denominatorIndex
                    )
                )
            }
        }
        val kthSmallestFraction = priorityQueue.peek()
        return intArrayOf(kthSmallestFraction.numerator, kthSmallestFraction.denominator)
    }
}

data class Fraction(
    val numerator: Int,
    val denominator: Int,
    val numeratorIndex: Int,
    val denominatorIndex: Int
) : Comparable<Fraction> {
    override fun compareTo(other: Fraction): Int {
        return this.numerator * other.denominator - other.numerator * this.denominator
    }
}

fun main() {
    val obj = KthSmallestPrime()
    val res = obj.kthSmallestPrimeFraction(intArrayOf(1, 2, 3, 5), 3)
    println(res.joinToString())
}
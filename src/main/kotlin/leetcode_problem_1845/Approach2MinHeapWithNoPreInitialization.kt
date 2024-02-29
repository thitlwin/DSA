package leetcode_problem_1845

import java.util.PriorityQueue

class Approach2MinHeapWithNoPreInitialization(val n: Int)  {
    var marker = 1
    val availableSeats = PriorityQueue<Int>()
    fun reserve(): Int {
        if (availableSeats.isNotEmpty()) {
            return availableSeats.poll()
        }
        val seatNumber = marker
        marker++
        return seatNumber
    }

    fun unreserve(seatNumber: Int) {
        availableSeats.offer(seatNumber)
    }
}

/*
* T.C => O(m.log n)
* SP. C => O(n)
* */
package leetcode_problem_1845

import java.util.*

class Approach3SortedSet(val n: Int)  {
    var marker = 1
    val availableSeats = TreeSet<Int>()

    fun reserve(): Int {
        if (availableSeats.isNotEmpty()) {
            val seatNumber = availableSeats.first()
            availableSeats.remove(seatNumber)
            return seatNumber
        }
        val seatNumber = marker
        marker++
        return seatNumber
    }

    fun unreserve(seatNumber: Int) {
        availableSeats.add(seatNumber)
    }
}
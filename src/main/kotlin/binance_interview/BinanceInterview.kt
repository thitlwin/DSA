package binance_interview

/**
(Liam Z) Interviewer
https://app.coderpad.io/GQFYGPWN

In a row of seats, 1 represents a person sitting in that seat and 0 represents that the seat is empty.

There is at least one empty seat, and at least one person sitting.

Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized.

Return that maximum distance to closest person.

Example 1:

Input: [1,0,0,0,1,0,1] Output: 2 Explanation: If Alex sits in the second open seat(seats[2]), then the closest person has distance 2. If Alex sits in any other open seat, the closest person has distance 1. Thus, the maximum distance to the closest person is 2.

Example 2:

Input: [1,0,0,0] Output: 3 Explanation: If Alex sits in the last seat, the closest person is 3 seats away. This is the maximum distance possible, so the answer is 3.
 */
class BinanceInterview {
    fun maxDistToClosest(seats: IntArray): Int {
        var maxDistance = 0
        var prevPersonIndex = -1

        for(i in seats.indices) {
            if(seats[i] == 1) {
                if(prevPersonIndex == -1)
                {
                    maxDistance = i
                } else {
                    val distance = (i - prevPersonIndex) / 2
                    maxDistance = maxOf(maxDistance, distance)
                }
                prevPersonIndex = i
            }
        }

        return maxOf(maxDistance, seats.size - 1 - prevPersonIndex)
    }
}

fun main() {
    val obj = BinanceInterview()
    val res = obj.maxDistToClosest(intArrayOf(1,0,0,0,1,0,1))

//    val res = obj.maxDistToClosest(intArrayOf(1,0,0,0))
    println(res)
}
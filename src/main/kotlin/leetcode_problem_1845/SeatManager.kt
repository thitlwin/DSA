package leetcode_problem_1845

class SeatManager(val n: Int) {
    var noOfReserved = 0
    var returnedSeats = mutableListOf<Int>()

    fun reserve(): Int {
        noOfReserved++
        val smallestSeat = n - (n - noOfReserved)
        if (returnedSeats.isNotEmpty()) {
            val smallestFromReturnedSeat = returnedSeats.min()
            if(smallestFromReturnedSeat <= smallestSeat) {
                returnedSeats.remove(smallestFromReturnedSeat)
                return smallestFromReturnedSeat
            }
        }

        return smallestSeat
    }

    fun unreserve(seatNumber: Int) {
        noOfReserved--
        returnedSeats.add(seatNumber)
    }

}

/**
 * Your SeatManager object will be instantiated and called as such:
 * var obj = SeatManager(n)
 * var param_1 = obj.reserve()
 * obj.unreserve(seatNumber)
 */
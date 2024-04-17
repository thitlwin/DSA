package leetcode_problem_2073_TimeNeededToBuyTicket

import kotlin.math.min

class UsingOnePass {
    fun timeRequiredToBuy(tickets: IntArray, k: Int): Int {
        var totalTime = 0
        for (i in tickets.indices) {
            if (i <= k){
                totalTime += min(tickets[k], tickets[i])
            } else {
                totalTime += min(tickets[k] - 1, tickets[i])
            }
        }
        return totalTime
    }
}
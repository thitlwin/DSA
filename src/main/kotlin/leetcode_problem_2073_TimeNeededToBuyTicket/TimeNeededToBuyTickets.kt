package leetcode_problem_2073_TimeNeededToBuyTicket

import java.util.*

class TimeNeededToBuyTickets {
    fun timeRequiredToBuy(tickets: IntArray, k: Int): Int {
        val queue = LinkedList<Int>()
        for (i in tickets.indices){
            queue.add(i)
        }
        var time = 0
        while (queue.isNotEmpty()) {
            time++
            val front = queue.poll()
            tickets[front]--
            if(k == front && tickets[front] == 0){
                return time
            }

            if(tickets[front] != 0){
                queue.add(front)
            }
        }
        return time
    }
}

fun main() {
    val obj = TimeNeededToBuyTickets()
    println(obj.timeRequiredToBuy(intArrayOf(5,1,1,1), 0))
}
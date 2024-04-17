package leetcode_problem_2073_TimeNeededToBuyTicket

class WithoutQueue {
    fun timeRequiredToBuy(tickets: IntArray, k: Int): Int {
        var time = 0
        if(tickets[k] == 1)
            return k + 1
        while(tickets[k] > 0) {
            for(i in tickets.indices) {
                if(tickets[i] != 0) {
                    tickets[i]--
                    time++
                }
                if(tickets[k] == 0)
                    return time
            }
        }
        return time
    }
}
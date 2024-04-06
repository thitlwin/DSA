package leetcode_problem_621_cpu_cycle_interval

import java.util.Collections
import java.util.PriorityQueue

class CpuCycleInterval {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        val freq = IntArray(26)
        tasks.forEach {
            freq[it - 'A']++
        }

        val pq = PriorityQueue<Int>(Collections.reverseOrder())
        for (i in 0 until 26){
            if (freq[i] > 0)
                pq.offer(freq[i])
        }

        var time = 0
        while (!pq.isEmpty()) {
            var cycle = n + 1
            val store = ArrayList<Int>()
            var taskCount = 0
            while (cycle-- > 0 && !pq.isEmpty()){
                val currentFreq = pq.poll()
                if (currentFreq > 1) {
                    store.add(currentFreq - 1);
                }
                taskCount++
            }
            store.forEach(pq::offer)
            time += if(pq.isEmpty()) taskCount else n+1
        }
        return time
    }
}

fun main() {
    val obj = CpuCycleInterval()
//    println(obj.leastInterval(charArrayOf('A','A','A','B','B','B'), 2))
    println(obj.leastInterval(charArrayOf('A','C','A','B','D','B'), 1))
//    println(obj.leastInterval(charArrayOf('A','A','A','B','B','B'), 3))

}
package leetcode_problem_23_minHeap

import java.util.PriorityQueue

data class Element(val `val`: Int, val currentList: List<Int>, val headIndex: Int)
class MergeKSortedList {
    fun mergeKSortedLists(list: List<List<Int>>): List<Int> {
        val res = ArrayList<Int>()
        val heap = PriorityQueue<Element>(list.size, Comparator.comparing { it.`val` })
        for (l in list) {
            heap.add(Element(l[0], l, 0))
        }
        while (!heap.isEmpty()) {
            val e = heap.poll()
            res.add(e.`val`)
            val headIndex = e.headIndex + 1
            if (headIndex < e.currentList.size) {
                heap.add(Element(e.currentList[headIndex], e.currentList, headIndex))
            }
        }
        return res
    }
}

fun main() {
    val obj = MergeKSortedList()
    val res = obj.mergeKSortedLists(listOf(listOf(1, 3, 5), listOf(2, 4, 6), listOf(7, 10)))
    println(res.joinToString())
}
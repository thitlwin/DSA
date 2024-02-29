package leetcode_problem_1743

class RestoreArrayFromAdjacentPairs {
    fun restoreArray(adjacentPairs: Array<IntArray>): IntArray {
        val res = arrayListOf<Int>()
        val numMap = mutableMapOf<Int, MutableList<Int>>()
        for(pair in adjacentPairs) {
            val x = pair[0]
            val y = pair[1]
            if(!res.contains(x)){
                numMap[x] = mutableListOf(x)
                res.add(x)
            } else {
                numMap[x]?.add(x)
            }
            if(!res.contains(y)){
                numMap[y] = mutableListOf(y)
                res.add(y)
            } else {
                numMap[y]?.add(y)
            }
        }
        val headAndTail = numMap.filter { it.value.size == 1 }.keys.toIntArray()
        val start = headAndTail[0]
        val end = headAndTail[1]
        res.removeAll(arrayListOf(start, end).toSet())
        res.add(0, start)
        res.add(adjacentPairs.size, end)
        return res.toIntArray()
    }
}

fun main() {
    val obj = RestoreArrayFromAdjacentPairs()
    val res = obj.restoreArray(arrayOf(intArrayOf(2,1), intArrayOf(3,4), intArrayOf(3,2)))
    res.forEach { print("$it ") }
}
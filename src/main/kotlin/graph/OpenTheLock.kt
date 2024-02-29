package graph

class OpenTheLock {
    private val nextDigit = mapOf(
        '0' to '1',
        '1' to '2',
        '2' to '3',
        '3' to '4',
        '4' to '5',
        '5' to '6',
        '6' to '7',
        '7' to '8',
        '8' to '9',
        '9' to '0'
    )
    private val prevDigit = nextDigit.entries.associate { it.value to it.key }

    fun openLock(deadends: Array<String>, target: String): Int {
        if (target == "0000")
            return 0
        val deadendSet = HashSet(deadends.toList())
        val steps = hashMapOf<String, Int?>()
        steps["0000"] = 0
        val bfsQueue = ArrayDeque<String>()
        bfsQueue.add("0000")
        while (!bfsQueue.isEmpty()) {
            val top = bfsQueue.removeFirst()
            for (i in 0 until 4) {
                var newKey = "${top.substring(0, i)}${nextDigit[top[i]]}${top.substring(i + 1)}"
                if (!deadendSet.contains(newKey) && !steps.contains(newKey)) {
                    bfsQueue.add(newKey)
                    steps[newKey] = steps[top]?.plus(1)
                    if (newKey == target)
                        return steps[newKey] ?: 0
                }

                newKey = "${top.substring(0, i)}${prevDigit[top[i]]}${top.substring(i + 1)}"
                if (!deadendSet.contains(newKey) && !steps.containsKey(newKey)) {
                    bfsQueue.add(newKey)
                    steps[newKey] = steps[top]?.plus(1)
                    if (newKey == target) {
                        return steps[newKey] ?: 0
                    }
                }
            }
        }
        return -1
    }
}

fun main() {
    val obj = OpenTheLock()
//    println(obj.openLock(arrayOf("0009", "0090", "0900", "9000"), "9999")) //6
//    println(obj.openLock(arrayOf("0111", "2111", "1011", "1211", "1101", "1121", "1110", "1112"), "1111"))
//    println(obj.openLock(arrayOf("0000"), "8888")) // this function returns 8, but it should be -1. (according to leetcode)
    println(obj.openLock(arrayOf("8888"), "0009")) // 1
}
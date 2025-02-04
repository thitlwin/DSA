package graph.open_the_lock

import java.util.ArrayDeque

class OpenTheLock_2 {
        val nextKey = mapOf<Char, Char>('0' to '1', '1' to '2', '2' to '3', '3' to '4', '4' to '5',
            '5' to '6', '6' to '7','7' to '8', '8' to '9','9' to '0')
        val prevKey = nextKey.entries.associate{it.value to it.key}

        fun openLock(deadends: Array<String>, target: String): Int {
            val deadendSets = deadends.toSet()
            if(deadendSets.contains("0000")) {
                return -1
            }
            if(target == "0000") {
                return 0
            }
            val queue = ArrayDeque<String>()
            queue.add("0000")
            val steps: HashMap<String, Int> = HashMap()
            steps["0000"] = 0
            while(queue.isNotEmpty()) {
                val current = queue.removeFirst()
                for(i in 0 until 4) {
                    var newCombo = current.substring(0,i).plus(nextKey[current[i]!!]).plus(current.substring(i+1))
                    if(!deadendSets.contains(newCombo) && !steps.containsKey(newCombo)) {
                        queue.add(newCombo)
                        steps[newCombo] = steps[current]!! + 1
                        if(newCombo == target) {
                            return steps[newCombo]!!
                        }
                    }

                    newCombo = current.substring(0,i).plus(prevKey[current[i]!!]).plus(current.substring(i+1))
                    if(!deadendSets.contains(newCombo) && !steps.containsKey(newCombo)) {
                        queue.add(newCombo)
                        steps[newCombo] = steps[current]!! + 1
                        if(newCombo == target) {
                            return steps[newCombo]!!
                        }
                    }
                }
            }
            return -1
        }
//    val nextDigit: Map<Char, Char> = mapOf('0' to '1', '1' to '2', '2' to '3', '3' to '4', '4' to '5', '5' to '6', '6' to '7', '7' to '8', '8' to '9', '9' to '0')
//    val prevDigit:  Map<Char, Char> = nextDigit.entries.associate { it.value to it.key }
//
//    fun openLock(deadends: Array<String>, target: String): Int {
//        val deadendSet = deadends.toSet()
//        if (deadendSet.contains("0000")) {
//            return -1
//        }
//        if (target == "0000") {
//            return 0
//        }
//        val steps: HashMap<String, Int> = HashMap()
//        steps["0000"] = 0
//        val queue = ArrayDeque<String>()
//        queue.add("0000")
//        while (queue.isNotEmpty()) {
//            val current = queue.removeFirst()
//            for (i in 0 until 4) {
//                var newCombo = current.substring(0, i).plus(nextDigit[current[i]]).plus(current.substring(i+1))
//                if (!deadendSet.contains(newCombo) && !steps.containsKey(newCombo)) {
//                    queue.add(newCombo)
//                    steps[newCombo] = steps[current]!! + 1
//                    if (newCombo == target){
//                        return steps[newCombo]!!
//                    }
//                }
//
//                newCombo = current.substring(0, i).plus(prevDigit[current[i]]).plus(current.substring(i+1))
//                if (!deadendSet.contains(newCombo) && !steps.containsKey(newCombo)) {
//                    queue.add(newCombo)
//                    steps[newCombo] = steps[current]!! + 1
//                    if (newCombo == target){
//                        return steps[newCombo]!!
//                    }
//                }
//            }
//        }
//        return -1
//    }
}

fun main() {
    val obj = OpenTheLock_2()
//    println(obj.openLock(arrayOf("0201","0101","0102","1212","2002"), "0202"))
    println(obj.openLock(arrayOf("0000"), "8888"))

}